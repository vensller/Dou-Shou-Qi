package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeLago extends FabricaDeObjetoTabuleiro{

    @Override
    public Peca criaObjetoTabuleiro(int coluna, int linha) {
        return new Lago("Imagens/lago.png", linha, coluna);        
    }
    
}
