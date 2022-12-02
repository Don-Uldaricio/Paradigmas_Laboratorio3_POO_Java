package lab3_19527704_AguileraGonzalez;

import java.util.ArrayList;

/**
 * Representa una imagen de tipo Hexmap con un String representando el valor
 * del color comprimido
 * @author Nicolás Aguilera González
 */
public class Hexmap_19527704_AguileraGonzalez extends Image_19527704_AguileraGonzalez {
    
    private String compressedColor;

    /**
     * Crea una instancia para la clase Hexmap
     * @param width Ancho de la imagen
     * @param height Alto de la imagen
     * @param pixlist Lista de pixeles Pixhex
     */
    public Hexmap_19527704_AguileraGonzalez(int width, int height, ArrayList<Pixel_19527704_AguileraGonzalez> pixlist) {
        super(width, height, pixlist);
    }

    /**
     * Entrega el color comprimido de la imagen
     * @return String que representa color hexadecimal
     */
    public String getCompressedColor() {
        return compressedColor;
    }

    /**
     * Establece el color comprimido de la imagen
     * @param compressedColor String que representa color hexadecimal
     */
    public void setCompressedColor(String compressedColor) {
        if (compressedColor.charAt(0) == '#' &&
            compressedColor.length() == 7) {
            this.compressedColor = compressedColor;
        }
    }
    
}
