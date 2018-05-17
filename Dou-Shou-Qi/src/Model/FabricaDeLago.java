package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeLago extends FabricaDeObjetoTabuleiro{

    @Override
    public ObjetoTabuleiro criaObjetoTabuleiro() {
        return new Lago("Imagens/lago.png");        
    }
    
}
