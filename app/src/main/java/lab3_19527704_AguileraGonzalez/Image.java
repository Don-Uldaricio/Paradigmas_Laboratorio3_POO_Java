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

    public Image(){
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
    
    public void compress() {
        if (!isCompressed()) {
            int c = 0;
            int j = 0;
            if (isBitmap()) {
                int maxColor = ((BitHistogram)histogram()).getMaxBitColor();
                for (Pixel p: pixlist) {
                    if (((Pixbit)p).getBitColor() == maxColor) {
                        c++;
                    }
                }
                int finalLenght = pixlist.size() - c;
                while (pixlist.size() != finalLenght) {
                    Pixel auxP = pixlist.get(j);
                    if (((Pixbit)auxP).getBitColor() == maxColor) {
                        compressedPixels.add(new ArrayList<>(Arrays.asList(auxP.getPosX(),auxP.getPosY(),auxP.getDepth())));
                        pixlist.remove(j);
                    }
                    else {
                        j++;
                    }
                }
                compressValue = true;
            }
            
            else if (isPixmap()) {
                int[] maxColor = ((RgbHistogram)histogram()).getMaxRgbColor();
                for (Pixel p: pixlist) {
                    if (((Pixrgb)p).getRgbColor()[0] == maxColor[0] &&
                        ((Pixrgb)p).getRgbColor()[1] == maxColor[1] &&
                        ((Pixrgb)p).getRgbColor()[2] == maxColor[2]) {
                        c++;
                    }
                }
                int finalLenght = pixlist.size() - c;
                while (pixlist.size() != finalLenght) {
                    Pixel auxP = pixlist.get(j);
                    if (((Pixrgb)auxP).getRgbColor()[0] == maxColor[0] &&
                        ((Pixrgb)auxP).getRgbColor()[1] == maxColor[1] &&
                        ((Pixrgb)auxP).getRgbColor()[2] == maxColor[2]) {
                        compressedPixels.add(new ArrayList<>(Arrays.asList(auxP.getPosX(),auxP.getPosY(),auxP.getDepth())));
                        pixlist.remove(j);
                    }
                    else {
                        j++;
                    }
                }
                compressValue = true;
            }
            
            else if (isHexmap()) {
                String maxColor = ((HexHistogram)histogram()).getMaxHexColor();
                for (Pixel p: pixlist) {
                    if (((Pixhex)p).getHexColor().equals(maxColor)) {
                        c++;
                    }
                }
                int finalLenght = pixlist.size() - c;
                while (pixlist.size() != finalLenght) {
                    Pixel auxP = pixlist.get(j);
                    if (((Pixhex)auxP).getHexColor().equals(maxColor)) {
                        compressedPixels.add(new ArrayList<>(Arrays.asList(auxP.getPosX(),auxP.getPosY(),auxP.getDepth())));
                        pixlist.remove(j);
                    }
                    else {
                        j++;
                    }
                }
                compressValue = true;
            }
        }
    }
    
    public void changePixel(Pixel p) {
        if (!isCompressed()) {
            if ((p instanceof Pixbit && isBitmap()) ||
                (p instanceof Pixrgb && isPixmap()) ||
                (p instanceof Pixhex && isHexmap())) {
                for (Pixel auxP: pixlist) {
                    if (auxP.getPosX() == p.getPosX() &&
                        auxP.getPosY() == p.getPosY()) {
                        auxP.setDepth(p.getDepth());
                        if (isBitmap()) {
                            ((Pixbit)auxP).setBitColor(((Pixbit)p).getBitColor());
                        }
                        else if (isPixmap()) {
                            ((Pixrgb)auxP).setRColor(((Pixrgb)p).getRColor());
                            ((Pixrgb)auxP).setGColor(((Pixrgb)p).getGColor());
                            ((Pixrgb)auxP).setBColor(((Pixrgb)p).getBColor());
                        }
                        else if (isHexmap()) {
                            ((Pixhex)auxP).setHexColor(((Pixhex)p).getHexColor());
                        }
                    }
                }
            }
        }
    }
    
    public void invertColorBit() {
        if (!isCompressed()) {
            if (isBitmap()) {
                for (Pixel p: pixlist) {
                    if (((Pixbit)p).getBitColor() == 0) {
                        ((Pixbit)p).setBitColor(1);
                    }
                    else {
                        ((Pixbit)p).setBitColor(0);
                    }
                }
            }
        }
    }
    
    public void invertColorRGB() {
        if (!isCompressed()) {
            if (isPixmap()) {
                int newR, newG, newB;
                for (Pixel p: pixlist) {
                    newR = 255 - ((Pixrgb)p).getRColor();
                    newG = 255 - ((Pixrgb)p).getGColor();
                    newB = 255 - ((Pixrgb)p).getBColor();
                    ((Pixrgb)p).setRColor(newR);
                    ((Pixrgb)p).setGColor(newG);
                    ((Pixrgb)p).setBColor(newB);
                }
            }
        }
    }
        
    Comparator<Pixel> compareByPosX = (Pixel p1, Pixel p2) -> 
        Integer.compare(p1.getPosX(), p2.getPosX());
        
    Comparator<Pixel> compareByPosY = (Pixel p1, Pixel p2) -> 
        Integer.compare(p1.getPosY(), p2.getPosY());
    
    public void sortPixlist() {
        Collections.sort(pixlist, compareByPosX);
        Collections.sort(pixlist, compareByPosY);
    }
    
    public String imageToString() {
        if (!isCompressed()) {
            String imageString = "";
            sortPixlist();
            if (isBitmap()) {
                for (Pixel p: pixlist) {
                    Integer aux = ((Pixbit)p).getBitColor();
                    if (p.getPosX() == width - 1) {
                        imageString = imageString.concat(aux.toString() + "\n"); 
                    }
                    else {
                        imageString = imageString.concat(aux.toString() + " ");
                    }
                }
                return imageString;
            }
            
            else if (isPixmap()) {
                for (Pixel p: pixlist) {
                    int[] aux = ((Pixrgb)p).getRgbColor();
                    if (p.getPosX() == width - 1) {
                        imageString = imageString.concat("[" + 
                                ((Integer)aux[0]).toString() + "," + 
                                ((Integer)aux[1]).toString() + "," +
                                ((Integer)aux[2]).toString() + "]" + "\n");
                    }
                    else {
                        imageString = imageString.concat("[" + 
                                ((Integer)aux[0]).toString() + "," + 
                                ((Integer)aux[1]).toString() + "," +
                                ((Integer)aux[2]).toString() + "]" + " ");
                    }
                }
                return imageString;
            }
            
            else if (isHexmap()) {
                for (Pixel p: pixlist) {
                    String aux = ((Pixhex)p).getHexColor();
                    if (p.getPosX() == width - 1) {
                        imageString = imageString.concat(aux + "\n");
                    }
                    else {
                        imageString = imageString.concat(aux + " ");
                    }
                }
                return imageString;
            }
        }
        return null;
    }
    
    public ArrayList<Image> depthLayers() {
        if (!isCompressed()) {
            ArrayList<Image> imageList = new ArrayList<>();
            ArrayList<Integer> depthList = new ArrayList<>();
            ArrayList<Pixel> auxPixlist = new ArrayList<>();
            if (isBitmap()) {
                for (Pixel p: pixlist) {
                    if (!depthList.contains(p.getDepth())) {
                        depthList.add(p.getDepth());
                    }
                }
                for (int d: depthList) {
                    for (Pixel p: pixlist) {
                        if (p.getDepth() != d) {
                            auxPixlist.add(new Pixbit(p.getPosX(), p.getPosY(), 1, d));
                        }
                        else {
                            auxPixlist.add(new Pixbit(p.getPosX(),p.getPosY(),((Pixbit)p).getBitColor(),p.getDepth()));
                        }
                    }
                    imageList.add(new Bitmap(width,height,auxPixlist));
                    auxPixlist = new ArrayList<>();
                }
                return imageList;
            }
            
            else if (isPixmap()) {
                for (Pixel p: pixlist) {
                    if (!depthList.contains(p.getDepth())) {
                        depthList.add(p.getDepth());
                    }
                }
                for (int d: depthList) {
                    for (Pixel p: pixlist) {
                        if (p.getDepth() != d) {
                            auxPixlist.add(new Pixrgb(p.getPosX(),
                                    p.getPosY(),255,255,255,d));
                        }
                        else {
                            auxPixlist.add(new Pixrgb(p.getPosX(),
                                    p.getPosY(),
                                    ((Pixrgb)p).getRColor(),((Pixrgb)p).getGColor(),
                                    ((Pixrgb)p).getBColor(), p.getDepth()));
                        }
                    }
                    imageList.add(new Pixmap(width,height,auxPixlist));
                    auxPixlist = new ArrayList<>();
                }
                return imageList;
            }
            
            else if (isHexmap()) {
                for (Pixel p: pixlist) {
                    if (!depthList.contains(p.getDepth())) {
                        depthList.add(p.getDepth());
                    }
                }
                for (int d: depthList) {
                    for (Pixel p: pixlist) {
                        if (p.getDepth() != d) {
                            auxPixlist.add(new Pixhex(p.getPosX(), p.getPosY(), "#FFFFFF", d));
                        }
                        else {
                            auxPixlist.add(new Pixhex(p.getPosX(),p.getPosY(),((Pixhex)p).getHexColor(),p.getDepth()));
                        }
                    }
                    imageList.add(new Hexmap(width,height,auxPixlist));
                    auxPixlist = new ArrayList<>();
                }
                return imageList;
            }
        }
        return null;
    }
    
}
