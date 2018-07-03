package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivens
 */
public abstract class Animal extends ObjetoJogo implements Peca{

    protected List<Posicao> posicoesPossiveis;
    protected List<Posicao> lagos;
    protected ObjetoTabuleiro[][] objetosTabuleiro;

    public Animal(String imagem, int jogador, int linha, int coluna) {
        super(imagem, jogador, linha, coluna);
        this.posicoesPossiveis = new ArrayList();
        this.objetosTabuleiro  = null;
        this.lagos = null;
    }

    public void setObjetosTabuleiro(ObjetoTabuleiro[][] objetosTabuleiro) {
        this.objetosTabuleiro = objetosTabuleiro;
    }   
    
    @Override
    public abstract int getForca(); 
    
    public abstract boolean verificaSePodeMoverParaPosicao(Posicao posicao);
    
    public void verificarPosicoesPossiveis(){
        posicoesPossiveis.clear();
        
        DefinirPosicoesPeca definirPosicoes;
        
        if (objetosTabuleiro.length == 7){
            definirPosicoes = new DefinirPosicoesPossiveisVertical(objetosTabuleiro);
        } else definirPosicoes = new DefinirPosicoesPossiveisHorizontal(objetosTabuleiro);
        
        posicoesPossiveis = definirPosicoes.verificarPosicoesPossiveis(linha, coluna, getForca());
        
    }   
    
}
