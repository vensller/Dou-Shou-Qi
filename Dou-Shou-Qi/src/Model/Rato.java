package Model;

import Model.Animal;
import Model.ObjetoJogo;

/**
 *
 * @author Ivens
 */
public class Rato extends ObjetoJogo implements Animal{    
    
    private boolean estaNoLago;

    public Rato(String imagem, int jogador, int linha, int coluna) {
        super(imagem, jogador, linha, coluna);        
        estaNoLago = false;
    }

    @Override
    public int getForca() {
        return 1;
    }

    @Override
    public String getImagem() {
        return this.imagem;
    }

    @Override
    public int getJogador() {
        return this.jogador;
    }  

    public boolean isEstaNoLago() {
        return estaNoLago;
    }

    public void setEstaNoLago(boolean estaNoLago) {
        this.estaNoLago = estaNoLago;
    }   
}
