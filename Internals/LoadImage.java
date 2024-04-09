package Internals;

import java.net.URL;

import javax.imageio.ImageIO;

public class LoadImage {
    private Image getIcon() {
        URL imageURL = LoadImage.class.getResource("icon.png");
        return ImageIO.read(imageURL);
    }
}
