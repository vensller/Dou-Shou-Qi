package Model;

import Model.ObjetoTabuleiro;

/**
 *
 * @author Ivens
 */
public class Lago implements ObjetoTabuleiro{

    private String imagem;
    
    public Lago(String imagem){
        this.imagem = imagem;
    }
    
    @Override
    public String getImagem() {
        return this.imagem;
    }
    
    @Override
    public int getForca(){
        return 0;
    }
   
}
