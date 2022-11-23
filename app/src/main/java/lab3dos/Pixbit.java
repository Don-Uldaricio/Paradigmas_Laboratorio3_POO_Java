package lab3dos;

public class Pixbit extends Pixel {
    
    int bitColor;

    public Pixbit() {
    }

    public Pixbit(int posX, int posY, int bitColor, int depth) {
        super(posX, posY, depth);
        this.bitColor = bitColor;
    }
    
    public int getBitColor() {
        return bitColor;
    }

    public void setBitColor(int bitColor) {
        this.bitColor = bitColor;
    }
    
    public boolean isPixbit() {
        return bitColor == 0 || bitColor == 1;
    }
    
}
