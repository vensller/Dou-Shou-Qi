package Model;

import java.util.List;

/**
 *
 * @author Ivens
 */
public class DefinirPosicoesPecaPulaLago extends DefinirPosicoesPecaDecorator{
    
    List<Posicao> posicoes;
    
    public DefinirPosicoesPecaPulaLago(DefinirPosicoesPeca definirPosicoes) {
        super(definirPosicoes);
    }
    
    @Override
    public List<Posicao> verificarPosicoesPossiveis(int linha, int coluna){
        posicoes = super.verificarPosicoesPossiveis(linha, coluna);

        
        return posicoes;
    }    

}
