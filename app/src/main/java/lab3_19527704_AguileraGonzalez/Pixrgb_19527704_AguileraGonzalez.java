package lab3_19527704_AguileraGonzalez;

/**
 * Representa un pixel de tipo Pixrgb con color RGB
 * @author Nicolás Aguilera González
 */
public class Pixrgb_19527704_AguileraGonzalez extends Pixel_19527704_AguileraGonzalez {
    
    private int[] rgbColor;

    /**
     * Crea una instancia de la clase Pixrgb
     * @param posX Entero posición X
     * @param posY Entero posición Y
     * @param R Entero canal rojo
     * @param G Entero canal verde
     * @param B ENtero canal azul
     * @param depth Entero profundidad pixel
     */
    public Pixrgb_19527704_AguileraGonzalez(int posX, int posY, int R, int G, int B, int depth) {
        super(posX, posY, depth);
        this.rgbColor = new int[3];
        this.rgbColor[0] = R;
        this.rgbColor[1] = G;
        this.rgbColor[2] = B;
    }

    /**
     * Entrega el color RGB del pixel
     * @return Arreglo de 3 enteros con los canales RGB
     */
    public int[] getRgbColor() {
        return rgbColor;
    }

    /**
     * Establece el color RGB de un pixel
     * @param rgbColor Arreglo de 3 enteros con los canales RGB
     */
    public void setRgbColor(int[] rgbColor) {
        this.rgbColor = rgbColor;
    }
    
    /**
     * Entrega el canal rojo del Pixrgb
     * @return Entero que representa el canal del color rojo
     */
    public int getRColor() {
        return rgbColor[0];
    }
    
    /**
     * Establece el canal rojo del pixel
     * @param redColor Entero canal rojo
     */
    public void setRColor(int redColor) {
        this.rgbColor[0] = redColor;
    }
    
    /**
     * Entrega el canal verde del pixel
     * @return Entero canal verde
     */
    public int getGColor() {
        return rgbColor[1];
    }
    
    /**
     * Establece el canal verde de un Pixrgb
     * @param greenColor Entero canal verde
     */
    public void setGColor(int greenColor) {
        this.rgbColor[1] = greenColor;
    }
    
    /**
     * Entrega el canal azul de un Pixrgb
     * @return Entero canal azul
     */
    public int getBColor() {
        return rgbColor[2];
    }
    
    /**
     * Establece el canal azul de un Pixrgb
     * @param blueColor Entero canal azul
     */
    public void setBColor(int blueColor) {
        this.rgbColor[2] = blueColor;
    }
    
    /**
     * Entrega un String al cambiar los canales RGB a color hexadecimal
     * @return String que representa el color RGB en hexadecimal
     */
    public String rgbToHex() {
        return String.format("#%02X%02X%02X", rgbColor[0], rgbColor[1], rgbColor[2]);
    }
    
}

