/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package askyfart;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

/**
 *
 * @author Liam
 */
public class AskyFart {
    
    public char[] characters = {
        '#',
        '@',
        '8',
        '%',
        '0',
        'o',
        '"',
        ';',
        ',',
        '\'',
        '.',
        ' '
    };
    
    // Absolute path, morans
    public BufferedImage getImage(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } 
        catch (IOException e) {
        }
        return img;
    }
    
    public char brightnessToCharacter(int brightness) {
        return characters[(int)Math.floor(brightness * ((characters.length-1) / 255.0))];
    }
    
    public void convertImage(BufferedImage image) {
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                int brightness = calculateBrightness(image.getRGB(j, i));
                for (int k = 0; k < 2; k++) {
                    System.out.print(brightnessToCharacter(brightness));
                }
            }
            System.out.println();
        }
    }
    
    public int calculateBrightness(int rgb) {
        
        int r = rgb & 0xFF0000 >> 16;
        int g = rgb & 0xFF00 >> 8;
        int b = rgb & 0xFF;
        
        return (int)Math.sqrt(
            r * r * .241 + 
            g * g * .691 + 
            b * b * .068);
    }
    
    public static void main(String[] args) {
        AskyFart af = new AskyFart();
        
        String path = "C:/Users/Liam/Downloads/dog-groups-sporting-group0.jpg";
        BufferedImage theImage = af.getImage(path);
        af.convertImage(theImage);
        
        
    }
    
}
