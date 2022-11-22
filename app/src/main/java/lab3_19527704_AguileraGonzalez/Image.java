package lab3_19527704_AguileraGonzalez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Image {
    
    int width;
    int height;
    boolean compressValue;
    ArrayList<Pixel> pixlist;
    ArrayList<ArrayList<Integer>> compressedPixels;

    public Image() {
        compressValue = false;
        compressedPixels = new ArrayList<>();
    }

    public Image(int width, int height, ArrayList<Pixel> pixlist) {
        this.width = width;
        this.height = height;
        this.pixlist = pixlist;
        compressValue = false;
        compressedPixels = new ArrayList<>();
    }
    
    Comparator<Pixel> compareByPosX = (Pixel p1, Pixel p2) -> 
        Integer.compare(p1.getPosX(), p2.getPosX());
        
    Comparator<Pixel> compareByPosY = (Pixel p3, Pixel p4) -> 
        Integer.compare(p3.getPosY(), p4.getPosY());
    
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ArrayList<Pixel> getPixlist() {
        return pixlist;
    }

    public void setPixlist(ArrayList<Pixel> pixlist) {
        this.pixlist = pixlist;
    }

    public ArrayList<ArrayList<Integer>> getCompressedPixels() {
        return compressedPixels;
    }

    public void setCompressedPixels(ArrayList<ArrayList<Integer>> compressedPixels) {
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
            for (Pixel p: pixlist) {
                p.setPosX(width - p.getPosX() - 1);
            }
        }
    }
    
    public void flipV() {
        if (! isCompressed()) {
            for (Pixel p: pixlist) {
                p.setPosY(height - p.getPosY() - 1);
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
                ArrayList<Pixel> pixlist2 = new ArrayList<>();
                for (Pixel p: pixlist) {
                    pixlist2.add(new Pixhex(p.getPosX(),p.getPosY(), 
                            ((Pixrgb)p).rgbToHex(),p.getDepth()));
                }
                img2 = new Hexmap(width,height,pixlist2);                
                return img2;
            }
        }
        return null;
    }
    
    public Histogram histogram() {
        if (! isCompressed()) {
            Histogram h;
            ArrayList<Integer> freqList = new ArrayList<>();
            int c;
            
            if (isBitmap()) {
                ArrayList<Integer> bitColorList = new ArrayList<>();
                bitColorList.add(0);
                bitColorList.add(1);               
                for (int color: bitColorList) {
                    c = 0;
                    for (Pixel p: pixlist) {
                        if (color == ((Pixbit)p).getBitColor()) {
                            c++;
                        }
                    }
                    freqList.add(c);                    
                }
                h = new BitHistogram(bitColorList, freqList);
                return h;
            }
            
            else if (isPixmap()) {
                ArrayList<int[]> rgbColorList = new ArrayList<>();
                for (Pixel p: pixlist) {
                    if (!rgbColorList.contains(((Pixrgb)p).getRgbColor())) {
                        rgbColorList.add(((Pixrgb)p).getRgbColor());
                    }
                }
                for (int[] color: rgbColorList) {
                    c = 0;
                    for (Pixel p: pixlist) {
                        if (color == ((Pixrgb)p).getRgbColor()) {
                            c++;
                        }
                    }
                    freqList.add(c); 
                }
                h = new RgbHistogram(rgbColorList, freqList);
                return h;
            }
            
            else if (isHexmap()) {
                ArrayList<String> hexColorList = new ArrayList<>();
                for (Pixel p: pixlist) {
                    if (!hexColorList.contains(((Pixhex)p).getHexColor())) {
                        hexColorList.add(((Pixhex)p).getHexColor());
                    }
                }
                for (String color: hexColorList) {
                    c = 0;
                    for (Pixel p: pixlist) {
                        if (color.equals(((Pixhex)p).getHexColor())) {
                            c++;
                        }
                    }
                    freqList.add(c); 
                }
                h = new HexHistogram(hexColorList, freqList);
                return h;
            }
        }
        return null;
    }
    
    
    public void rotate90() {
        int aux;
        for (Pixel p: pixlist) {
            aux = p.getPosX();
            p.setPosX(height - 1 - p.getPosY());
            p.setPosY(aux);
        }
        aux = width;
        width = height;
        height = aux;
    }
    
}
