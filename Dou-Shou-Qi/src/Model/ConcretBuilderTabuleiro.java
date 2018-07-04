package Model;

/**
 *
 * @author Ivens
 */
public class ConcretBuilderTabuleiro extends BuilderObjetoTabuleiro{

    @Override
    public void criaLagos(Peca[][] objetosTabuleiro, FabricaDeLago fabrica) {
        objetosTabuleiro[1][3] = fabrica.criaObjetoTabuleiro(1, 3);
        objetosTabuleiro[2][3] = fabrica.criaObjetoTabuleiro(2, 3);
        objetosTabuleiro[4][3] = fabrica.criaObjetoTabuleiro(4, 3);
        objetosTabuleiro[5][3] = fabrica.criaObjetoTabuleiro(5, 3);
        objetosTabuleiro[1][4] = fabrica.criaObjetoTabuleiro(1, 4);
        objetosTabuleiro[2][4] = fabrica.criaObjetoTabuleiro(2, 4);
        objetosTabuleiro[4][4] = fabrica.criaObjetoTabuleiro(4, 4);
        objetosTabuleiro[5][4] = fabrica.criaObjetoTabuleiro(5, 4);
        objetosTabuleiro[1][5] = fabrica.criaObjetoTabuleiro(1, 5);
        objetosTabuleiro[2][5] = fabrica.criaObjetoTabuleiro(2, 5);
        objetosTabuleiro[4][5] = fabrica.criaObjetoTabuleiro(4, 5);
        objetosTabuleiro[5][5] = fabrica.criaObjetoTabuleiro(5, 5);
    }
    
}
