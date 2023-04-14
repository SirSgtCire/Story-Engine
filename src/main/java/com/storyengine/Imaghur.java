package com.storyengine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.imageio.ImageIO;

public class Imaghur {
    private static final Logger logger = LoggerFactory.getLogger(Imaghur.class);

    public static void main(String[] args) {
        String inputImagePath = String.format("src/main/resources/input.png");
        logger.info("The image we will use: {}\n", inputImagePath);
        File inputFile = new File(inputImagePath);

        try {
            // Read input image
            logger.info("Scanning input image and saving its size and color properties.\n");
            BufferedImage inputImage = ImageIO.read(inputFile);
            Dimension imageSize = new Dimension(inputImage.getWidth(), inputImage.getHeight());

            // Save image properties
            int imageSizeInBytes = (int) inputFile.length();
            int imageWidth = imageSize.width;
            int imageHeight = imageSize.height;

            // Identify and categorize different colors in the image
            Map<Color, Integer> colorCounts = new HashMap<>();
            for (int x = 0; x < imageWidth; x++) {
                for (int y = 0; y < imageHeight; y++) {
                    Color pixelColor = new Color(inputImage.getRGB(x, y), true);
                    if (!colorCounts.containsKey(pixelColor)) {
                        colorCounts.put(pixelColor, 1);
                    } else {
                        colorCounts.put(pixelColor, colorCounts.get(pixelColor) + 1);
                    }
                }
            }

            // Calculate percentage of each color in the image
            Map<Color, Double> colorPercentages = new HashMap<>();
            int totalPixels = imageWidth * imageHeight;
            for (Map.Entry<Color, Integer> colorCount : colorCounts.entrySet()) {
                Color color = colorCount.getKey();
                int count = colorCount.getValue();
                double percentage = ((double) count / totalPixels) * 100.0;
                colorPercentages.put(color, percentage);
            }

            // Sort colors by percentage
            logger.info("Organizing colors found in image based on coverage percentage.\n");
            List<Color> sortedColors = new ArrayList<>(colorPercentages.keySet());
            sortedColors.sort(Comparator.comparingDouble(color -> -colorPercentages.get(color)));

            // Generate random fillable shapes and fill them with colors
            logger.info("Create new image file with fillable shapes, and add colors in descending order.\n");
            BufferedImage outputImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = outputImage.createGraphics();
            Random random = new Random();
            int maxShapeSize = Math.min(imageWidth, imageHeight) / 10;
            int minShapeSize = Math.min(imageWidth, imageHeight) / 20;
            int maxLineThickness = Math.min(imageWidth, imageHeight) / 100;
            int minLineThickness = Math.min(imageWidth, imageHeight) / 200;
            for (Color color : sortedColors) {
                double colorPercentage = colorPercentages.get(color);
                int colorPixels = (int) Math.round((colorPercentage / 100.0) * totalPixels);
                int filledPixels = 0;
                while (filledPixels < colorPixels) {
                    int shapeWidth = random.nextInt(maxShapeSize - minShapeSize + 1) + minShapeSize;
                    int shapeHeight = random.nextInt(maxShapeSize - minShapeSize + 1) + minShapeSize;
                    int shapeX = random.nextInt(imageWidth - shapeWidth);
                    int shapeY = random.nextInt(imageHeight - shapeHeight);
                    graphics.setColor(color);
                    graphics.setStroke(new BasicStroke(random.nextInt(maxLineThickness - minLineThickness + 1) + minLineThickness));
                    graphics.drawRect(shapeX, shapeY, shapeWidth, shapeHeight);
                    filledPixels += fillShapeWithColor(graphics, inputImage, color, shapeX, shapeY, shapeWidth, shapeHeight);
                }
            }

            // Save output image to system Downloads folder
            logger.info("Save generated image to the system Downloads folder, look for output.png there.\n");
            File outputFile = new File("src/main/resources", "output.png");
            ImageIO.write(outputImage, "png", outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int fillShapeWithColor(Graphics2D graphics, BufferedImage inputImage, Color color, int x, int y, int width, int height) {
        int filledPixels = 0;
        for (int i = x; i < x + width; i++) {
            for (int j = y; j < y + height; j++) {
                if (i >= 0 && i < inputImage.getWidth() && j >= 0 && j < inputImage.getHeight()) {
                    Color pixelColor = new Color(inputImage.getRGB(i, j), true);
                    if (pixelColor.equals(color)) {
                        graphics.fillRect(i, j, 1, 1);
                        filledPixels++;
                    }
                }
            }
        }
        return filledPixels;
    }
}


