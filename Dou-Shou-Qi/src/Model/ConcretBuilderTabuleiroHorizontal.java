package Model;

/**
 *
 * @author Ivens
 */
public class ConcretBuilderTabuleiroHorizontal extends BuilderObjetoTabuleiro{

    @Override
    public void criaLagos(Peca[][] objetosTabuleiro, FabricaDeLago fabrica) {
        objetosTabuleiro[3][1] = fabrica.criaObjetoTabuleiro(3, 1);
        objetosTabuleiro[3][2] = fabrica.criaObjetoTabuleiro(3, 2);
        objetosTabuleiro[3][4] = fabrica.criaObjetoTabuleiro(3, 4);
        objetosTabuleiro[3][5] = fabrica.criaObjetoTabuleiro(3, 5);
        objetosTabuleiro[4][1] = fabrica.criaObjetoTabuleiro(4, 1);
        objetosTabuleiro[4][2] = fabrica.criaObjetoTabuleiro(4, 2);
        objetosTabuleiro[4][4] = fabrica.criaObjetoTabuleiro(4, 4);
        objetosTabuleiro[4][5] = fabrica.criaObjetoTabuleiro(4, 5);
        objetosTabuleiro[5][1] = fabrica.criaObjetoTabuleiro(5, 1);
        objetosTabuleiro[5][2] = fabrica.criaObjetoTabuleiro(5, 2);
        objetosTabuleiro[5][4] = fabrica.criaObjetoTabuleiro(5, 4);
        objetosTabuleiro[5][5] = fabrica.criaObjetoTabuleiro(5, 5);
    }
    
}
