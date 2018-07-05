package Controller;

import Model.CriarTabuleiro;
import Model.CriarTabuleiroHorizontal;
import Model.CriarTabuleiroVertical;
import Model.FabricaDeArmadilha;
import Model.FabricaDeCachorro;
import Model.FabricaDeElefante;
import Model.FabricaDeGato;
import Model.FabricaDeLeao;
import Model.FabricaDeLeopardo;
import Model.FabricaDeLobo;
import Model.FabricaDePeca;
import Model.FabricaDeRato;
import Model.FabricaDeTigre;
import Model.FabricaDeToca;
import Model.Jogo;
import Model.ObservadorJogo;
import Model.ObservadorTabuleiro;
import Model.Posicao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Ivens
 */
public class TabuleiroController implements ObservadorJogo{
    
    private List<ObservadorTabuleiro> observadores;    
    private Jogo jogo;
    private CriarTabuleiro criarTabuleiro;
    private HashMap<String, FabricaDePeca> fabricas;
    
    public TabuleiroController(String nomeJogador1, String nomeJogador2, boolean vertical){        
        jogo                  = new Jogo(nomeJogador1, nomeJogador2);
        observadores          = new ArrayList<>();        
        fabricas              = new HashMap<String, FabricaDePeca>();
        criaFabricas();
        jogo.observar(this);
        if (vertical)
            criarTabuleiro    = new CriarTabuleiroVertical(fabricas, jogo);
        else criarTabuleiro   = new CriarTabuleiroHorizontal(fabricas, jogo);
    }   
        
    private void criaFabricas(){
        fabricas.put("Armadilha", new FabricaDeArmadilha());
        fabricas.put("Cachorro", new FabricaDeCachorro());
        fabricas.put("Elefante", new FabricaDeElefante());
        fabricas.put("Gato", new FabricaDeGato());
        fabricas.put("Leao", new FabricaDeLeao());
        fabricas.put("Leopardo", new FabricaDeLeopardo());
        fabricas.put("Lobo", new FabricaDeLobo());
        fabricas.put("Rato", new FabricaDeRato());
        fabricas.put("Tigre", new FabricaDeTigre());
        fabricas.put("Toca", new FabricaDeToca());       
    }
    
    public void adicionaTodasPecasNoTabuleiro(){    
        criarTabuleiro.criarTabuleiro();
        notificarCarregamentoTabuleiro();
    }
    
    public void observarTabuleiro(ObservadorTabuleiro obs){
        observadores.add(obs);
    }
    
    public String retornaCaminhoImagemPelaPosicao(int coluna, int linha){
        if (jogo.getObjetosTabuleiro()[coluna][linha] != null){
            return jogo.getObjetosTabuleiro()[coluna][linha].getImagem();
        }else return "Imagens/grama.png";
    }
    
    public String retornaCaminhoImagemNaArmadilhaPelaPosicao(int coluna, int linha){
        if (jogo.getObjetosTabuleiro()[coluna][linha] != null){
            return jogo.getObjetosTabuleiro()[coluna][linha].getImagemNaArmadilha();
        }else return "Imagens/grama.png"; 
    }
    
    public String retornaCaminhoImagemNoLagoPelaPosicao(int coluna, int linha){
        if (jogo.getObjetosTabuleiro()[coluna][linha] != null){
            return jogo.getObjetosTabuleiro()[coluna][linha].getImagemNoLago();
        }else return "Imagens/grama.png";
    }
    
    public void movimentaPeca(int coluna, int linha){        
        if (jogo.retornaJogadorAtual().getAnimalAtual() == null){
            if (jogo.retornaJogadorAtual().retornaAnimalPelaPosicao(linha, coluna) != null){
                jogo.retornaJogadorAtual().setAnimalAtual(jogo.retornaJogadorAtual().retornaAnimalPelaPosicao(linha, coluna));
            }else enviarMensagemObservadores("Não é possível selecionar essa peça!");
        }else{
            Posicao posicao = new Posicao(coluna, linha);
            if (jogo.retornaJogadorAtual().getAnimalAtual().verificaSePodeMoverParaPosicao(posicao)){
                jogo.movimentaPeca(posicao);
                notificaMovimentacaoPeca();
                jogo.inverteJogadorAtual();
            }else enviarMensagemObservadores("Não é possível movimentar para a posição selecionada!");
        }              
    }
        
    private void notificaMovimentacaoPeca(){
        for (ObservadorTabuleiro obs : observadores){
            obs.notificarAlteracaoTabuleiro();
        }
    }
    
    private void notificaFimJogo(){
        for (ObservadorTabuleiro obs : observadores){            
            obs.notificarFimJogo(jogo.retornaJogadorAtual().getNome());
        }
    }
    
    private void notificarCarregamentoTabuleiro(){
        for (ObservadorTabuleiro obs : observadores){
            obs.notificarCarregamentoTabuleiro();
        }
    }    
    
    private void enviarMensagemObservadores(String mensagem){
        for (ObservadorTabuleiro obs : observadores){
            obs.receberMensagem(mensagem);
        }
    }   
    
    @Override
    public void notificarJogoEncerrado() {
        this.notificaFimJogo();
    }
        
}
