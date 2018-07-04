package Model;

import java.util.List;

/**
 *
 * @author Ivens
 */
public interface DefinirPosicoesPeca {
    
    List<Posicao> verificarPosicoesPossiveis(int linha, int coluna, Animal animal);
    boolean posicaoEhLago(int linha, int coluna);
    
}
