package lab3dos;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        /*
        Pixbit p1 = new Pixbit(1,1,1,6);
        Pixbit p2 = new Pixbit(0,1,0,4);
        Pixbit p3 = new Pixbit(0,0,1,6);
        Pixbit p4 = new Pixbit(1,0,1,2);
        
        ArrayList<Pixel> pixlist = new ArrayList<>();
        pixlist.add(p1);
        pixlist.add(p2);
        pixlist.add(p3);
        pixlist.add(p4);
        
        Image img1 = new Bitmap(2,2,pixlist);
        
        for (Pixel p: img1.getPixlist()) {
            System.out.println(p.getPosX() + " " + p.getPosY() + 
                    " " + ((Pixbit)p).getBitColor() + " " + p.getDepth());
        }
        
        System.out.println("isBitmap? " + img1.isBitmap());
        System.out.println("isPixmap? " + img1.isPixmap());
        System.out.println("isHexmap? " + img1.isHexmap());
        System.out.println("isCompressed? " + img1.isCompressed());
        
        System.out.println("Ancho de la imagen: " + img1.getWidth());
        System.out.println("Alto de la imagen: " + img1.getHeight());
        
        System.out.println("Dimensiones de la imagen: " + img1.getWidth() + "x" + img1.getHeight());
        img1.rotate90();
        System.out.println("Dimensiones de la imagen rotada: " + img1.getWidth() + "x" + img1.getHeight());
        img1.rotate90(); img1.rotate90(); img1.rotate90();
        
        Histogram h1 = img1.histogram();
        System.out.println("Color más frecuente: " + ((BitHistogram) h1).getMaxBitColor());
        String s = img1.imageToString();
        System.out.println("\n");
        System.out.println(s);
        
        ArrayList<Image> imgl = img1.depthLayers();
        for (Image im: imgl) {
            for (Pixel px: im.getPixlist()) {
                System.out.println(px.getPosX() + " " + px.getPosY() + 
                    " " + ((Pixbit)px).getBitColor() + " " + px.getDepth());
            }
        }
        
        img1.invertColorBit();
        for (Pixel p: img1.getPixlist()) {
            System.out.println(p.getPosX() + " " + p.getPosY() + 
                    " " + ((Pixbit)p).getBitColor() + " " + p.getDepth());
        }
        
        img1.compress();
        System.out.println("isCompressed? " + img1.isCompressed());
        for (Pixel p: img1.getPixlist()) {
            System.out.println(p.getPosX() + " " + p.getPosY() + 
                    " " + ((Pixbit)p).getBitColor() + " " + p.getDepth());
        }
        */
        
        // PIXMAP
        /*
        Pixel p1 = new Pixrgb(0,0,20,200,120,6);
        Pixel p2 = new Pixrgb(0,1,45,20,20,4);
        Pixel p3 = new Pixrgb(1,0,20,200,120,4);
        Pixel p4 = new Pixrgb(1,1,20,200,120,2);
        Pixel p5 = new Pixrgb(2,0,20,200,120,6);
        Pixel p6 = new Pixrgb(2,1,45,20,20,2);
        
        ArrayList<Pixel> pixlist = new ArrayList<>();
        pixlist.add(p1);
        pixlist.add(p2);
        pixlist.add(p3);
        pixlist.add(p4);
        pixlist.add(p5);
        pixlist.add(p6);
        
        Image img1 = new Pixmap(3,2,pixlist);
        img1.sortPixlist();
        
        for (Pixel p: img1.getPixlist()) {
            System.out.println(p.getPosX() + " " + p.getPosY() + 
                    " " + ((Pixrgb)p).getRColor() + " " +
                    ((Pixrgb)p).getGColor() + " " + 
                    ((Pixrgb)p).getBColor() + " " + p.getDepth());
        }
        
        System.out.println("isBitmap? " + img1.isBitmap());
        System.out.println("isPixmap? " + img1.isPixmap());
        System.out.println("isHexmap? " + img1.isHexmap());
        System.out.println("isCompressed? " + img1.isCompressed());
        
        img1.flipH();
        for (Pixel p: img1.getPixlist()) {
            System.out.println(p.getPosX() + " " + p.getPosY() + 
                    " " + ((Pixrgb)p).getRgbColor()[0] + " " +
                    ((Pixrgb)p).getRgbColor()[1] + " " + 
                    ((Pixrgb)p).getRgbColor()[2] + " " + p.getDepth());
        }
        img1.flipH();
        
        
        System.out.println("Dimensiones de la imagen: " + img1.getWidth() + "x" + img1.getHeight());
        img1.rotate90();
        System.out.println("Dimensiones de la imagen rotada: " + img1.getWidth() + "x" + img1.getHeight());
        img1.rotate90(); img1.rotate90(); img1.rotate90();
        
        Image img2 = img1.imgRGBToHex();
        System.out.println("imgRGBtoHex");
        for (Pixel p: img2.getPixlist()) {
            System.out.println(p.getPosX() + " " + p.getPosY() + 
                    " " + ((Pixhex)p).getHexColor() + " " + p.getDepth());
        }
        
        Histogram h1 = img1.histogram();
        System.out.println("Color más frecuente: " + ((RgbHistogram) h1).getMaxRgbColor()[0] + " " +
                ((RgbHistogram) h1).getMaxRgbColor()[1] + " " +
                ((RgbHistogram) h1).getMaxRgbColor()[2]);
        String s = img1.imageToString();
        System.out.println("\n");
        System.out.println(s);
        
        
        ArrayList<Image> imgl = img1.depthLayers();
        for (Image im: imgl) {
            for (Pixel p: im.getPixlist()) {
                System.out.println(p.getPosX() + " " + p.getPosY() + 
                    " " + ((Pixrgb)p).getRgbColor()[0] + " " +
                    ((Pixrgb)p).getRgbColor()[1] + " " + 
                    ((Pixrgb)p).getRgbColor()[2] + " " + p.getDepth());
            }
            System.out.println("\n");
        }
        
        img1.invertColorRGB();
        for (Pixel p: img1.getPixlist()) {
            System.out.println(p.getPosX() + " " + p.getPosY() + 
                    " " + ((Pixrgb)p).getRgbColor()[0] + " " +
                    ((Pixrgb)p).getRgbColor()[1] + " " + 
                    ((Pixrgb)p).getRgbColor()[2] + " " + p.getDepth());
        }
        
        img1.compress();
        System.out.println("isCompressed? " + img1.isCompressed());
        for (Pixel p: img1.getPixlist()) {
            System.out.println(p.getPosX() + " " + p.getPosY() + 
                    " " + ((Pixrgb)p).getRgbColor()[0] + " " +
                    ((Pixrgb)p).getRgbColor()[1] + " " + 
                    ((Pixrgb)p).getRgbColor()[2] + " " + p.getDepth());
        }
        */
        
        Pixhex p1 = new Pixhex(1,1,"#ABBD2A",4);
        Pixhex p2 = new Pixhex(0,1,"#ABBD2A",4);
        Pixhex p3 = new Pixhex(0,0,"#AAAAAA",7);
        Pixhex p4 = new Pixhex(1,0,"#AACCDD",2);
        Pixhex p5 = new Pixhex(2,1,"#AAAAAA",7);
        Pixhex p6 = new Pixhex(2,0,"#ABBD2A",4);
        
        ArrayList<Pixel> pixlist = new ArrayList<>();
        pixlist.add(p1);
        pixlist.add(p2);
        pixlist.add(p3);
        pixlist.add(p4);
        pixlist.add(p5);
        pixlist.add(p6);
        
        Image img1 = new Hexmap(3,2,pixlist);
        
        img1.sortPixlist();
        for (Pixel p: img1.getPixlist()) {
            System.out.println(p.getPosX() + " " + p.getPosY() + 
                    " " + ((Pixhex)p).getHexColor() + " " + p.getDepth());
        }
        
        System.out.println("isBitmap? " + img1.isBitmap());
        System.out.println("isPixmap? " + img1.isPixmap());
        System.out.println("isHexmap? " + img1.isHexmap());
        System.out.println("isCompressed? " + img1.isCompressed());
        
        System.out.println("Dimensiones de la imagen: " + img1.getWidth() + "x" + img1.getHeight());
        img1.rotate90();
        System.out.println("Dimensiones de la imagen rotada: " + img1.getWidth() + "x" + img1.getHeight());
        img1.rotate90(); img1.rotate90(); img1.rotate90();
        
        Histogram h1 = img1.histogram();
        System.out.println("Color más frecuente: " + ((HexHistogram) h1).getMaxHexColor());
        String s = img1.imageToString();
        System.out.println("\n");
        System.out.println(s);
        
        ArrayList<Image> imgl = img1.depthLayers();
        for (Image im: imgl) {
            for (Pixel p: im.getPixlist()) {
                System.out.println(((Pixhex)p).getHexColor());
            }
            System.out.println("\n");
        }
        
        img1.compress();
        System.out.println("isCompressed? " + img1.isCompressed());
        for (Pixel p: img1.getPixlist()) {
            System.out.println(p.getPosX() + " " + p.getPosY() + 
                    " " + ((Pixhex)p).getHexColor() + " " + p.getDepth());
        }
        
    }

    Object getGreeting() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
