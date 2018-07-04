package Model;

import java.util.List;

/**
 *
 * @author Ivens
 */
public abstract class DefinirPosicoesPecaDecorator implements DefinirPosicoesPeca{
    
    protected DefinirPosicoesPeca definirPosicoesPeca;
    
    public DefinirPosicoesPecaDecorator(DefinirPosicoesPeca definirPosicoes){
        this.definirPosicoesPeca = definirPosicoes;
    }

    @Override
    public List<Posicao> verificarPosicoesPossiveis(int linha, int coluna){
        return this.definirPosicoesPeca.verificarPosicoesPossiveis(linha, coluna);
    }

    @Override
    public boolean posicaoEhLago(int linha, int coluna){
        return this.posicaoEhLago(linha, coluna);
    }

    @Override
    public int getColunaMax() {
        return this.definirPosicoesPeca.getColunaMax();
    }

    @Override
    public int getColunaMin() {
        return this.definirPosicoesPeca.getColunaMin();
    }

    @Override
    public int getLinhaMax() {
        return this.definirPosicoesPeca.getLinhaMax();
    }

    @Override
    public int getLinhaMin() {
        return this.definirPosicoesPeca.getLinhaMin();
    }
    
    @Override
    public Peca[][] getObjetosTabuleiro(){
        return this.definirPosicoesPeca.getObjetosTabuleiro();
    }

    @Override
    public void accept(VisitorAtaque visitor) {
        this.definirPosicoesPeca.accept(visitor);
    }

    @Override
    public List<Peca> getObjetosVerificar() {
        return this.definirPosicoesPeca.getObjetosVerificar();
    }
    
}
