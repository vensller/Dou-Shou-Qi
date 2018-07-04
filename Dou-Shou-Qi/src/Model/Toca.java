package Model;

import Model.Peca;

/**
 *
 * @author Ivens
 */
public class Toca extends Peca {

    public Toca(String imagem, int linha, int coluna) {
        super(imagem, linha, coluna);
    }
        
    @Override
    public int getForca(){
        return 0;
    }

}
