package Controller;

import Model.ObjetoJogo;
import Model.ObjetoTabuleiro;

/**
 *
 * @author Ivens
 */
public class AndarUmaCasaParaCima implements Command{

    @Override
    public void execute(ObjetoTabuleiro[][] objetosTabuleiro, ObjetoJogo animal, ObjetoTabuleiro padrao) {
        objetosTabuleiro[animal.getColuna()][animal.getLinha()] = padrao;
        objetosTabuleiro[animal.getColuna()][animal.getLinha() - 1] = (ObjetoTabuleiro)animal;
        animal.setLinha(animal.getLinha() - 1);
    }

    
}
