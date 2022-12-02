package lab3_19527704_AguileraGonzalez;

/**
 * Representa un pixel de tipo Pixhex con color hexadecimal
 * @author Nicolás Aguilera González
 */
public class Pixhex_19527704_AguileraGonzalez extends Pixel_19527704_AguileraGonzalez {
    
    private String hexColor;

    /**
     * Crea una instancia para la clase Pixhex
     * @param posX Entero representa posición X
     * @param posY Entero representa posición Y
     * @param hexColor String que representa el color hexadecimal del pixel
     * @param depth Entero que representa la profundidad del pixel
     */
    public Pixhex_19527704_AguileraGonzalez(int posX, int posY, String hexColor, int depth) {
        super(posX, posY, depth);
        if (hexColor.charAt(0) == '#' && hexColor.length() == 7) {
            this.hexColor = hexColor;
        }
    }
   
    /**
     * Entrega el color hexadecimal del pixel Pixhex
     * @return String del color hexadecimal
     */
    public String getHexColor() {
        return hexColor;
    }

    /**
     * Establece el color hexadecimal del Pixhex
     * @param hexColor String del color hexadecimal
     */
    public void setHexColor(String hexColor) {
        if (hexColor.charAt(0) == '#' && hexColor.length() == 7) {
            this.hexColor = hexColor;
        }
    }
    
}
