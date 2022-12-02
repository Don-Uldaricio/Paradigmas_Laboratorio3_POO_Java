package lab3_19527704_AguileraGonzalez;

import java.util.ArrayList;

public interface ImageInterface_19527704_AguileraGonzalez {
    
    public boolean isBitmap();
    public boolean isPixmap();
    public boolean isHexmap();
    public boolean isCompressed();
    public void flipH();
    public void flipV();
    public void crop(int x1, int y1, int x2, int y2);
    public Image_19527704_AguileraGonzalez imgRGBToHex();
    public Histogram_19527704_AguileraGonzalez histogram();
    public void rotate90();
    public void compress();
    public void changePixel(Pixel_19527704_AguileraGonzalez p);
    public void invertColorBit();
    public void invertColorRGB();
    public String imageToString();
    public ArrayList<Image_19527704_AguileraGonzalez> depthLayers();
    public void sortPixlist();
    
}
