package lab3_19527704_AguileraGonzalez;

public class Pixel {
    
    int posX;
    int posY;
    int depth;

    public Pixel(int posX, int posY, int depth) {
        this.posX = posX;
        this.posY = posY;
        this.depth = depth;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
    
}
