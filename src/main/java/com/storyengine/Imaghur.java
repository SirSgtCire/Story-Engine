package com.storyengine;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import javax.imageio.ImageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.css.RGBColor;


public class Imaghur {

    private static final Logger logger = LoggerFactory.getLogger(Imaghur.class);

    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/input.png";
        String outputFilePath = "src/main/resources/output.png";
        boolean sortDescending = true;
        int totalColors = 20;
        try {
            analyzeImage(inputFilePath, outputFilePath, sortDescending, totalColors);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void analyzeImage(String inputFilePath, String outputFilePath, boolean sortDescending, int totalColors) throws IOException {
        // Load input image
        logger.info("The image we were given and will use: {}\n", inputFilePath);
        BufferedImage inputImage = ImageIO.read(new File(inputFilePath));
        int imageWidth = inputImage.getWidth();
        int imageHeight = inputImage.getHeight();
        int numPixels = imageWidth * imageHeight;

        // Initialize data structures
        ArrayList<Point> visitedPixels = new ArrayList<>();
        Map<Color, Integer> colorCounts = new HashMap<>();

        // Analyze input image and count colors
        logger.info("Identify how many colors we find in our input image.\n");
        for (int y = 0; y < imageHeight; y++) {
            for (int x = 0; x < imageWidth; x++) {
                Color pixelColor = new Color(inputImage.getRGB(x, y));
                if (!colorCounts.containsKey(pixelColor)) {
                    colorCounts.put(pixelColor, 1);
                } else {
                    colorCounts.put(pixelColor, colorCounts.get(pixelColor) + 1);
                }
            }
        }

        // Sort colors by count in either ascending or descending order
        logger.info("Sort colors in descending or ascending order by pixel count.\n");
        List<Map.Entry<Color, Integer>> sortedColors = new ArrayList<>(colorCounts.entrySet());
        sortedColors.sort(sortDescending ? Map.Entry.comparingByValue(Comparator.reverseOrder()) : Map.Entry.comparingByValue());
        List<Map.Entry<Color, Integer>> usableSortedList = sortedColors.subList(0, Math.min(sortedColors.size(), totalColors));

        // Create output image
        logger.info("Create new image file for output.\n");
        BufferedImage outputImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = outputImage.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, imageWidth, imageHeight);

        // Gather a varying number of connected pixels based on the color percentage provided
        logger.info("Given descending order is set to {}, we gather a varying number of connected pixels to color in.\n", sortDescending);
        for (Map.Entry<Color, Integer> givenColor : usableSortedList) {
            ArrayList<Point> pixelsToPaint = new ArrayList<>();
            int numPixelsToPaint = 0;

            // Only paint pixels until we meet our percentage threshold
            while (numPixelsToPaint < givenColor.getValue()) {
                // Pick a random pixel from the input image
                int x1 = (int) (Math.random() * imageWidth);
                int y1 = (int) (Math.random() * imageHeight);
                Point pix = new Point(x1, y1);

                // Gather pixel neighbors
                ArrayList<Point> neighborsList = gatherPixelNeighbors(pix);

                // Gather pixels found in neighbors list if they can accept color and were NOT already visited
                for (Point p : neighborsList) {
                    if (!isOutOfBounds(outputImage, p.x, p.y) && outputImage.getRGB(p.x, p.y) == Color.WHITE.getRGB()
                            && !pixelsToPaint.contains(p) && !visitedPixels.contains(p)) {
                        pixelsToPaint.add(p);
                        visitedPixels.add(p);
                        numPixelsToPaint++;
                    }
                }
            }

            // Now paint each gathered pixel the same color
            logger.info("Paint color {} onto the new image given descending order is set to {}.\n", givenColor, sortDescending);
            Color color = givenColor.getKey();
            for (Point q : pixelsToPaint) {
                outputImage.setRGB(q.x, q.y, color.getRGB());
            }
        }

        // Save output image
        logger.info("Save generated image to {}.\n", outputFilePath);
        File outputFile = new File(outputFilePath);
        ImageIO.write(outputImage, "png", outputFile);
    }

    public static ArrayList<Point> gatherPixelNeighbors(Point point) {
        // Create list containing initial pixel and its immediate neighbors
        ArrayList<Point> pixelNeighbors = new ArrayList<>();
        pixelNeighbors.add(point);
        pixelNeighbors.add(new Point(point.x+1, point.y));
        pixelNeighbors.add(new Point(point.x-1, point.y));
        pixelNeighbors.add(new Point(point.x, point.y+1));
        pixelNeighbors.add(new Point(point.x, point.y-1));
        pixelNeighbors.add(new Point(point.x+1, point.y+1));
        pixelNeighbors.add(new Point(point.x+1, point.y-1));
        pixelNeighbors.add(new Point(point.x-1, point.y+1));
        pixelNeighbors.add(new Point(point.x-1, point.y-1));
        return pixelNeighbors;
    }

    public static boolean isOutOfBounds(BufferedImage image, int x, int y) {
        int width = image.getWidth();
        int height = image.getHeight();
        return x < 0 || x >= width || y < 0 || y >= height;
    }
}


