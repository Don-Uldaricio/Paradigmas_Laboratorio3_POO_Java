package lab3_19527704_AguileraGonzalez;

import java.util.ArrayList;

public class Bitmap extends Image {
    
    int compressedColor;

    public Bitmap() {
    }

    public Bitmap(int width, int height, ArrayList<Pixel> pixlist) {
        super(width, height, pixlist);
    }

    public int getCompressedColor() {
        return compressedColor;
    }

    public void setCompressedColor(int compressedColor) {
        if (compressedColor == 0 || compressedColor == 1) {
            this.compressedColor = compressedColor;
        }
    }
    
}
