package Controller;

import Model.ObjetoJogo;
import Model.ObjetoTabuleiro;

/**
 *
 * @author Ivens
 */
public class AndarUmaCasaParaBaixo implements Command{  

    @Override
    public void execute(ObjetoTabuleiro[][] objetosTabuleiro, ObjetoJogo animal) {
        objetosTabuleiro[animal.getColuna()][animal.getLinha()] = null;
        objetosTabuleiro[animal.getColuna()][animal.getLinha() + 1] = (ObjetoTabuleiro)animal;
        animal.setLinha(animal.getLinha() + 1);
    }
    
}
