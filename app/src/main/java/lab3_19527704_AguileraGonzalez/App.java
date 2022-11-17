package lab3_19527704_AguileraGonzalez;

import java.util.ArrayList;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        
        Pixbit p1 = new Pixbit(0,0,1,6);
        Pixbit p2 = new Pixbit(0,1,0,4);
        Pixbit p3 = new Pixbit(1,0,1,6);
        Pixbit p4 = new Pixbit(1,1,1,2);
        
        ArrayList<Pixel> pixlist = new ArrayList<Pixel>();
        pixlist.add(p1);
        pixlist.add(p2);
        pixlist.add(p3);
        pixlist.add(p4);
        
        Image img1 = new Image(2,2,pixlist);
        
        for(int i=0; i<img1.getPixlist().size();i++) {
            System.out.println("Datos pixel n" + (i+1) + ":");
            System.out.println("PosX: " + img1.getPixlist().get(i).getPosX());
            System.out.println("PosY: " + img1.getPixlist().get(i).getPosY());
            System.out.println(((Pixbit)img1.getPixlist().get(i)).getBitColor());
            System.out.println("Depth: " + img1.getPixlist().get(i).getDepth());
            System.out.println("\n");
        }
        
        System.out.println("isBitmap? " + img1.isBitmap());
        System.out.println("isBitmap? " + img1.isPixmap());
        System.out.println("isBitmap? " + img1.isHexmap());
        System.out.println("isCompressed? " + img1.isCompressed());
    }
}
