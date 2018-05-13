package Model;

/**
 *
 * @author Ivens
 */
public class FabricaDeLago extends FabricaDeObjetoTabuleiro{

    @Override
    public void criaObjetoTabuleiro(ObjetoTabuleiro[][] objetosTabuleiro) {
        objetosTabuleiro[1][3] = new Lago("Imagens/lago.png");
        objetosTabuleiro[2][3] = new Lago("Imagens/lago.png");
        objetosTabuleiro[4][3] = new Lago("Imagens/lago.png");
        objetosTabuleiro[5][3] = new Lago("Imagens/lago.png");
        objetosTabuleiro[1][4] = new Lago("Imagens/lago.png");
        objetosTabuleiro[2][4] = new Lago("Imagens/lago.png");
        objetosTabuleiro[4][4] = new Lago("Imagens/lago.png");
        objetosTabuleiro[5][4] = new Lago("Imagens/lago.png");
        objetosTabuleiro[1][5] = new Lago("Imagens/lago.png");
        objetosTabuleiro[2][5] = new Lago("Imagens/lago.png");
        objetosTabuleiro[4][5] = new Lago("Imagens/lago.png");
        objetosTabuleiro[5][5] = new Lago("Imagens/lago.png");        
    }
    
}
