package Controller;

import Model.ObjetoJogo;
import Model.ObjetoTabuleiro;

/**
 *
 * @author Ivens
 */
public interface Command {
   
    void execute(ObjetoTabuleiro[][] objetosTabuleiro, ObjetoJogo animal);
}
