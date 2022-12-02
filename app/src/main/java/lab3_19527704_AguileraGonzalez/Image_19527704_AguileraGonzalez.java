package lab3_19527704_AguileraGonzalez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Representa una Imagen, contiene ancho, alto, lista de pixeles, 
 * un valor de compresión y una lista de pixeles comprimidos.
 * @author Nicolas Aguilera Gonzalez
 */
public class Image_19527704_AguileraGonzalez implements ImageInterface_19527704_AguileraGonzalez {
    
    protected int width;
    protected int height;
    protected boolean compressValue;
    protected ArrayList<Pixel_19527704_AguileraGonzalez> pixlist;
    protected ArrayList<ArrayList<Integer>> compressedPixels;
    
    /**
     * Crea una instancia de la clase Imagen
     * @param width Ancho de la imagen
     * @param height Alto de la imagen
     * @param pixlist Lista de pixeles
     */
    public Image_19527704_AguileraGonzalez(int width, int height, ArrayList<Pixel_19527704_AguileraGonzalez> pixlist) {
        this.width = width;
        this.height = height;
        this.pixlist = pixlist;
        compressValue = false;
        compressedPixels = new ArrayList<>();
    }
    
    /**
     * Retorna el ancho de la imagen
     * @return width, el ancho de la imagen
     */
    public int getWidth() {
        return width;
    }

    /**
     * Establece un valor para el ancho de la imagen
     * @param width Nuevo valor para el ancho de la imagen
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Retorna el alto de la imagen
     * @return height, el alto de la imagen
     */
    public int getHeight() {
        return height;
    }

    /**
     * Establece un nuevo valor para el alto de la imagen
     * @param height Valor para el alto de la imagen
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Entrega la lista de pixeles de la imagen
     * @return Lista de pixeles de tipo Pixbit, Pixrgb o Pixhex
     */
    public ArrayList<Pixel_19527704_AguileraGonzalez> getPixlist() {
        return pixlist;
    }
    
