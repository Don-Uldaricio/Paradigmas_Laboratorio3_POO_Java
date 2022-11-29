package lab3_19527704_AguileraGonzalez;

import java.util.ArrayList;

/**
 * Representa una Imagen de tipo Bitmap donde sus pixeles son Pixbit
 * @author Nicolás Aguilera González
 */
public class Bitmap extends Image {
    
    int compressedColor;

    /**
     * Crea una instancia para la clase Bitmap
     * @param width Ancho de la imagen
     * @param height Alto de la imagen
     * @param pixlist Lista de pixeles Pixbit
     */
    public Bitmap(int width, int height, ArrayList<Pixel> pixlist) {
        super(width, height, pixlist);
    }

    /**
     * Entrega el color comprimido del Bitmap
     * @return Entero que representa color tipo bit
     */
    public int getCompressedColor() {
        return compressedColor;
    }

    /**
     * Establece el color comprimido de la imagen por el parámetro entregado
     * @param compressedColor Entero que representa color tipo bit
     */
    public void setCompressedColor(int compressedColor) {
        if (compressedColor == 0 || compressedColor == 1) {
            this.compressedColor = compressedColor;
        }
    }
    
}
