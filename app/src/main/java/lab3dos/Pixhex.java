package lab3dos;

public class Pixhex extends Pixel {
    
    String hexColor;

    public Pixhex() {
    }

    public Pixhex(int posX, int posY, String hexColor, int depth) {
        super(posX, posY, depth);
        this.hexColor = hexColor;
    }

    public String getHexColor() {
        return hexColor;
    }

    public void setHexColor(String hexColor) {
        this.hexColor = hexColor;
    }
    
    public boolean isPixhex() {
        return (hexColor.charAt(0) == '#' && hexColor.length() == 7);
    }
    
}
