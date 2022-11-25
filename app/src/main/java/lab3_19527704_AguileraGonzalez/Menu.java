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
        Image img1 = new Image();
        Image img2;
        ArrayList<Pixel> pixlist;
        
        System.out.println("------ MANIPULADOR DE IMÁGENES -----");
        
        while(!salir){
            displayMenuOptions();
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    pixlist = new ArrayList<>();
                    displayCreateImageOptions();
                    imageType = sc.nextInt();
                    
                    System.out.print("Introduzca el ANCHO: ");
                    width = sc.nextInt();
                    System.out.print("Introduzca el LARGO: ");
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
                                hexColor = sc.nextLine();
                                System.out.print("Ingrese la profundidad: ");
                                depth = sc.nextInt();
                                pixlist.add(new Pixhex(posX,posY,hexColor,depth));
                            }
                            img1 = new Hexmap(width,height,pixlist);
                            break;
                    }
                    break;
                case 2:
                    opcion = sc.nextInt();
                    switch(opcion) {
                        case 1:
                            img1.flipH();
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            break;
                        case 9:
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
        System.out.println("1. Crear una imagen");
        System.out.println("2. Modificar una imagen");
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
        System.out.println("Selecciona la modificación a realizar: ");
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
    }
    
}
