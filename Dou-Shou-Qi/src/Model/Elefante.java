package Model;

import Model.Animal;
import java.util.List;

/**
 *
 * @author Ivens
 */
public class Elefante extends Animal{    

    public Elefante(String imagem, int jogador, int linha, int coluna) {
        super(imagem, jogador, linha, coluna);
    }
    
    @Override
    public int getForca() {
        return 8;
    }

    @Override
    public String getImagem() {
        return this.imagem;
    }
    
    @Override
    public int getJogador(){
        return this.jogador;
    }

    @Override
    public boolean verificaSePodeMoverParaPosicao(Posicao posicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
