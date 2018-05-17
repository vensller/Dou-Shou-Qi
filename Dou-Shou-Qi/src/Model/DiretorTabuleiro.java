package Model;

/**
 *
 * @author Ivens
 */
public class DiretorTabuleiro {
    
    private BuilderObjetoTabuleiro builder;

    public DiretorTabuleiro(BuilderObjetoTabuleiro builder) {
        this.builder = builder;
    }
    
    public void construir(ObjetoTabuleiro[][] objetosTabuleiro){
        builder.criaLagos(objetosTabuleiro, new FabricaDeLago());
    }
    
}
