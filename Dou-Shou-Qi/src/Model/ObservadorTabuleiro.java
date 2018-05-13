package Model;

/**
 *
 * @author Ivens
 */
public interface ObservadorTabuleiro {
    
    void notificarCarregamentoTabuleiro();
    void receberMensagem(String mensagem);
    
}
