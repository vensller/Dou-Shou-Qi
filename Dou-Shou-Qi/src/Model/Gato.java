package Model;

import Model.Animal;

/**
 *
 * @author Ivens
 */
public class Gato extends Animal{

    public Gato(String imagem, int linha, int coluna) {
        super(imagem, linha, coluna);
    }

    @Override
    public int getForca() {
        return 2;
    }
    
}
