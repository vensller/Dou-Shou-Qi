package Model;

import java.util.List;

/**
 *
 * @author Ivens
 */
public interface DefinirPosicoesPeca {
    
    List<Posicao> verificarPosicoesPossiveis(int linha, int coluna, int forca);
    boolean posicaoEhLago(int linha, int coluna);
    
}
