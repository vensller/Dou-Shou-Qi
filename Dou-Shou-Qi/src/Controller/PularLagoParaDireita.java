package Controller;

import Model.ObjetoJogo;
import Model.ObjetoTabuleiro;

/**
 *
 * @author Ivens
 */
public class PularLagoParaDireita implements Command{

    @Override
    public void execute(ObjetoTabuleiro[][] objetosTabuleiro, ObjetoJogo animal, ObjetoTabuleiro padrao) {
        objetosTabuleiro[animal.getColuna()][animal.getLinha()] = padrao;
        objetosTabuleiro[animal.getColuna() + 3][animal.getLinha()] = (ObjetoTabuleiro)animal;
        animal.setColuna(animal.getColuna() + 3);
    }
    
}
