package lab3_19527704_AguileraGonzalez;

/**
 * Representa una imagen tipo Pixbit con color bit
 * @author Nicolás Aguilera González
 */
public class Pixbit extends Pixel {
    
    int bitColor;

    /**
     * Crea una instancia para la clase Pixbit
     * @param posX Entero posición X
     * @param posY Entero posición Y
     * @param bitColor Entero color bit (0 o 1)
     * @param depth Entero representa profundidad
     */
    public Pixbit(int posX, int posY, int bitColor, int depth) {
        super(posX, posY, depth);
        if (bitColor == 0 || bitColor == 1) {
            this.bitColor = bitColor;
        }
    }

    /**
     * Entrega el color del Pixbit
     * @return Entero 0 o 1
     */
    public int getBitColor() {
        return bitColor;
    }

    /**
     * Establece el color bit del Pixbit
     * @param bitColor Entero 0 o 1
     */
    public void setBitColor(int bitColor) {
        if (bitColor == 0 || bitColor == 1) {
            this.bitColor = bitColor;
        }
    }
    
}
