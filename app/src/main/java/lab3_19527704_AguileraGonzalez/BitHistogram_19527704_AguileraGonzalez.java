package lab3_19527704_AguileraGonzalez;

import java.util.ArrayList;

/**
 * Representa un histograma para imágenes de tipo Bitmap con color tipo bit
 * y hereda características de la clase Histogram
 * @author Nicolás Aguilera González
 */
public class BitHistogram_19527704_AguileraGonzalez extends Histogram_19527704_AguileraGonzalez {

    private ArrayList<Integer> bitColorList;
    
    /**
     * Crea una instancia de la clase BitHistogram
     * @param bitColorList
     * @param freqList 
     */
    public BitHistogram_19527704_AguileraGonzalez(ArrayList<Integer> bitColorList, ArrayList<Integer> freqList) {
        super(freqList);
        this.bitColorList = bitColorList;
    }

    /**
     * Entrega el color más frecuente del histograma tipo bit
     * @return Entero que representa el color en bit
     */
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

