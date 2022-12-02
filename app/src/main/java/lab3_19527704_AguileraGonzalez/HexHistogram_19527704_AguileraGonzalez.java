package lab3_19527704_AguileraGonzalez;

import java.util.ArrayList;

/**
 * Representa un histograma para una imagen tipo Hexmap
 * @author Nicolás Aguilera González
 */
public class HexHistogram_19527704_AguileraGonzalez extends Histogram_19527704_AguileraGonzalez {
    
    private ArrayList<String> hexColorList;

    /**
     * Crea una instancia para la clase HexHistogram
     * @param hexColorList Lista de String que representan 
     * los colores de una imagen
     * @param freqList Lista de entero que representa frecuencias
     */
    public HexHistogram_19527704_AguileraGonzalez(ArrayList<String> hexColorList, ArrayList<Integer> freqList) {
        super(freqList);
        this.hexColorList = hexColorList;
    }
    
    /**
     * Entrega el color más frecuente del histograma
     * @return String representa color hexadecimal
     */
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
