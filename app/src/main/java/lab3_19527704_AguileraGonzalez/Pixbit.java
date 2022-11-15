package lab3_19527704_AguileraGonzalez;

public class Pixbit extends Pixel {
    
    int bitColor;

    public Pixbit() {
    }

    public Pixbit(int posX, int posY, int bitColor, int depth) {
        super(posX, posY, depth);
        if (bitColor == 0 || bitColor == 1) {
            this.bitColor = bitColor;
        }
    }

    public int getBitColor() {
        return bitColor;
    }

    public void setBitColor(int bitColor) {
        if (bitColor == 0 || bitColor == 1) {
            this.bitColor = bitColor;
        }
    }
    
}
