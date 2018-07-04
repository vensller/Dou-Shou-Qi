package Controller;

import Model.Peca;

/**
 *
 * @author Ivens
 */
public class AndarUmaCasaParaBaixo implements Command{  

    @Override
    public void execute(Peca[][] objetosTabuleiro, Peca animal, Peca padrao) {
        objetosTabuleiro[animal.getColuna()][animal.getLinha()] = padrao;
        objetosTabuleiro[animal.getColuna()][animal.getLinha() + 1] = (Peca)animal;
        animal.setLinha(animal.getLinha() + 1);
    }
    
}
