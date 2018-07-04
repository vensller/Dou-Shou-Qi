package Model;

import Model.Animal;

/**
 *
 * @author Ivens
 */
public class Leopardo extends Animal{

    public Leopardo(String imagem, int linha, int coluna) {
        super(imagem, linha, coluna);
    }

    @Override
    public int getForca() {
        return 5;
    }  
    
}
