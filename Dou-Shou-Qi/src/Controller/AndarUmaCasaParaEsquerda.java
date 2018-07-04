package Controller;

import Model.Peca;


/**
 *
 * @author Ivens
 */
public class AndarUmaCasaParaEsquerda implements Command{

    @Override
    public void execute(Peca[][] objetosTabuleiro, Peca animal, Peca padrao) {
        objetosTabuleiro[animal.getColuna()][animal.getLinha()] = padrao;
        objetosTabuleiro[animal.getColuna() - 1][animal.getLinha()] = (Peca)animal;
        animal.setColuna(animal.getColuna() - 1);
    } 
    
}
