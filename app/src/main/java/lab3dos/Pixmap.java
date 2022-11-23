package lab3dos;

import java.util.ArrayList;

public class Pixmap extends Image {
    
    int[] compressedColor;

    public Pixmap() {
        this.compressedColor = new int[3];
    }

    public Pixmap(int width, int height, ArrayList<Pixel> pixlist) {
        super(width, height, pixlist);
        this.compressedColor = new int[3];
    }

    public int[] getCompressedColor() {
        return compressedColor;
    }

    public void setCompressedColor(int[] compressedColor) {
        if (compressedColor[0] >= 0 && compressedColor[0] <= 255 &&
            compressedColor[1] >= 0 && compressedColor[1] <= 255 &&
            compressedColor[2] >= 0 && compressedColor[2] <= 255 ) {
            this.compressedColor = compressedColor;
        }
    }
    
}