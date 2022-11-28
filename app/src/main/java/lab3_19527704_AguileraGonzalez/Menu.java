package lab3_19527704_AguileraGonzalez;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    
    public void menuExe() {
        
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        int imageType;
        int width, height;
        int posX, posY;
        int bitColor;
        int R, G, B;
        int depth;
        String hexColor;
        Image img1 = pixmapPreCreated();
        ArrayList<Pixel> pixlist;
        ArrayList<Image> imageList;
        
        System.out.println("------ MANIPULADOR DE IMÁGENES -----\n");
        
        while(!salir){
            System.out.println("\nImage Actual: " + currentImage(img1));
            displayMenuOptions();
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    pixlist = new ArrayList<>();
                    displayCreateImageOptions();
                    imageType = sc.nextInt();
                    
                    System.out.print("Introduzca el ancho: ");
                    width = sc.nextInt();
                    System.out.print("Introduzca el largo: ");
                    height = sc.nextInt();
                    System.out.print("\n");
                    
                    switch(imageType) {
                        case 1:
                            for (int j=0; j < (width*height); j++) {
                                System.out.println("Pixel N°" + (j+1));
                                System.out.print("Ingrese posición X: ");
                                posX = sc.nextInt();
                                System.out.print("Ingrese posición Y: ");
                                posY = sc.nextInt();
                                System.out.print("Ingrese valor del Bit: ");
                                bitColor = sc.nextInt();
                                System.out.print("Ingrese la profundidad: ");
                                depth = sc.nextInt();
                                pixlist.add(new Pixbit(posX,posY,bitColor,depth));
                            }
                            img1 = new Bitmap(width,height,pixlist);
                            break;
                        case 2:
                            for (int j=0; j < (width*height); j++) {
                                System.out.println("Pixel N°" + (j+1));
                                System.out.print("Ingrese posición X: ");
                                posX = sc.nextInt();
                                System.out.print("Ingrese posición Y: ");
                                posY = sc.nextInt();
                                System.out.print("Ingrese canal R: ");
                                R = sc.nextInt();
                                System.out.print("Ingrese canal G: ");
                                G = sc.nextInt();
                                System.out.print("Ingrese canal B: ");
                                B = sc.nextInt();
                                System.out.print("Ingrese la profundidad: ");
                                depth = sc.nextInt();
                                pixlist.add(new Pixrgb(posX,posY,R,G,B,depth));
                            }
                            img1 = new Pixmap(width,height,pixlist);
                            break;
                        case 3:
                            for (int j=0; j < (width*height); j++) {
                                System.out.println("Pixel N°" + (j+1));
                                System.out.print("Ingrese posición X: ");
                                posX = sc.nextInt();
                                System.out.print("Ingrese posición Y: ");
                                posY = sc.nextInt();
                                System.out.print("Ingrese color hexadecimal: ");
                                hexColor = sc.next();
                                System.out.print("Ingrese la profundidad: ");
                                depth = sc.nextInt();
                                pixlist.add(new Pixhex(posX,posY,hexColor,depth));
                            }
                            img1 = new Hexmap(width,height,pixlist);
                            break;
                    }
                    break;
                case 2:
                    displayFunctions();
                    opcion = sc.nextInt();
                    System.out.print("\n");
                    switch(opcion) {
                        case 1:
                            img1.flipH();
                            break;
                        case 2:
                            img1.flipV();
                            break;
                        case 3:
                            int x1, y1, x2, y2;
                            System.out.print("Introduzca x1: ");
                            x1 = sc.nextInt();
                            System.out.print("Introduzca y1: ");
                            y1 = sc.nextInt();
                            System.out.print("Introduzca x2: ");
                            x2 = sc.nextInt();
                            System.out.print("Introduzca y2: ");
                            y2 = sc.nextInt();
                            img1.crop(x1, y1, x2, y2);
                            break;
                        case 4:
                            if (img1.isPixmap()) {
                                img1 = img1.imgRGBToHex();
                            }
                            else {
                                System.out.println("Tipo de imagen no corresponde.");
                            }
                            break;
                        case 5:
                            img1.rotate90();
                            break;
                        case 6:
                            img1.compress();
                            break;
                        case 7:
                            if (img1.isBitmap()) {
                                System.out.println("Introduzca un Pixbit:");
                                System.out.print("Ingrese posición X: ");
                                posX = sc.nextInt();
                                System.out.print("Ingrese posición Y: ");
                                posY = sc.nextInt();
                                System.out.print("Ingrese valor del Bit: ");
                                bitColor = sc.nextInt();
                                System.out.print("Ingrese la profundidad: ");
                                depth = sc.nextInt();
                                img1.changePixel(new Pixbit(posX,posY,bitColor,depth));
                            }
                            else if (img1.isPixmap()) {
                                System.out.println("Introduzca un Pixrgb:");
                                System.out.print("Ingrese posición X: ");
                                posX = sc.nextInt();
                                System.out.print("Ingrese posición Y: ");
                                posY = sc.nextInt();
                                System.out.print("Ingrese canal R: ");
                                R = sc.nextInt();
                                System.out.print("Ingrese canal G: ");
                                G = sc.nextInt();
                                System.out.print("Ingrese canal B: ");
                                B = sc.nextInt();
                                System.out.print("Ingrese la profundidad: ");
                                depth = sc.nextInt();
                                img1.changePixel(new Pixrgb(posX,posY,R,G,B,depth));
                            }
                            else if (img1.isHexmap()) {
                                System.out.print("Ingrese posición X: ");
                                posX = sc.nextInt();
                                System.out.print("Ingrese posición Y: ");
                                posY = sc.nextInt();
                                System.out.print("Ingrese color hexadecimal: ");
                                hexColor = sc.next();
                                System.out.print("Ingrese la profundidad: ");
                                depth = sc.nextInt();
                                img1.changePixel(new Pixhex(posX,posY,hexColor,depth));
                            }
                            break;
                        case 8:
                            if (img1.isBitmap()) {
                                img1.invertColorBit();
                            }
                            else {
                                System.out.println("Tipo de imagen no corresponde.");
                            }
                            break;
                        case 9:
                            if (img1.isPixmap()) {
                                img1.invertColorRGB();
                            }
                            else {
                                System.out.println("Tipo de imagen no corresponde");
                            }
                            break;
                        case 10:
                            imageList = img1.depthLayers();
                            for (Image image: imageList) {
                                System.out.println("Imagen profundidad " + image.getPixlist().get(0).getDepth() + ":");
                                System.out.println(image.imageToString());
                            }
                            break;                        
                    }
                    break;
                case 3:
                    System.out.println(img1.imageToString());
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("La opción es incorrecta\n");
            }
        }
        System.out.println("Has salido.");
    }
    
    public void displayMenuOptions() {
        System.out.println("1. Crear imagen");
        System.out.println("2. Modificar imagen");
        System.out.println("3. Visualizar imagen");
        System.out.println("4. Salir\n");

        System.out.print("Introduzca su opción: ");
    }
    
    public void displayCreateImageOptions() {
        System.out.println("Elija el tipo de imagen que desea crear:");
        System.out.println("1. Bitmap");
        System.out.println("2. Pixmap");
        System.out.println("3. Hexmap");

        System.out.print("Introduzca su opción: ");
    }
    
    public void displayFunctions() {
        System.out.println("\nSelecciona la modificación a realizar: ");
        System.out.println("1. Voltear Horizontalmente");
        System.out.println("2. Voltear Verticalmente");
        System.out.println("3. Recortar");
        System.out.println("4. Cambiar de RGB a Hexadecimal");
        System.out.println("5. Voltear 90 sentido horario");
        System.out.println("6. Comprimir imagen");
        System.out.println("7. Cambiar un pixel");
        System.out.println("8. Invertir Bits");
        System.out.println("9. Invertir canales RGB");
        System.out.println("10. Capas de profundidad");
        
        System.out.print("Introduzca su opción: ");
    }
    
    public String currentImage(Image i) {
        if (i.isBitmap()) {
            return "Bitmap de " + i.getWidth() + "x" + i.getHeight();
        }
        else if (i.isPixmap()) {
            return "Pixmap de " + i.getWidth() + "x" + i.getHeight();
        }
        else if (i.isHexmap()) {
            return "Hexmap de " + i.getWidth() + "x" + i.getHeight();
        }
        return "";
    }
    
    public Image pixmapPreCreated() {
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
        return img1;
    }
    
    
}
