package Controller;

import Model.ObjetoJogo;
import Model.ObjetoTabuleiro;

/**
 *
 * @author Ivens
 */
public class PularLagoParaBaixo implements Command{

    @Override
    public void execute(ObjetoTabuleiro[][] objetosTabuleiro, ObjetoJogo animal, ObjetoTabuleiro padrao) {
        objetosTabuleiro[animal.getColuna()][animal.getLinha()] = padrao;
        objetosTabuleiro[animal.getColuna()][animal.getLinha() + 4] = (ObjetoTabuleiro)animal;
        animal.setLinha(animal.getLinha() + 4);
    }
    
}
