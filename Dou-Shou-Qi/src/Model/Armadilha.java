package Model;

import Model.Peca;

/**
 *
 * @author Ivens
 */
public class Armadilha extends Peca{

    public Armadilha(String imagem, int linha, int coluna) {
        super(imagem, linha, coluna);
    }

    @Override
    public String getImagem() {
        return this.imagem;
    }
    
    @Override
    public void accept(VisitorAtaque visitor){
        visitor.visit(this);        
    }

    @Override
    public int getForca() {
        return 0;
    }
    
}
