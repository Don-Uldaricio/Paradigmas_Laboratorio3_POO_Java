package lab3_19527704_AguileraGonzalez;

import java.util.ArrayList;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        
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
    }
}
