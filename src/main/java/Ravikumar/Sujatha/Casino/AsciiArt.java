package Ravikumar.Sujatha.Casino;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

/**
 * Created by sujatharavikumar on 10/1/16.
 */
public class AsciiArt {

    public String[] casinoArt = {
        "\n00000000000000000--------00000000000000000000000--------00000000000000000000000000000000000000000000000000000000\n",
            "000000000000//        000//    00      \\0000        |0000       00000       00000000   000000          000000\n",
            "00000000000|   0000000000|    000000    |0000     0000000000   0000000   0   00000000   00000            00000\n",
            "00000000000|   0000000000|   00000000   |0000    00000000000   0000000   00   0000000   00000    0000    00000\n",
            "00000000000|   0000000000|   00000000   |0000    00000000000   0000000   000   000000   00000    0000    00000\n",
            "00000000000|   0000000000|   --------   |0000      000000000   0000000   0000   00000   00000    0000    00000\n",
            "00000000000|   0000000000|   |      |   |000000      0000000   0000000   00000   0000   00000    0000    00000\n",
            "00000000000|   0000000000|   --------   |000000000    000000   0000000   000000   000   00000    0000    000000\n",
            "00000000000|   0000000000|   00000000   |0000000000    00000   0000000   0000000   00   00000    0000    000000\n",
            "00000000000|   0000000000|   00000000   |000000000     00000   0000000   00000000   0   00000            000000\n",
            "000000000000\\          0|   00000000   |000           000       00000   000000000      000000          000000\n",
            "000000000000000---------00000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
    };


    public void displayAsciiArt(){
        for(String art: casinoArt){
            System.out.println(art);
        }
    }


    public void displayArt(){

        BufferedImage image = new BufferedImage(144, 32, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("Dialog", Font.PLAIN, 24));
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("Casino", 6, 24);

        for (int y = 0; y < 32; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < 144; x++)
                sb.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? "#" : "*");
            System.out.println(sb);
        }

    }





}