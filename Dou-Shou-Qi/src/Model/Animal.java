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
    private Jogador jogador;

    public Animal(String imagem, int linha, int coluna) {
        super(imagem, linha, coluna);
        this.posicoesPossiveis = new ArrayList();
        this.objetosTabuleiro  = null;
        this.lagos = null;
        this.estaNaArmadilha = false;
        this.jogador = null;
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
        
        this.lagos = definirPosicoes.getLagos();
        
        posicoesPossiveis = definirPosicoes.verificarPosicoesPossiveis(linha, coluna);
        
        VisitorAtacanteAnimal visitor = new VisitorAtacanteAnimal(this);
        definirPosicoes.accept(visitor);
        posicoesPossiveis.addAll(visitor.getListaPosicoes());
    }   

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }    
    
    public boolean verificaSePosicaoELago(Posicao posicao){
        if (lagos != null){
            for (Posicao p : lagos){
                if (p.getX() == posicao.getX() && p.getY() == posicao.getY()){
                    return true;
                }
            }
        }
        return false;
    }
    
    public void verificarImagem(){
        setImagem(getImagemOriginal() + ".png");
        
        if (estaNaArmadilha){
            setImagem(getImagemNaArmadilha());
        }
        
    }
    
}
