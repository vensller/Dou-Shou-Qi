package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivens
 */
public abstract class Animal extends Peca{

    protected List<Posicao> posicoesPossiveis;
    protected List<Posicao> lagos;
    protected Peca[][] objetosTabuleiro;

    public Animal(String imagem, int linha, int coluna) {
        super(imagem, linha, coluna);
        this.posicoesPossiveis = new ArrayList();
        this.objetosTabuleiro  = null;
        this.lagos = null;
    }

    public void setObjetosTabuleiro(Peca[][] objetosTabuleiro) {
        this.objetosTabuleiro = objetosTabuleiro;
    }   
    
    @Override
    public abstract int getForca(); 
    
    @Override
    public void accept(VisitorAtaque visitor){
        visitor.visit(this);
    }
    
    public boolean verificaSePodeMoverParaPosicao(Posicao posicao){
        for (Posicao p : posicoesPossiveis){
            if (p.getX() == posicao.getX() && p.getY() == posicao.getY()){
                return true;
            }
        }        
        
        return false;
    }
    
    public void verificarPosicoesPossiveis(){
        posicoesPossiveis.clear();
        
        DefinirPosicoesPeca definirPosicoes;
        
        if (objetosTabuleiro.length == 7){
            definirPosicoes = new DefinirPosicoesPossiveisVertical(objetosTabuleiro);
        } else definirPosicoes = new DefinirPosicoesPossiveisHorizontal(objetosTabuleiro);
        
        posicoesPossiveis = definirPosicoes.verificarPosicoesPossiveis(linha, coluna);
        
        VisitorAtacanteAnimal visitor = new VisitorAtacanteAnimal(this);
        definirPosicoes.accept(visitor);
        posicoesPossiveis.addAll(visitor.getListaPosicoes());
    }   
    
}
