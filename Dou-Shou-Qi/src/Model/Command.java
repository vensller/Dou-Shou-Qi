package Model;

import Model.Peca;

/**
 *
 * @author Ivens
 */
public interface Command {
   
    void execute(Peca[][] objetosTabuleiro, Peca animal, Peca padrao, Posicao destino);
}
