package lab3dos;

import java.util.ArrayList;

public class HexHistogram extends Histogram {
    
    ArrayList<String> hexColorList;

    public HexHistogram() {
    }

    public HexHistogram(ArrayList<String> hexColorList, ArrayList<Integer> freqList) {
        super(freqList);
        this.hexColorList = hexColorList;
    }
    
    public String getMaxHexColor() {
        int posMax = 0;
        for (int i = 0; i < freqList.size(); i++) {
            if (freqList.get(i) > freqList.get(posMax)) {
                posMax = i;
            }
        }
        return hexColorList.get(posMax);
    }
    
}
