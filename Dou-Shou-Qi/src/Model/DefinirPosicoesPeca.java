package Model;

import java.util.List;

/**
 *
 * @author Ivens
 */
public interface DefinirPosicoesPeca {
    
    List<Posicao> verificarPosicoesPossiveis(int linha, int coluna);
    boolean posicaoEhLago(int linha, int coluna);
    int getColunaMax();
    int getColunaMin();
    int getLinhaMax();
    int getLinhaMin();
    Peca[][] getObjetosTabuleiro();
    List<Peca> getObjetosVerificar();
    void accept(VisitorAtaque visitor);
    
}
