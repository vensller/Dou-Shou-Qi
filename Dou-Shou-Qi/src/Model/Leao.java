package Model;

import Model.Animal;

/**
 *
 * @author Ivens
 */
public class Leao extends Animal{

    public Leao(String imagem, int jogador, int linha, int coluna) {
        super(imagem, jogador, linha, coluna);        
    }

    @Override
    public int getForca() {
        return 7;
    }

    @Override
    public String getImagem() {
        return this.imagem;
    }
    
    @Override
    public int getJogador(){
        return this.jogador;
    }

    @Override
    public boolean verificaSePodeMoverParaPosicao(Posicao posicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void verificarPosicoesPossiveis() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
