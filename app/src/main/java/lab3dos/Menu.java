package lab3dos;

import java.util.Scanner;

public class Menu {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        int width, height;
        int bitColor;
        int R, G, B;
        String hexColor;
        Image img1;
        Image img2;
        
        System.out.println("------ MANIPULADOR DE IMÁGENES -----");
        
        while(!salir){
            System.out.println("1. Crear una imagen");
            System.out.println("2. Modificar una imagen");
            System.out.println("3. Visualizar imagen");
            System.out.println("4. Salir\n");
            
            System.out.println("Introduzca su opción: ");
            opcion = sc.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("Elija el tipo de imagen que desea crear:");
                    System.out.println("1. Bitmap");
                    System.out.println("2. Pixmap");
                    System.out.println("3. Hexmap");
                    
                    System.out.println("Introduzca su opción: ");
                    opcion = sc.nextInt();
                    
                    System.out.println("Introduzca el ANCHO: ");
                    width = sc.nextInt();
                    System.out.println("Introduzca el LARGO: ");
                    height = sc.nextInt();
                    
                    switch(opcion) {
                        case 1:
                            
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Elegiste modificar una imagen\n");
                    break;
                case 3:
                    System.out.println("Elegiste visualizar una imagen\n");
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
    
}