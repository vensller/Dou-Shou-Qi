package Model;

import Model.Animal;

/**
 *
 * @author Ivens
 */
public class Tigre extends Animal{
    
    public Tigre(String imagem, int linha, int coluna) {
        super(imagem, linha, coluna);        
    }

    @Override
    public int getForca() {
        return 6;
    }

    @Override
    public boolean verificaSePodeMoverParaPosicao(Posicao posicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
