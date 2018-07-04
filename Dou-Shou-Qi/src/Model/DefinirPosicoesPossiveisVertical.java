package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivens
 */
public class DefinirPosicoesPossiveisVertical implements DefinirPosicoesPeca{
    
    private List<Posicao> posicoes;
    private List<Peca> objetosVerificar;
    private List<Posicao> lagos;
    private Peca[][] objetosTabuleiro;

    public DefinirPosicoesPossiveisVertical(Peca[][] objetosTabuleiro) {
        this.objetosTabuleiro = objetosTabuleiro;
        this.lagos = new ArrayList<Posicao>();
        criaLagos();
    }   
    
    private void criaLagos(){
        lagos.add(new Posicao(1, 3));
        lagos.add(new Posicao(2, 3));
        lagos.add(new Posicao(4, 3));
        lagos.add(new Posicao(5, 3));
        lagos.add(new Posicao(1, 4));
        lagos.add(new Posicao(2, 4));
        lagos.add(new Posicao(4, 4));
        lagos.add(new Posicao(5, 4));
        lagos.add(new Posicao(1, 5));
        lagos.add(new Posicao(2, 5));
        lagos.add(new Posicao(4, 5));
        lagos.add(new Posicao(5, 5));
        
    }

    @Override
    public List<Posicao> verificarPosicoesPossiveis(int linha, int coluna, Animal animal) {
        posicoes = new ArrayList<Posicao>();
        objetosVerificar = new ArrayList<Peca>();
        verificaPosicaoAcima(linha, coluna);
        verificaPosicaoAbaixo(linha, coluna);
        verificaPosicaoEsquerda(linha, coluna);
        verificaPosicaoDireita(linha, coluna);
        return posicoes;
    }

    private void verificaPosicaoAcima(int linha, int coluna){
        if (linha - 1 >= 0){
            if (!posicaoEhLago(linha - 1, coluna)){
                if (objetosTabuleiro[coluna][linha - 1] == null){
                    posicoes.add(new Posicao(coluna, linha - 1));
                }else objetosVerificar.add(objetosTabuleiro[coluna][linha - 1]);
            }
        }
    }
    
    private void verificaPosicaoAbaixo(int linha, int coluna){
        if (linha + 1 <= 8){
            if (!posicaoEhLago(linha + 1, coluna)){
                if (objetosTabuleiro[coluna][linha + 1] == null){
                    posicoes.add(new Posicao(coluna, linha + 1));
                }else objetosVerificar.add(objetosTabuleiro[coluna][linha + 1]);
            }
        }
    }
    
    private void verificaPosicaoEsquerda(int linha, int coluna){
        if (coluna - 1 >= 0){
            if (!posicaoEhLago(linha, coluna - 1)){
                if (objetosTabuleiro[coluna - 1][linha] == null){
                    posicoes.add(new Posicao(coluna - 1, linha));
                }else objetosVerificar.add(objetosTabuleiro[coluna - 1][linha]);
            }  
        }
    }
    
    private void verificaPosicaoDireita(int linha, int coluna){
        if (coluna + 1 <= 6){
            if (!posicaoEhLago(linha, coluna + 1)){
                if (objetosTabuleiro[coluna + 1][linha] == null){
                    posicoes.add(new Posicao(coluna + 1, linha));
                }else objetosVerificar.add(objetosTabuleiro[coluna + 1][linha]);
            }
        }
    }

    @Override
    public boolean posicaoEhLago(int linha, int coluna){
        for (Posicao p : lagos){
            if (p.getX() == coluna && p.getY() == linha){
                return true;
            }
        }
        
        return false;
    }
}
