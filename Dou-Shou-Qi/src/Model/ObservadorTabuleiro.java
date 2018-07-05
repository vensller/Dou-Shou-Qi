package Model;

/**
 *
 * @author Ivens
 */
public interface ObservadorTabuleiro {
    
    void notificarCarregamentoTabuleiro();
    void receberMensagem(String mensagem);
    void notificarAlteracaoTabuleiro();
    void notificarFimJogo(String jogadorVencedor);
    
}
