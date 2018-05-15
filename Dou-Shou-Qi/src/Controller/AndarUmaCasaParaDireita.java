package Controller;

import Model.ObjetoJogo;
import Model.ObjetoTabuleiro;

/**
 *
 * @author Ivens
 */
public class AndarUmaCasaParaDireita implements Command{

    @Override
    public void execute(ObjetoTabuleiro[][] objetosTabuleiro, ObjetoJogo animal, ObjetoTabuleiro padrao) {
        objetosTabuleiro[animal.getColuna()][animal.getLinha()] = padrao;
        objetosTabuleiro[animal.getColuna() + 1][animal.getLinha()] = (ObjetoTabuleiro)animal;
        animal.setColuna(animal.getColuna() + 1);
    }
    
}
