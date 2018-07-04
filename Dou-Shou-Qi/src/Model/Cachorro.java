package Model;

import Model.Animal;
import java.util.List;

/**
 *
 * @author Ivens
 */
public class Cachorro extends Animal{

    public Cachorro(String imagem, int linha, int coluna) {
        super(imagem, linha, coluna);
    }
    
    @Override
    public int getForca() {
        return 3;
    }

   @Override
    public boolean verificaSePodeMoverParaPosicao(Posicao posicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
