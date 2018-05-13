package Model;

import Model.Animal;
import Model.ObjetoJogo;

/**
 *
 * @author Ivens
 */
public class Cachorro extends ObjetoJogo implements Animal{
    
    public Cachorro(String imagem, int jogador, int linha, int coluna) {
        super(imagem, jogador, linha, coluna);    
    }    

    @Override
    public int getForca() {
        return 4;
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
