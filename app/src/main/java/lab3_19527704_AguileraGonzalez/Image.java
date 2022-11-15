package lab3_19527704_AguileraGonzalez;

import java.util.ArrayList;

public class Image {
    
    int width;
    int height;
    boolean compressValue;
    ArrayList<Pixel> pixlist;
    ArrayList<Integer> compressedPixels;

    public Image() {
        compressValue = false;
    }
    
    public Image(int width, int height, ArrayList<Pixel> pixlist) {
        this.width = width;
        this.height = height;
        this.pixlist = pixlist;
        compressValue = false;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width >= 0) {
            this.width = width;
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height >= 0) {
            this.height = height;
        }
    }

    public boolean isCompressValue() {
        return compressValue;
    }

    public void setCompressValue(boolean compressValue) {
        this.compressValue = compressValue;
    }

    public ArrayList<Pixel> getPixlist() {
        return pixlist;
    }

    public void setPixlist(ArrayList<Pixel> pixlist) {
        this.pixlist = pixlist;
    }

    public ArrayList<Integer> getCompressedPixels() {
        return compressedPixels;
    }

    public void setCompressedPixels(ArrayList<Integer> compressedPixels) {
        this.compressedPixels = compressedPixels;
    }
    
}
