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


public class Imaghur {
    private static final Logger logger = LoggerFactory.getLogger(Imaghur.class);
    protected static ArrayList<Point> pixelTracker;

    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/input.png";
        String outputFilePath = "src/main/resources/output.png";
        boolean sortDescending = false;
        pixelTracker = new ArrayList<>();
        try {
            analyzeImage(inputFilePath, outputFilePath, sortDescending);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void analyzeImage(String inputFilePath, String outputFilePath, boolean sortDescending) throws IOException {
        // Load input image
        logger.info("The image we were given and will use: {}\n", inputFilePath);
        BufferedImage inputImage = ImageIO.read(new File(inputFilePath));
        int imageWidth = inputImage.getWidth();
        int imageHeight = inputImage.getHeight();

        // Initialize data structures
        Map<Color, Integer> colorCounts = new HashMap<>();

        // Analyze input image and count colors
        // TODO: Fix this counter as we are identifying way too many colors in our input image
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
        logger.info("We found a total of {} colors in our input image.\n", colorCounts.size());

        // Sort colors by count in either ascending or descending order
        logger.info("Sort colors in descending or ascending order by pixel count.\n");
        List<Map.Entry<Color, Integer>> sortedColors = new ArrayList<>(colorCounts.entrySet());
        sortedColors.sort(sortDescending ? Map.Entry.comparingByValue(Comparator.reverseOrder()) : Map.Entry.comparingByValue());

        // Create output image
        logger.info("Create new image file for output.\n");
        BufferedImage outputImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = outputImage.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, imageWidth, imageHeight);

        // Gather a varying number of connected pixels based on the color percentage provided
        logger.info("Given descending order is set to {}, we gather a varying number of connected pixels to color in.\n", sortDescending);
        for (Map.Entry<Color, Integer> givenColor : sortedColors) {
            // Gather pixel and its neighbors in one list
            Integer pixelCount = givenColor.getValue();
            ArrayList<Point> pixelsToPaint = gatherPixelNeighbors(pixelCount, outputImage);

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

    public static ArrayList<Point> gatherPixelNeighbors(Integer threshold, BufferedImage imageTemplate) {
        // Create list containing initial pixel and its immediate neighbors
        ArrayList<Point> pixelNeighbors = new ArrayList<>();
        int gatheredPixels = 0;
        int neighbourDistance = 1;

        // Pick a random pixel from the input image
        int x1 = (int) (Math.random() * imageTemplate.getWidth());
        int y1 = (int) (Math.random() * imageTemplate.getHeight());
        Point point = new Point(x1, y1);
        while (pixelTracker.contains(point)) {
            logger.info("Recreating point {} since we found it already added to pixelTracker", point);
            x1 = (int) (Math.random() * imageTemplate.getWidth());
            y1 = (int) (Math.random() * imageTemplate.getHeight());
            point = new Point(x1, y1);
        }

        // Add original point to our neighbors list, since the point is a neighbor to itself
        pixelNeighbors.add(point);
        logger.info("Added pixel {} to our list of neighbors to paint.\n", point);

        // Add pixels to neighbors list if adjacent to original pixel and not already in the list until we reach our threshold
        while (gatheredPixels < threshold) {
            // pixr = pixel to the right of point
            Point pixr = new Point(point.x+neighbourDistance, point.y);
            if (pixr.x >= 0 && pixr.x < imageTemplate.getWidth() && pixr.y >= 0 && pixr.y < imageTemplate.getHeight()
                    && !pixelNeighbors.contains(pixr) && !pixelTracker.contains(pixr)) {
                pixelNeighbors.add(pixr);
                pixelTracker.add(pixr);
                gatheredPixels++;
            }
            // pixl = pixel to the left of point
            Point pixl = new Point(point.x-neighbourDistance, point.y);
            if (pixl.x >= 0 && pixl.x < imageTemplate.getWidth() && pixl.y >= 0 && pixl.y < imageTemplate.getHeight()
                    && !pixelNeighbors.contains(pixl) && !pixelTracker.contains(pixl)) {
                pixelNeighbors.add(pixl);
                pixelTracker.add(pixl);
                gatheredPixels++;
            }
            // pixu = pixel above the point
            Point pixu = new Point(point.x, point.y+neighbourDistance);
            if (pixu.x >= 0 && pixu.x < imageTemplate.getWidth() && pixu.y >= 0 && pixu.y < imageTemplate.getHeight()
                    && !pixelNeighbors.contains(pixu) && !pixelTracker.contains(pixu)) {
                pixelNeighbors.add(pixu);
                pixelTracker.add(pixu);
                gatheredPixels++;
            }
            // pixd = pixel below the point
            Point pixd = new Point(point.x, point.y-neighbourDistance);
            if (pixd.x >= 0 && pixd.x < imageTemplate.getWidth() && pixd.y >= 0 && pixd.y < imageTemplate.getHeight()
                    && !pixelNeighbors.contains(pixd) && !pixelTracker.contains(pixd)) {
                pixelNeighbors.add(pixd);
                pixelTracker.add(pixd);
                gatheredPixels++;
            }
            // pixur = pixel to the upper right of point
            Point pixur = new Point(point.x+neighbourDistance, point.y+neighbourDistance);
            if (pixur.x >= 0 && pixur.x < imageTemplate.getWidth() && pixur.y >= 0 && pixur.y < imageTemplate.getHeight()
                    && !pixelNeighbors.contains(pixur) && !pixelTracker.contains(pixur)) {
                pixelNeighbors.add(pixur);
                pixelTracker.add(pixur);
                gatheredPixels++;
            }
            // pixul = pixel to the upper left of point
            Point pixul = new Point(point.x+neighbourDistance, point.y-neighbourDistance);
            if (pixul.x >= 0 && pixul.x < imageTemplate.getWidth() && pixul.y >= 0 && pixul.y < imageTemplate.getHeight()
                    && !pixelNeighbors.contains(pixul) && !pixelTracker.contains(pixul)) {
                pixelNeighbors.add(pixul);
                pixelTracker.add(pixul);
                gatheredPixels++;
            }
            // pixdr = pixel to the lower right of point
            Point pixdr = new Point(point.x-neighbourDistance, point.y+neighbourDistance);
            if (pixdr.x >= 0 && pixdr.x < imageTemplate.getWidth() && pixdr.y >= 0 && pixdr.y < imageTemplate.getHeight()
                    && !pixelNeighbors.contains(pixdr) && !pixelTracker.contains(pixdr)) {
                pixelNeighbors.add(pixdr);
                pixelTracker.add(pixdr);
                gatheredPixels++;
            }
            // pixdl = pixel to the lower left of point
            Point pixdl = new Point(point.x-neighbourDistance, point.y-neighbourDistance);
            if (pixdl.x >= 0 && pixdl.x < imageTemplate.getWidth() && pixdl.y >= 0 && pixdl.y < imageTemplate.getHeight()
                    && !pixelNeighbors.contains(pixdl) && !pixelTracker.contains(pixdl)) {
                pixelNeighbors.add(pixdl);
                pixelTracker.add(pixdl);
                gatheredPixels++;
            }
            neighbourDistance++;
        }
        logger.info("We reached a blob size of {}.\n", neighbourDistance);
        return pixelNeighbors;
    }
}


