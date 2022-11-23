package lab3dos;

import java.util.ArrayList;

public class Histogram {
    
    ArrayList<Integer> freqList;

    public Histogram() {
    }

    public Histogram(ArrayList<Integer> freqList) {
        this.freqList = freqList;
    }

    public ArrayList<Integer> getFreqList() {
        return freqList;
    }

    public void setFreqList(ArrayList<Integer> freqList) {
        this.freqList = freqList;
    }
    
}
