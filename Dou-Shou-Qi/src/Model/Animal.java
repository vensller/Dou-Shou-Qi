package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivens
 */
public abstract class Animal extends ObjetoJogo implements Peca{

    protected List<Posicao> posicoesPossiveis;
    protected ObjetoTabuleiro[][] objetosTabuleiro;

    public Animal(String imagem, int jogador, int linha, int coluna) {
        super(imagem, jogador, linha, coluna);
        this.posicoesPossiveis = new ArrayList();
        this.objetosTabuleiro  = null;
    }

    public void setObjetosTabuleiro(ObjetoTabuleiro[][] objetosTabuleiro) {
        this.objetosTabuleiro = objetosTabuleiro;
    }   
    
    public abstract int getForca(); 
    
    public abstract boolean verificaSePodeMoverParaPosicao(Posicao posicao);
    
    public abstract void verificarPosicoesPossiveis();
}
