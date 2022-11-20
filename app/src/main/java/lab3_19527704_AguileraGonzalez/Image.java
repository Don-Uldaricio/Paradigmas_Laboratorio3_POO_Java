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
    
    public boolean isBitmap() {
        for(int i = 0; i < width * height; i++) {
            if (!(pixlist.get(i) instanceof Pixbit)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isPixmap() {
        for(int i = 0; i < width * height; i++) {
            if (!(pixlist.get(i) instanceof Pixrgb)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isHexmap() {
        for(int i = 0; i < width * height; i++) {
            if (!(pixlist.get(i) instanceof Pixhex)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isCompressed() {
        return compressValue;
    }
    
    public void flipH() {
        if (! isCompressed()) {
            for (int i = 0; i < width * height; i++) {
                pixlist.get(i).setPosX(width - pixlist.get(i).getPosX() - 1);
            }
        }
    }
    
    public void flipV() {
        if (! isCompressed()) {
            for (int i = 0; i < width * height; i++) {
                pixlist.get(i).setPosY(width - pixlist.get(i).getPosY() - 1);
            }
        }
    }
    
    public void crop(int x1, int y1, int x2, int y2) {
        if (! isCompressed()) {
            int i = 0;
            if (x1 >= 0 && x2 <= (width - 1) &&
                y1 >= 0 && y2 <= (height - 1) &&
                x1 <= x2 && y1 <= y2) {
                while(pixlist.size() != (x2 - x1 + 1)*(y2 - y1 + 1))  {
                    if (pixlist.get(i).getPosX() >= x1 &&
                        pixlist.get(i).getPosX() <= x2 &&
                        pixlist.get(i).getPosY() >= y1 &&
                        pixlist.get(i).getPosY() <= y2) {
                        pixlist.get(i).setPosX(pixlist.get(i).getPosX() - x1);
                        pixlist.get(i).setPosY(pixlist.get(i).getPosY() - y1);
                        i++;
                    }
                    
                    else {
                        pixlist.remove(i);
                    }
                }
                width = x2 - x1 + 1;
                height = y2 - y1 + 1;
            }
        }
    }
    
    public Image imgRGBToHex() {
        if (! isCompressed()) {
            if (isPixmap()) {
                Image img2;
                Pixhex phex;
                String hexColor;
                ArrayList<Pixel> pixlist2 = new ArrayList<>();
                for (Pixel p: pixlist) {
                    hexColor = ((Pixrgb)p).rgbToHex();
                    phex = new Pixhex(p.getPosX(),p.getPosY(),hexColor,p.getDepth());
                    pixlist2.add(phex);
                }
                img2 = new Hexmap(width,height,pixlist2);                
                return img2;
            }
        }
        return (null);
    }
    
}
