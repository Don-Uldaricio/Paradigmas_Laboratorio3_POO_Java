package lab3dos;

import java.util.ArrayList;

public class BitHistogram extends Histogram {

    ArrayList<Integer> bitColorList;

    public BitHistogram() {
    }

    public BitHistogram(ArrayList<Integer> bitColorList, ArrayList<Integer> freqList) {
        super(freqList);
        this.bitColorList = bitColorList;
    }

    public int getMaxBitColor() {
        int posMax = 0;
        for (int i = 0; i < freqList.size(); i++) {
            if (freqList.get(i) > freqList.get(posMax)) {
                posMax = i;
            }
        }
        return bitColorList.get(posMax);
    }
    
}
