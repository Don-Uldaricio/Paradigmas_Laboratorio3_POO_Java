package lab3_19527704_AguileraGonzalez;

public class Pixrgb extends Pixel {
    
    int[] rgbColor;

    public Pixrgb(int posX, int posY, int R, int G, int B, int depth) {
        super(posX, posY, depth);
        this.rgbColor = new int[3];
        this.rgbColor[0] = R;
        this.rgbColor[1] = G;
        this.rgbColor[2] = B;
    }

    public int[] getRgbColor() {
        return rgbColor;
    }

    public void setRgbColor(int[] rgbColor) {
        this.rgbColor = rgbColor;
    }
    
    public int getRColor() {
        return rgbColor[0];
    }
    
    public void setRColor(int redColor) {
        this.rgbColor[0] = redColor;
    }
    
    public int getGColor() {
        return rgbColor[1];
    }
    
    public void setGColor(int greenColor) {
        this.rgbColor[1] = greenColor;
    }
    
    public int getBColor() {
        return rgbColor[2];
    }
    
    public void setBColor(int blueColor) {
        this.rgbColor[2] = blueColor;
    }
    
    public boolean isPixrgb() {
        return (rgbColor[0] >= 0 && rgbColor[0] <= 255 &&
                rgbColor[1] >= 0 && rgbColor[1] <= 255 &&
                rgbColor[2] >= 0 && rgbColor[2] <= 255);
    }
    
    public String rgbToHex() {
        return String.format("#%02X%02X%02X", rgbColor[0], rgbColor[1], rgbColor[2]);
    }
    
}

