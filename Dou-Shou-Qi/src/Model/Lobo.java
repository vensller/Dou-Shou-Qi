package Model;

import Model.Animal;

/**
 *
 * @author Ivens
 */
public class Lobo extends Animal{

    public Lobo(String imagem, int linha, int coluna) {
        super(imagem, linha, coluna);        
    }

    @Override
    public int getForca() {
        return 4;
    }

}
