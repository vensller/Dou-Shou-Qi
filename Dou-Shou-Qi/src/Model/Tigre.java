package Model;

import Model.Animal;

/**
 *
 * @author Ivens
 */
public class Tigre extends Animal{
    
    public Tigre(String imagem, int linha, int coluna) {
        super(imagem, linha, coluna);        
    }

    @Override
    public int getForca() {
        return 6;
    }
    
    @Override
    public void verificarPosicoesPossiveis(){
        posicoesPossiveis.clear();
        
        DefinirPosicoesPeca definirPosicoes;
        
        if (objetosTabuleiro.length == 7){
            definirPosicoes = new DefinirPosicoesPossiveisVertical(objetosTabuleiro);
        } else definirPosicoes = new DefinirPosicoesPossiveisHorizontal(objetosTabuleiro);
        
        DefinirPosicoesPecaPulaLago definirPosicoesTigre = new DefinirPosicoesPecaPulaLago(definirPosicoes);
        
        posicoesPossiveis = definirPosicoesTigre.verificarPosicoesPossiveis(linha, coluna);
        VisitorAtacanteAnimal visitor = new VisitorAtacanteAnimal(this);
        definirPosicoesTigre.accept(visitor);
        posicoesPossiveis.addAll(visitor.getListaPosicoes());
    }
    
}
