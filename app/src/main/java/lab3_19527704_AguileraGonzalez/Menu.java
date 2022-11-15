package lab3_19527704_AguileraGonzalez;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    
    public void menu() {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        
        System.out.println("------ Manipulador de imagenes -----");
        
        while(!salir){
            System.out.println("1. Crear una imagen");
            System.out.println("2. Modificar una imagen");
            System.out.println("3. Visualizar imagen");
            System.out.println("4. Salir\n");
            
            try{
            
                System.out.println("INTRODUZCA SU OPCIÓN: ");

                opcion = sc.nextInt();

                switch(opcion){
                    case 1:
                        System.out.println("Elegiste crear una imagen\n");
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
            
            }catch(InputMismatchException i){
                System.out.println("Debes introducir un número\n");
                sc.next();
            }
        }
        
        System.out.println("Has salido.");
    }
    
}
