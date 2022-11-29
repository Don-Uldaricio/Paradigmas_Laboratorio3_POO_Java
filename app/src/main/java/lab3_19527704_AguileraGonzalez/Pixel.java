package lab3_19527704_AguileraGonzalez;

/**
 * Representa un Pixel con posición X, Y y profundidad
 * @author nez
 */
public class Pixel {
    
    int posX;
    int posY;
    int depth;

    /**
     * Crea una instancia para la clase Pixel
     * @param posX Entero que representa posición X
     * @param posY Entero que representa posición Y
     * @param depth Entero que representa profundidad del pixel
     */
    public Pixel(int posX, int posY, int depth) {
        this.posX = posX;
        this.posY = posY;
        this.depth = depth;
    }

    /**
     * Entrega la posición X del pixel
     * @return Entero de la posición X
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Establece la posicíon X de un pixel
     * @param posX Entero que representa la posición X del pixel
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Entrega la posición Y del pixel
     * @return Entero que representa la posición Y del pixel
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Establece la posición Y del pixel
     * @param posY Entero representa pos Y
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Entrega la profundidad del pixel
     * @return Entero que representa la profundidad
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Establece la profundidad del pixe
     * @param depth Entero que representa la profundidad
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }
    
}
