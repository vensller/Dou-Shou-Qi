package Model;

import Model.Animal;

/**
 *
 * @author Ivens
 */
public class Rato extends Animal{    
    
    private boolean estaNoLago;

    public Rato(String imagem, int linha, int coluna) {
        super(imagem, linha, coluna);        
        estaNoLago = false;
    }

    @Override
    public int getForca() {
        return 1;
    }
   
    public boolean isEstaNoLago() {
        return estaNoLago;
    }

    public void setEstaNoLago(boolean estaNoLago) {
        this.estaNoLago = estaNoLago;
    }   

    @Override
    public boolean verificaSePodeMoverParaPosicao(Posicao posicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