    /**
     * Verifica si la imagen es de tipo Bitmap
     * @return Booleano
     */
    @Override
    public boolean isBitmap() {
        for(int i = 0; i < width * height; i++) {
            if (!(pixlist.get(i) instanceof Pixbit_19527704_AguileraGonzalez)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Verifica si la imagen es de tipo Pixmap
     * @return Booleano
     */
    @Override
    public boolean isPixmap() {
        for(int i = 0; i < width * height; i++) {
            if (!(pixlist.get(i) instanceof Pixrgb_19527704_AguileraGonzalez)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Verifica si la imagen es de tipo Hexmap
     * @return Booleano
     */
    @Override
    public boolean isHexmap() {
        for(int i = 0; i < width * height; i++) {
            if (!(pixlist.get(i) instanceof Pixhex_19527704_AguileraGonzalez)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Verifica si la imagen está comprimida
     * @return Booleano
     */
    @Override
    public boolean isCompressed() {
        return compressValue;
    }
    
    /**
     * Voltea la imagen horizontalmente cambiando los pixeles de lugar
     */
    @Override
    public void flipH() {
        if (! isCompressed()) {
            for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                p.setPosX(width - p.getPosX() - 1);
            }
        }
    }
    
    /**
     * Voltea la imagen verticalmente cambiando los pixeles de lugar
     */
    @Override
    public void flipV() {
        if (! isCompressed()) {
            for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                p.setPosY(height - p.getPosY() - 1);
            }
        }
    }
    
    /**
     * Recorta una imagen según un cuadrante definido por los parámetros
     * de entrada que representan coordenadas de la imagen
     * @param x1 Primera coordenada x
     * @param y1 Primera coordenada y
     * @param x2 Segunda coordenada x
     * @param y2 Segunda coordenada y
     */
    @Override
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
    
    /**
     * Transforma una imagen de tipo Pixmap a una Hexmap con Pixhex
     * @return Imagen de tipo Hexmap
     */
    @Override
    public Image_19527704_AguileraGonzalez imgRGBToHex() {
        if (! isCompressed()) {
            if (isPixmap()) {
                Image_19527704_AguileraGonzalez img2;
                ArrayList<Pixel_19527704_AguileraGonzalez> pixlist2 = new ArrayList<>();
                for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                    pixlist2.add(new Pixhex_19527704_AguileraGonzalez(p.getPosX(),p.getPosY(), 
                            ((Pixrgb_19527704_AguileraGonzalez)p).rgbToHex(),p.getDepth()));
                }
                img2 = new Hexmap_19527704_AguileraGonzalez(width,height,pixlist2);                
                return img2;
            }
        }
        return null;
    }
    
    /**
     * Entrega el histograma de la imagen, con sus colores y frecuencias
     * @return Histograma de tipo Bit, Pix o Hex
     */
    @Override
    public Histogram_19527704_AguileraGonzalez histogram() {
        if (! isCompressed()) {
            Histogram_19527704_AguileraGonzalez h;
            ArrayList<Integer> freqList = new ArrayList<>();
            int c;
            
            if (isBitmap()) {
                ArrayList<Integer> bitColorList = new ArrayList<>();
                bitColorList.add(0);
                bitColorList.add(1);               
                for (int color: bitColorList) {
                    c = 0;
                    for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                        if (color == ((Pixbit_19527704_AguileraGonzalez)p).getBitColor()) {
                            c++;
                        }
                    }
                    freqList.add(c);                    
                }
                h = new BitHistogram_19527704_AguileraGonzalez(bitColorList, freqList);
                return h;
            }
            
            else if (isPixmap()) {
                ArrayList<int[]> rgbColorList = new ArrayList<>();
                for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                    if (!rgbColorList.contains(((Pixrgb_19527704_AguileraGonzalez)p).getRgbColor())) {
                        rgbColorList.add(((Pixrgb_19527704_AguileraGonzalez)p).getRgbColor());
                    }
                }
                for (int[] color: rgbColorList) {
                    c = 0;
                    for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                        if (color == ((Pixrgb_19527704_AguileraGonzalez)p).getRgbColor()) {
                            c++;
                        }
                    }
                    freqList.add(c); 
                }
                h = new RgbHistogram_19527704_AguileraGonzalez(rgbColorList, freqList);
                return h;
            }
            
            else if (isHexmap()) {
                ArrayList<String> hexColorList = new ArrayList<>();
                for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                    if (!hexColorList.contains(((Pixhex_19527704_AguileraGonzalez)p).getHexColor())) {
                        hexColorList.add(((Pixhex_19527704_AguileraGonzalez)p).getHexColor());
                    }
                }
                for (String color: hexColorList) {
                    c = 0;
                    for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                        if (color.equals(((Pixhex_19527704_AguileraGonzalez)p).getHexColor())) {
                            c++;
                        }
                    }
                    freqList.add(c); 
                }
                h = new HexHistogram_19527704_AguileraGonzalez(hexColorList, freqList);
                return h;
            }
        }
        return null;
    }
    
    /**
     * Rota una imagen en 90 grados en sentido horario
     */
    @Override
    public void rotate90() {
        int aux;
        for (Pixel_19527704_AguileraGonzalez p: pixlist) {
            aux = p.getPosX();
            p.setPosX(height - 1 - p.getPosY());
            p.setPosY(aux);
        }
        aux = width;
        width = height;
        height = aux;
    }
    
    /**
     * Comprime una imagen eliminando los pixeles que tengan el color
     * más frecuente de esta
     */
    @Override
    public void compress() {
        if (!isCompressed()) {
            int c = 0;
            int j = 0;
            if (isBitmap()) {
                int maxColor = ((BitHistogram_19527704_AguileraGonzalez)histogram()).getMaxBitColor();
                for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                    if (((Pixbit_19527704_AguileraGonzalez)p).getBitColor() == maxColor) {
                        c++;
                    }
                }
                int finalLenght = pixlist.size() - c;
                while (pixlist.size() != finalLenght) {
                    Pixel_19527704_AguileraGonzalez auxP = pixlist.get(j);
                    if (((Pixbit_19527704_AguileraGonzalez)auxP).getBitColor() == maxColor) {
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
                int[] maxColor = ((RgbHistogram_19527704_AguileraGonzalez)histogram()).getMaxRgbColor();
                for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                    if (((Pixrgb_19527704_AguileraGonzalez)p).getRgbColor()[0] == maxColor[0] &&
                        ((Pixrgb_19527704_AguileraGonzalez)p).getRgbColor()[1] == maxColor[1] &&
                        ((Pixrgb_19527704_AguileraGonzalez)p).getRgbColor()[2] == maxColor[2]) {
                        c++;
                    }
                }
                int finalLenght = pixlist.size() - c;
                while (pixlist.size() != finalLenght) {
                    Pixel_19527704_AguileraGonzalez auxP = pixlist.get(j);
                    if (((Pixrgb_19527704_AguileraGonzalez)auxP).getRgbColor()[0] == maxColor[0] &&
                        ((Pixrgb_19527704_AguileraGonzalez)auxP).getRgbColor()[1] == maxColor[1] &&
                        ((Pixrgb_19527704_AguileraGonzalez)auxP).getRgbColor()[2] == maxColor[2]) {
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
                String maxColor = ((HexHistogram_19527704_AguileraGonzalez)histogram()).getMaxHexColor();
                for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                    if (((Pixhex_19527704_AguileraGonzalez)p).getHexColor().equals(maxColor)) {
                        c++;
                    }
                }
                int finalLenght = pixlist.size() - c;
                while (pixlist.size() != finalLenght) {
                    Pixel_19527704_AguileraGonzalez auxP = pixlist.get(j);
                    if (((Pixhex_19527704_AguileraGonzalez)auxP).getHexColor().equals(maxColor)) {
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
    
    /**
     * Cambia el pixel de una imagen dependiendo el tipo de esta,
     * según la posición X e Y del pixel entregado como parámetro
     * @param p Pixel de tipo Pixbit, Pixrgb o Pixhex
     */
    @Override
    public void changePixel(Pixel_19527704_AguileraGonzalez p) {
        if (!isCompressed()) {
            if ((p instanceof Pixbit_19527704_AguileraGonzalez && isBitmap()) ||
                (p instanceof Pixrgb_19527704_AguileraGonzalez && isPixmap()) ||
                (p instanceof Pixhex_19527704_AguileraGonzalez && isHexmap())) {
                for (Pixel_19527704_AguileraGonzalez auxP: pixlist) {
                    if (auxP.getPosX() == p.getPosX() &&
                        auxP.getPosY() == p.getPosY()) {
                        auxP.setDepth(p.getDepth());
                        if (isBitmap()) {
                            ((Pixbit_19527704_AguileraGonzalez)auxP).setBitColor(((Pixbit_19527704_AguileraGonzalez)p).getBitColor());
                        }
                        else if (isPixmap()) {
                            ((Pixrgb_19527704_AguileraGonzalez)auxP).setRColor(((Pixrgb_19527704_AguileraGonzalez)p).getRColor());
                            ((Pixrgb_19527704_AguileraGonzalez)auxP).setGColor(((Pixrgb_19527704_AguileraGonzalez)p).getGColor());
                            ((Pixrgb_19527704_AguileraGonzalez)auxP).setBColor(((Pixrgb_19527704_AguileraGonzalez)p).getBColor());
                        }
                        else if (isHexmap()) {
                            ((Pixhex_19527704_AguileraGonzalez)auxP).setHexColor(((Pixhex_19527704_AguileraGonzalez)p).getHexColor());
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Invierte los canales de bit de cada pixel de una imagen Bitmap
     */
    @Override
    public void invertColorBit() {
        if (!isCompressed()) {
            if (isBitmap()) {
                for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                    if (((Pixbit_19527704_AguileraGonzalez)p).getBitColor() == 0) {
                        ((Pixbit_19527704_AguileraGonzalez)p).setBitColor(1);
                    }
                    else {
                        ((Pixbit_19527704_AguileraGonzalez)p).setBitColor(0);
                    }
                }
            }
        }
    }
    
    /**
     * Invierte los canales RGB de cada pixel de una imagen Pixmap
     */
    @Override
    public void invertColorRGB() {
        if (!isCompressed()) {
            if (isPixmap()) {
                int newR, newG, newB;
                for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                    newR = 255 - ((Pixrgb_19527704_AguileraGonzalez)p).getRColor();
                    newG = 255 - ((Pixrgb_19527704_AguileraGonzalez)p).getGColor();
                    newB = 255 - ((Pixrgb_19527704_AguileraGonzalez)p).getBColor();
                    ((Pixrgb_19527704_AguileraGonzalez)p).setRColor(newR);
                    ((Pixrgb_19527704_AguileraGonzalez)p).setGColor(newG);
                    ((Pixrgb_19527704_AguileraGonzalez)p).setBColor(newB);
                }
            }
        }
    }
        
    Comparator<Pixel_19527704_AguileraGonzalez> compareByPosX = (Pixel_19527704_AguileraGonzalez p1, Pixel_19527704_AguileraGonzalez p2) -> 
        Integer.compare(p1.getPosX(), p2.getPosX());
        
    Comparator<Pixel_19527704_AguileraGonzalez> compareByPosY = (Pixel_19527704_AguileraGonzalez p1, Pixel_19527704_AguileraGonzalez p2) -> 
        Integer.compare(p1.getPosY(), p2.getPosY());
    
    /**
     * Ordena la lista de pixeles según posición X y luego Y
     */
    @Override
    public void sortPixlist() {
        Collections.sort(pixlist, compareByPosX);
        Collections.sort(pixlist, compareByPosY);
    }
    
    /**
     * Crea un String que sirve para visualizar la imagen
     * @return String que contiene los pixeles de la imagen
     */
    @Override
    public String imageToString() {
        if (!isCompressed()) {
            String imageString = "";
            sortPixlist();
            if (isBitmap()) {
                for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                    Integer aux = ((Pixbit_19527704_AguileraGonzalez)p).getBitColor();
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
                for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                    int[] aux = ((Pixrgb_19527704_AguileraGonzalez)p).getRgbColor();
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
                for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                    String aux = ((Pixhex_19527704_AguileraGonzalez)p).getHexColor();
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
    
    /**
     * Crea una lista de imágenes donde cada una de estas comparte
     * la misma profundidad para todos sus pixeles
     * @return Lista de imagenes
     */
    @Override
    public ArrayList<Image_19527704_AguileraGonzalez> depthLayers() {
        if (!isCompressed()) {
            ArrayList<Image_19527704_AguileraGonzalez> imageList = new ArrayList<>();
            ArrayList<Integer> depthList = new ArrayList<>();
            ArrayList<Pixel_19527704_AguileraGonzalez> auxPixlist = new ArrayList<>();
            if (isBitmap()) {
                for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                    if (!depthList.contains(p.getDepth())) {
                        depthList.add(p.getDepth());
                    }
                }
                for (int d: depthList) {
                    for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                        if (p.getDepth() != d) {
                            auxPixlist.add(new Pixbit_19527704_AguileraGonzalez(p.getPosX(), p.getPosY(), 1, d));
                        }
                        else {
                            auxPixlist.add(new Pixbit_19527704_AguileraGonzalez(p.getPosX(),p.getPosY(),((Pixbit_19527704_AguileraGonzalez)p).getBitColor(),p.getDepth()));
                        }
                    }
                    imageList.add(new Bitmap_19527704_AguileraGonzalez(width,height,auxPixlist));
                    auxPixlist = new ArrayList<>();
                }
                return imageList;
            }
            
            else if (isPixmap()) {
                for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                    if (!depthList.contains(p.getDepth())) {
                        depthList.add(p.getDepth());
                    }
                }
                for (int d: depthList) {
                    for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                        if (p.getDepth() != d) {
                            auxPixlist.add(new Pixrgb_19527704_AguileraGonzalez(p.getPosX(),
                                    p.getPosY(),255,255,255,d));
                        }
                        else {
                            auxPixlist.add(new Pixrgb_19527704_AguileraGonzalez(p.getPosX(),
                                    p.getPosY(),
                                    ((Pixrgb_19527704_AguileraGonzalez)p).getRColor(),((Pixrgb_19527704_AguileraGonzalez)p).getGColor(),
                                    ((Pixrgb_19527704_AguileraGonzalez)p).getBColor(), p.getDepth()));
                        }
                    }
                    imageList.add(new Pixmap_19527704_AguileraGonzalez(width,height,auxPixlist));
                    auxPixlist = new ArrayList<>();
                }
                return imageList;
            }
            
            else if (isHexmap()) {
                for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                    if (!depthList.contains(p.getDepth())) {
                        depthList.add(p.getDepth());
                    }
                }
                for (int d: depthList) {
                    for (Pixel_19527704_AguileraGonzalez p: pixlist) {
                        if (p.getDepth() != d) {
                            auxPixlist.add(new Pixhex_19527704_AguileraGonzalez(p.getPosX(), p.getPosY(), "#FFFFFF", d));
                        }
                        else {
                            auxPixlist.add(new Pixhex_19527704_AguileraGonzalez(p.getPosX(),p.getPosY(),((Pixhex_19527704_AguileraGonzalez)p).getHexColor(),p.getDepth()));
                        }
                    }
                    imageList.add(new Hexmap_19527704_AguileraGonzalez(width,height,auxPixlist));
                    auxPixlist = new ArrayList<>();
                }
                return imageList;
            }
        }
        return null;
    }
    
}
