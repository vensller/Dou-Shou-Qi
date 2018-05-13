package Model;

import Model.ObjetoJogo;
import Model.Peca;

/**
 *
 * @author Ivens
 */
public class Armadilha extends ObjetoJogo implements Peca{

    public Armadilha(String imagem, int jogador, int linha, int coluna) {
        super(imagem, jogador, linha, coluna);
    }

    @Override
    public String getImagem() {
        return this.imagem;
    }
    
    @Override
    public int getJogador(){
        return this.jogador;
    }
    
}
