package Model;

import java.util.List;

/**
 *
 * @author Ivens
 */
public class DefinirPosicoesPecaPulaLagoHorizontal extends DefinirPosicoesPecaDecorator{
    
    List<Posicao> posicoes;
    
    public DefinirPosicoesPecaPulaLagoHorizontal(DefinirPosicoesPeca definirPosicoes) {
        super(definirPosicoes);
    }
    
    @Override
    public List<Posicao> verificarPosicoesPossiveis(int linha, int coluna){
        posicoes = super.verificarPosicoesPossiveis(linha, coluna);

        verificaPularLagoAcima(linha, coluna);
        verificaPularLagoAbaixo(linha, coluna);
        verificaPularLagoEsquerda(linha, coluna);
        verificaPularLagoDireita(linha, coluna);
        
        return posicoes;
    }    

    private void verificaPularLagoAcima(int linha, int coluna){         
        if (posicaoEhLago(linha - 1, coluna)){
            if (verificaSePodePularLagoParaCima(coluna, linha)) posicoes.add(new Posicao(coluna, linha - 3));
        }
    }
    
    private void verificaPularLagoAbaixo(int linha, int coluna){
        if (posicaoEhLago(linha + 1, coluna)){
            if (verificaSePodePularLagoParaBaixo(coluna, linha)) posicoes.add(new Posicao(coluna, linha + 3));
        }
    }
    
    private void verificaPularLagoEsquerda(int linha, int coluna){
        if (posicaoEhLago(linha, coluna - 1)){
            if (verificaSePodePularLagoParaEsquerda(coluna, linha)) posicoes.add(new Posicao(coluna - 4, linha));
        }
    }
    
    private void verificaPularLagoDireita(int linha, int coluna){
        if (posicaoEhLago(linha, coluna + 1)){
            if (verificaSePodePularLagoParaDireita(coluna, linha)) posicoes.add(new Posicao(coluna + 4, linha));
        }
    }    
    
    private boolean verificaSePodePularLagoParaEsquerda(int coluna, int linha){
        for (int i = -3; i < 0; i++){
            if (!(definirPosicoesPeca.getObjetosTabuleiro()[coluna + i][linha].getForca() == 0)){
                return false;
            }
        }
        return true;
    }
    
    private boolean verificaSePodePularLagoParaDireita(int coluna, int linha){
        for (int i = 1; i <= 3; i++){
            if (!(definirPosicoesPeca.getObjetosTabuleiro()[coluna + i][linha].getForca() == 0)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean verificaSePodePularLagoParaCima(int coluna, int linha){
        for (int i = -2; i < 0; i++){
            if (!(definirPosicoesPeca.getObjetosTabuleiro()[coluna][linha + i].getForca() == 0)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean verificaSePodePularLagoParaBaixo(int coluna, int linha){
        for (int i = 1; i <= 2; i++){
            if (!(definirPosicoesPeca.getObjetosTabuleiro()[coluna][linha + i].getForca() == 0)){
                return false;
            }
        }
        
        return true;
    }
    
}
