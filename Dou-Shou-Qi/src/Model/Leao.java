package Model;

import Model.Animal;

/**
 *
 * @author Ivens
 */
public class Leao extends Animal{

    public Leao(String imagem, int linha, int coluna) {
        super(imagem, linha, coluna);        
    }

    @Override
    public int getForca() {
        return 7;
    }
        
    @Override
    public boolean verificaSePodeMoverParaPosicao(Posicao posicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
