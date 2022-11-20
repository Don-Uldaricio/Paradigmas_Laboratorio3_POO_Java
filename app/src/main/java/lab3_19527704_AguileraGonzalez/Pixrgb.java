package lab3_19527704_AguileraGonzalez;

public class Pixrgb extends Pixel {
    
    int[] rgbColor;

    public Pixrgb() {
        this.rgbColor = new int[3];
    }

    public Pixrgb(int posX, int posY, int[] rgbColor, int depth) {
        super(posX, posY, depth);
        if (rgbColor[0] >= 0 && rgbColor[0] <= 255 &&
            rgbColor[1] >= 0 && rgbColor[1] <= 255 &&
            rgbColor[2] >= 0 && rgbColor[2] <= 255 ) {
            this.rgbColor = rgbColor;
        }
    }

    public int[] getRgbColor() {
        return rgbColor;
    }
    
    public int getRColor() {
        return rgbColor[0];
    }
    
    public void setRColor(int redColor) {
        if (redColor >= 0 && redColor <= 255) {
            rgbColor[0] = redColor;
        }
    }
    
    public int getGColor() {
        return rgbColor[1];
    }
    
    public void setGColor(int greenColor) {
        if (greenColor >= 0 && greenColor <= 255) {
            rgbColor[1] = greenColor;
        }
    }
    
    public int getBColor() {
        return rgbColor[2];
    }
    
    public void setBColor(int blueColor) {
        if (blueColor >= 0 && blueColor <= 255) {
            rgbColor[2] = blueColor;
        }
    }
    
    public String rgbToHex() {
        return String.format("#%02X%02X%02X", rgbColor[0], rgbColor[1], rgbColor[2]);
    }
    
}
