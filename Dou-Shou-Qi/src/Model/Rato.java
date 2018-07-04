package Model;

import Model.Animal;

/**
 *
 * @author Ivens
 */
public class Rato extends Animal{    
    
    private boolean estaNoLago;

    public Rato(String imagem, int linha, int coluna) {
        super(imagem, linha, coluna);        
        estaNoLago = false;
    }

    @Override
    public int getForca() {
        return 1;
    }
   
    public boolean isEstaNoLago() {
        return estaNoLago;
    }

    public void setEstaNoLago(boolean estaNoLago) {
        this.estaNoLago = estaNoLago;
    }  
    
    @Override
    public void verificarPosicoesPossiveis(){
        posicoesPossiveis.clear();
        
        DefinirPosicoesPeca definirPosicoes;
        
        if (objetosTabuleiro.length == 7){
            definirPosicoes = new DefinirPosicoesPossiveisVertical(objetosTabuleiro);
        } else definirPosicoes = new DefinirPosicoesPossiveisHorizontal(objetosTabuleiro);
        
        DefinirPosicoesPecaEntraLago definirPosicoesRato = new DefinirPosicoesPecaEntraLago(definirPosicoes);
        
        posicoesPossiveis = definirPosicoesRato.verificarPosicoesPossiveis(linha, coluna);
        VisitorAtacanteRato visitor = new VisitorAtacanteRato(this);
        definirPosicoesRato.accept(visitor);
        posicoesPossiveis.addAll(visitor.getListaPosicoes());
    }
   
}
