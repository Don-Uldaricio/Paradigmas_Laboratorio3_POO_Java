package lab3_19527704_AguileraGonzalez;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Representa un Menu interactivo donde el usuario puede crear, modificar
 * y visualizar imágenes de cualquier tipo
 * @author Nicolás Aguilera González
 */
public class Menu_19527704_AguileraGonzalez {
    
    /**
     * Método principal del Menu que permite elegir diferentes opciones
     */
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
        Image_19527704_AguileraGonzalez img1 = pixmapPreCreated();
        ArrayList<Pixel_19527704_AguileraGonzalez> pixlist;
        ArrayList<Image_19527704_AguileraGonzalez> imageList;
        
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
                                pixlist.add(new Pixbit_19527704_AguileraGonzalez(posX,posY,bitColor,depth));
                            }
                            img1 = new Bitmap_19527704_AguileraGonzalez(width,height,pixlist);
                            System.out.println("Imagen creada con éxito!");
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
                                pixlist.add(new Pixrgb_19527704_AguileraGonzalez(posX,posY,R,G,B,depth));
                            }
                            img1 = new Pixmap_19527704_AguileraGonzalez(width,height,pixlist);
                            System.out.println("Imagen creada con éxito!");
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
                                pixlist.add(new Pixhex_19527704_AguileraGonzalez(posX,posY,hexColor,depth));
                            }
                            img1 = new Hexmap_19527704_AguileraGonzalez(width,height,pixlist);
                            System.out.println("Imagen creada con éxito!");
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
                            System.out.println("Acción realizada exitosamente.");
                            break;
                        case 2:
                            img1.flipV();
                            System.out.println("Acción realizada exitosamente.");
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
                            System.out.println("Acción realizada exitosamente.");
                            break;
                        case 4:
                            if (img1.isPixmap()) {
                                img1 = img1.imgRGBToHex();
                                System.out.println("Acción realizada exitosamente.");
                            }
                            else {
                                System.out.println("Tipo de imagen no corresponde.");
                            }
                            break;
                        case 5:
                            img1.rotate90();
                            System.out.println("Acción realizada exitosamente.");
                            break;
                        case 6:
                            img1.compress();
                            System.out.println("Acción realizada exitosamente.");
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
                                img1.changePixel(new Pixbit_19527704_AguileraGonzalez(posX,posY,bitColor,depth));
                                System.out.println("Acción realizada exitosamente.");
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
                                img1.changePixel(new Pixrgb_19527704_AguileraGonzalez(posX,posY,R,G,B,depth));
                                System.out.println("Acción realizada exitosamente.");
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
                                img1.changePixel(new Pixhex_19527704_AguileraGonzalez(posX,posY,hexColor,depth));
                                System.out.println("Acción realizada exitosamente.");
                            }
                            break;
                        case 8:
                            if (img1.isBitmap()) {
                                img1.invertColorBit();
                                System.out.println("Acción realizada exitosamente.");
                            }
                            else {
                                System.out.println("Tipo de imagen no corresponde.");
                            }
                            break;
                        case 9:
                            if (img1.isPixmap()) {
                                img1.invertColorRGB();
                                System.out.println("Acción realizada exitosamente.");
                            }
                            else {
                                System.out.println("Tipo de imagen no corresponde");
                            }
                            break;
                        case 10:
                            imageList = img1.depthLayers();
                            for (Image_19527704_AguileraGonzalez image: imageList) {
                                System.out.println("Imagen profundidad " + image.getPixlist().get(0).getDepth() + ":");
                                System.out.println(image.imageToString());
                            }
                            break;
                        case 11:
                            if (img1.isBitmap()){
                                System.out.println("La imagen es Bitmap");
                            }
                            else {
                                System.out.println("La imagen NO es Bitmap");
                            }
                            break;
                        case 12:
                            if (img1.isPixmap()){
                                System.out.println("La imagen es Pixmap");
                            }
                            else {
                                System.out.println("La imagen NO es Pixmap");
                            }
                            break;
                        case 13:
                            if (img1.isHexmap()){
                                System.out.println("La imagen es Hexmap");
                            }
                            else {
                                System.out.println("La imagen NO es Hexmap");
                            }
                            break;
                        case 14:
                            if (img1.isCompressed()){
                                System.out.println("La imagen está comprimida");
                            }
                            else {
                                System.out.println("La imagen NO está comprimida");
                            }
                            break;
                        case 15:
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
    
    /**
     * Imprime en pantalla una serie de opciones
     */
    public void displayMenuOptions() {
        System.out.println("1. Crear imagen");
        System.out.println("2. Modificar imagen");
        System.out.println("3. Visualizar imagen");
        System.out.println("4. Salir\n");

        System.out.print("Introduzca su opción: ");
    }
    
    /**
     * Imprime en pantalla opciones para crear imagen
     */
    public void displayCreateImageOptions() {
        System.out.println("Elija el tipo de imagen que desea crear:");
        System.out.println("1. Bitmap");
        System.out.println("2. Pixmap");
        System.out.println("3. Hexmap");

        System.out.print("Introduzca su opción: ");
    }
    
    /**
     * Imprime en pantalla opciones para modificar una imagen
     */
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
        System.out.println("11. Verificar Bitmap");
        System.out.println("12. Verificar Pixmap");
        System.out.println("13. Verificar Hexmap");
        System.out.println("14. Verificar Compresión");
        System.out.println("\n15. Volver a Menú Principal\n");
        
        System.out.print("Introduzca su opción: ");
    }
    
    /**
     * Imprime en pantalla tipo de imagen y dimensiones de esta
     * @param i Imagen de cualquier tipo
     * @return String que indica tipo de imagen
     */
    public String currentImage(Image_19527704_AguileraGonzalez i) {
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
    
    /**
     * Crea una imagen de tipo Pixmap para que la interfaz tenga una
     * precargada y facilitar el uso del menu
     * @return Imagen tipo Pixmap
     */
    public Image_19527704_AguileraGonzalez pixmapPreCreated() {
        Pixel_19527704_AguileraGonzalez p1 = new Pixrgb_19527704_AguileraGonzalez(0,0,20,200,120,6);
        Pixel_19527704_AguileraGonzalez p2 = new Pixrgb_19527704_AguileraGonzalez(0,1,45,20,20,4);
        Pixel_19527704_AguileraGonzalez p3 = new Pixrgb_19527704_AguileraGonzalez(1,0,20,200,120,4);
        Pixel_19527704_AguileraGonzalez p4 = new Pixrgb_19527704_AguileraGonzalez(1,1,20,200,120,2);
        Pixel_19527704_AguileraGonzalez p5 = new Pixrgb_19527704_AguileraGonzalez(2,0,60,180,100,6);
        Pixel_19527704_AguileraGonzalez p6 = new Pixrgb_19527704_AguileraGonzalez(2,1,70,23,67,2);
        
        ArrayList<Pixel_19527704_AguileraGonzalez> pixlist = new ArrayList<>();
        pixlist.add(p1); pixlist.add(p2); pixlist.add(p3);
        pixlist.add(p4); pixlist.add(p5); pixlist.add(p6);
        
        Image_19527704_AguileraGonzalez img1 = new Pixmap_19527704_AguileraGonzalez(3,2,pixlist);
        return img1;
    }
    
    
}
