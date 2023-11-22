package Frame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI {
    private JLabel lblImage;
    
    public GUI(JLabel lblImage){
        this.lblImage = lblImage;
    }

    public void display(String captcha) throws IOException {
        BufferedImage image = ImageIO.read(new File("./Text.png"));
        lblImage.setIcon(new ImageIcon(image));

    }
}
