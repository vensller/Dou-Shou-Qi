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
        DefinirPosicoesPeca definirPosicoesTigre;
        
        if (objetosTabuleiro.length == 7){
            definirPosicoes = new DefinirPosicoesPossiveisVertical(objetosTabuleiro);
            definirPosicoesTigre = new DefinirPosicoesPecaPulaLago(definirPosicoes);
        } else {
            definirPosicoes = new DefinirPosicoesPossiveisHorizontal(objetosTabuleiro);
            definirPosicoesTigre = new DefinirPosicoesPecaPulaLagoHorizontal(definirPosicoes);
        }        
        
        this.lagos = definirPosicoes.getLagos();
        
        posicoesPossiveis = definirPosicoesTigre.verificarPosicoesPossiveis(linha, coluna);
        VisitorAtacanteAnimal visitor = new VisitorAtacanteAnimal(this);
        definirPosicoesTigre.accept(visitor);
        posicoesPossiveis.addAll(visitor.getListaPosicoes());
    }
    
}
