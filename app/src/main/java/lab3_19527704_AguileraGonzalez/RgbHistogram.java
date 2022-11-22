package lab3_19527704_AguileraGonzalez;

import java.util.ArrayList;

public class RgbHistogram extends Histogram {
    
    ArrayList<int[]> rgbColorList;

    public RgbHistogram() {
    }

    public RgbHistogram(ArrayList<int[]> rgbColorList, ArrayList<Integer> freqList) {
        super(freqList);
        this.rgbColorList = rgbColorList;
    }
    
    public int[] getMaxRgbColor() {
        int posMax = 0;
        for (int i = 0; i < freqList.size(); i++) {
            if (freqList.get(i) > freqList.get(posMax)) {
                posMax = i;
            }
        }
        return rgbColorList.get(posMax);
    }
    
}

