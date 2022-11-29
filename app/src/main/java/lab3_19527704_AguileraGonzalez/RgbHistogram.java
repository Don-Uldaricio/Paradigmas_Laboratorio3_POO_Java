package lab3_19527704_AguileraGonzalez;

import java.util.ArrayList;

/**
 * Representa el histograma de una imagen tipo Pixmap
 * @author Nicolás Aguilera González
 */
public class RgbHistogram extends Histogram {
    
    ArrayList<int[]> rgbColorList;

    /**
     * Crea una instancia de la clase RgbHistogram
     * @param rgbColorList Lista de colores RGB que se encuentran en una imagen
     * @param freqList Lista de enteros que representan frecuencias
     */
    public RgbHistogram(ArrayList<int[]> rgbColorList, ArrayList<Integer> freqList) {
        super(freqList);
        this.rgbColorList = rgbColorList;
    }
    
    /**
     * Entrega el color más frecuente del histograma
     * @return Arreglo de 3 enteros que contiene el color RGB
     */
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

