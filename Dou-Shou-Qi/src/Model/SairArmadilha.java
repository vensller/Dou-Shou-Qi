package Model;

/**
 *
 * @author Ivens
 */
public class SairArmadilha implements Command{

    @Override
    public void execute(Peca[][] objetosTabuleiro, Peca animal, Peca padrao, Posicao destino) {
        objetosTabuleiro[animal.getColuna()][animal.getLinha()] = padrao;
        objetosTabuleiro[destino.getX()][destino.getY()] = animal;
        animal.setEstaNaArmadilha(false);
        animal.setColuna(destino.getX());
        animal.setLinha(destino.getY());
    }
    
}
