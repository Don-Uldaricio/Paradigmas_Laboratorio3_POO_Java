package lab3_19527704_AguileraGonzalez;

public class Pixhex extends Pixel {
    
    String hexColor;

    public Pixhex() {
    }

    public Pixhex(int posX, int posY, String hexColor, int depth) {
        super(posX, posY, depth);
        if (hexColor.charAt(0) == '#' && hexColor.length() == 7) {
            this.hexColor = hexColor;
        }
    }
   
    public String getHexColor() {
        return hexColor;
    }

    public void setHexColor(String hexColor) {
        if (hexColor.charAt(0) == '#' && hexColor.length() == 7) {
            this.hexColor = hexColor;
        }
    }
    
}
