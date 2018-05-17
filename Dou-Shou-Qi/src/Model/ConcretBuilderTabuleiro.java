package Model;

/**
 *
 * @author Ivens
 */
public class ConcretBuilderTabuleiro extends BuilderObjetoTabuleiro{

    @Override
    public void criaLagos(ObjetoTabuleiro[][] objetosTabuleiro, FabricaDeLago fabrica) {
        objetosTabuleiro[1][3] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[2][3] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[4][3] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[5][3] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[1][4] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[2][4] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[4][4] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[5][4] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[1][5] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[2][5] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[4][5] = fabrica.criaObjetoTabuleiro();
        objetosTabuleiro[5][5] = fabrica.criaObjetoTabuleiro();
    }
    
}
