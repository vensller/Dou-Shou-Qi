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

    @Override
    public boolean verificaSePodeMoverParaPosicao(Posicao posicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
