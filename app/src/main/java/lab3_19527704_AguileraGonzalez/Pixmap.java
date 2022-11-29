package lab3_19527704_AguileraGonzalez;

import java.util.ArrayList;

/**
 * Representa una imagen de tipo Pixmap con pixeles Pixrgb
 * @author Nicolás Aguilera González
 */
public class Pixmap extends Image {
    
    int[] compressedColor;

    /**
     * Crea una instancia de la clase Pixmap
     * @param width Entero que representa el ancho de la imagen
     * @param height Entero que representa el alto de la imagen
     * @param pixlist Lista de pixeles Pixrgb de la imagen
     */
    public Pixmap(int width, int height, ArrayList<Pixel> pixlist) {
        super(width, height, pixlist);
        this.compressedColor = new int[3];
    }

    /**
     * Entrega el color RGB comprimido de la imagen
     * @return Arreglo de enteros con color RGB
     */
    public int[] getCompressedColor() {
        return compressedColor;
    }

    /**
     * Establece el color RGB comprimido de una imagen
     * @param compressedColor Arreglo de 3 enteros con colores RGB
     */
    public void setCompressedColor(int[] compressedColor) {
        if (compressedColor[0] >= 0 && compressedColor[0] <= 255 &&
            compressedColor[1] >= 0 && compressedColor[1] <= 255 &&
            compressedColor[2] >= 0 && compressedColor[2] <= 255 ) {
            this.compressedColor = compressedColor;
        }
    }
    
}
