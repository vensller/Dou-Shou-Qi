package Model;

import Model.Animal;
import Model.ObjetoJogo;

/**
 *
 * @author Ivens
 */
public class Leopardo extends ObjetoJogo implements Animal{

    public Leopardo(String imagem, int jogador, int linha, int coluna) {
        super(imagem, jogador, linha, coluna);
    }

    @Override
    public int getForca() {
        return 5;
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
