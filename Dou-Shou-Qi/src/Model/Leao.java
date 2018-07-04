package Model;

import Model.Animal;

/**
 *
 * @author Ivens
 */
public class Leao extends Animal{

    public Leao(String imagem, int linha, int coluna) {
        super(imagem, linha, coluna);        
    }

    @Override
    public int getForca() {
        return 7;
    }
    
    @Override
    public void verificarPosicoesPossiveis(){
        posicoesPossiveis.clear();
        
        DefinirPosicoesPeca definirPosicoes;
        
        if (objetosTabuleiro.length == 7){
            definirPosicoes = new DefinirPosicoesPossiveisVertical(objetosTabuleiro);
        } else definirPosicoes = new DefinirPosicoesPossiveisHorizontal(objetosTabuleiro);
        
        DefinirPosicoesPecaPulaLago definirPosicoesLeao = new DefinirPosicoesPecaPulaLago(definirPosicoes);
        
        this.lagos = definirPosicoes.getLagos();
        
        posicoesPossiveis = definirPosicoesLeao.verificarPosicoesPossiveis(linha, coluna);
        VisitorAtacanteAnimal visitor = new VisitorAtacanteAnimal(this);
        definirPosicoesLeao.accept(visitor);
        posicoesPossiveis.addAll(visitor.getListaPosicoes());
    }
 
}
