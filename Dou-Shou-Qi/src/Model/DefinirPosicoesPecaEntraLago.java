package Model;

import java.util.List;

/**
 *
 * @author Ivens
 */
public class DefinirPosicoesPecaEntraLago extends DefinirPosicoesPecaDecorator{
    
    List<Posicao> posicoes;
    
    public DefinirPosicoesPecaEntraLago(DefinirPosicoesPeca definirPosicoes) {
        super(definirPosicoes);
    }    
    
    @Override
    public List<Posicao> verificarPosicoesPossiveis(int linha, int coluna){
        posicoes = super.verificarPosicoesPossiveis(linha, coluna);
           
        verificaLagoAcima(linha, coluna);
        verificaLagoAbaixo(linha, coluna);
        verificaLagoEsquerda(linha, coluna);
        verificaLagoDireita(linha, coluna);       
        
        return posicoes;
    }    
    
    private void verificaLagoAcima(int linha, int coluna){         
        if (posicaoEhLago(linha - 1, coluna)){
            if (definirPosicoesPeca.getObjetosTabuleiro()[coluna][linha - 1].getForca() > 0){
                this.definirPosicoesPeca.getObjetosVerificar().add(definirPosicoesPeca.getObjetosTabuleiro()[coluna][linha - 1]);
            }else posicoes.add(new Posicao(coluna, linha - 1));
        }
    }
    
    private void verificaLagoAbaixo(int linha, int coluna){
        if (posicaoEhLago(linha + 1, coluna)){
            if (definirPosicoesPeca.getObjetosTabuleiro()[coluna][linha + 1].getForca() > 0){
                this.definirPosicoesPeca.getObjetosVerificar().add(definirPosicoesPeca.getObjetosTabuleiro()[linha + 1][coluna]);
            }else posicoes.add(new Posicao(coluna, linha + 1));
        }
    }
    
    private void verificaLagoEsquerda(int linha, int coluna){
        if (posicaoEhLago(linha, coluna - 1)){
            if (definirPosicoesPeca.getObjetosTabuleiro()[coluna - 1][linha].getForca() > 0){
                this.definirPosicoesPeca.getObjetosVerificar().add(definirPosicoesPeca.getObjetosTabuleiro()[coluna - 1][linha]);
            }else posicoes.add(new Posicao(coluna - 1, linha));
        }
    }
    
    private void verificaLagoDireita(int linha, int coluna){
        if (posicaoEhLago(linha, coluna + 1)){
            if (definirPosicoesPeca.getObjetosTabuleiro()[coluna + 1][linha].getForca() > 0){
                this.definirPosicoesPeca.getObjetosVerificar().add(definirPosicoesPeca.getObjetosTabuleiro()[coluna + 1][linha]);
            }else posicoes.add(new Posicao(coluna + 1, linha));
        }
    }    
}
