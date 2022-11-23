package lab3dos;

import java.util.ArrayList;

public class Hexmap extends Image {
    
    String compressedColor;

    public Hexmap() {
    }

    public Hexmap(int width, int height, ArrayList<Pixel> pixlist) {
        super(width, height, pixlist);
    }

    public String getCompressedColor() {
        return compressedColor;
    }

    public void setCompressedColor(String compressedColor) {
        if (compressedColor.charAt(0) == '#' &&
            compressedColor.length() == 7) {
            this.compressedColor = compressedColor;
        }
    }
    
}