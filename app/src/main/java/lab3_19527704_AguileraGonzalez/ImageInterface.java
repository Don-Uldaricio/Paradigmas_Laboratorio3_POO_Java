package lab3_19527704_AguileraGonzalez;

import java.util.ArrayList;

public interface ImageInterface {
    
    public boolean isBitmap();
    public boolean isPixmap();
    public boolean isHexmap();
    public boolean isCompressed();
    public void flipH();
    public void flipV();
    public void crop(int x1, int y1, int x2, int y2);
    public Image imgRGBToHex();
    public Histogram histogram();
    public void rotate90();
    public void compress();
    public void changePixel(Pixel p);
    public void invertColorBit();
    public void invertColorRGB();
    public String imageToString();
    public ArrayList<Image> depthLayers();
    public void sortPixlist();
    
}
