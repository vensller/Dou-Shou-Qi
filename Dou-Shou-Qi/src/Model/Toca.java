package Model;

import Model.ObjetoJogo;
import Model.Peca;

/**
 *
 * @author Ivens
 */
public class Toca extends ObjetoJogo implements Peca{

    public Toca(String imagem, int jogador, int linha, int coluna) {
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
