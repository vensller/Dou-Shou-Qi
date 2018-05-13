package Controller;

import Model.ObjetoJogo;
import Model.ObjetoTabuleiro;

/**
 *
 * @author Ivens
 */
public class AndarUmaCasaParaEsquerda implements Command{

    @Override
    public void execute(ObjetoTabuleiro[][] objetosTabuleiro, ObjetoJogo animal) {
        objetosTabuleiro[animal.getColuna()][animal.getLinha()] = null;
        objetosTabuleiro[animal.getColuna() - 1][animal.getLinha()] = (ObjetoTabuleiro)animal;
        animal.setColuna(animal.getColuna() - 1);
    } 
    
}
