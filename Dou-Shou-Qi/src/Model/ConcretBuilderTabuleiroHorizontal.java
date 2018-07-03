package Model;

/**
 *
 * @author Ivens
 */
public class ConcretBuilderTabuleiroHorizontal extends BuilderObjetoTabuleiro{

    @Override
    public void criaLagos(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeLago fabrica) {
        objetosTabuleiro[3][1] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[3][2] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[3][4] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[3][5] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[4][1] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[4][2] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[4][4] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[4][5] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[5][1] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[5][2] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[5][4] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[5][5] = fabrica.criaObjetoTabuleiro();
    }
    
}
