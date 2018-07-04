package Model;


/**
 *
 * @author Ivens
 */
public class Lago extends Peca{

    public Lago(String imagem, int linha, int coluna) {
        super(imagem, linha, coluna);
    } 
            
    @Override
    public int getForca(){
        return 0;
    }
      
}
