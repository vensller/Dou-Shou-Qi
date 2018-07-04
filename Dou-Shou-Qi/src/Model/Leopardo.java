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
      
    @Override
    public boolean verificaSePodeMoverParaPosicao(Posicao posicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
