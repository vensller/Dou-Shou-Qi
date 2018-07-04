package Model;

/**
 *
 * @author Ivens
 */
public class MovimentarPeca implements Command{

    @Override
    public void execute(Peca[][] objetosTabuleiro, Peca animal, Peca padrao, Posicao destino) {
        objetosTabuleiro[animal.getColuna()][animal.getLinha()] = padrao;
        objetosTabuleiro[destino.getX()][destino.getY()] = animal;        
        animal.setColuna(destino.getX());
        animal.setLinha(destino.getY());
    }
    
}
