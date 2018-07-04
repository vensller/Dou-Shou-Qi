package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivens
 */
public class Jogo {

    private Peca[][] objetosTabuleiro;
    private Peca[][] objetosPadroes;
    private Jogador jogador1;
    private Jogador jogador2;
    private JogoEstado estado;
    private List<ObservadorJogo> observadoresJogo;
    private CommandInvoker comandos;

    public Jogo(String nomeJogador1, String nomeJogador2) {
        objetosTabuleiro = null;
        objetosPadroes   = null;
        estado           = new JogoAguardandoInicio(this);
        jogador1         = new Jogador(nomeJogador1);
        jogador2         = new Jogador(nomeJogador2);
        observadoresJogo = new ArrayList();
        comandos         = new CommandInvoker();
        jogador1.setJogadorAtual(true);
        jogador2.setJogadorAtual(false);        
        adicionarComandos();
    }
    
    private void adicionarComandos(){
        MovimentarPeca movimentarPeca = new MovimentarPeca(); //Codigo 0
        EntrarLago entrarLago = new EntrarLago(); //Codigo 1
        SairLago sairLago = new SairLago(); //Codigo 2
        EntrarArmadilha entrarArmadilha = new EntrarArmadilha(); //Codigo 3
        SairArmadilha sairArmadilha = new SairArmadilha(); //Codigo 4
        comandos.addComando(0, movimentarPeca);
        comandos.addComando(1, entrarLago);
        comandos.addComando(2, sairLago);
        comandos.addComando(3, entrarArmadilha);
        comandos.addComando(4, sairArmadilha);
    }

    public Peca[][] getObjetosTabuleiro() {
        return objetosTabuleiro;
    }

    public void setObjetosTabuleiro(Peca[][] objetosTabuleiro) {
        this.objetosTabuleiro = objetosTabuleiro;
    }

    public Peca[][] getObjetosPadroes() {
        return objetosPadroes;
    }

    public void setObjetosPadroes(Peca[][] objetosPadroes) {
        this.objetosPadroes = objetosPadroes;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public JogoEstado getEstado() {
        return estado;
    }

    public void setEstado(JogoEstado estado) {
        this.estado = estado;
    }
    
    public Jogador retornaJogadorAtual(){
        if (jogador1.isJogadorAtual())
            return jogador1;
        else return jogador2;
    }
    
    public void inverteJogadorAtual(){
        if (jogador1.isJogadorAtual()){
            jogador1.setJogadorAtual(false);
            jogador2.setJogadorAtual(true);
        }else{
            jogador2.setJogadorAtual(false);
            jogador1.setJogadorAtual(true);
        }
        
        jogador1.setAnimalAtual(null);
        jogador2.setAnimalAtual(null);
    }
    
    public void movimentaPeca(Posicao posicao){
        estado.movimentaPeca(posicao);
    }
    
    public void encerrarJogo(){
        for (ObservadorJogo obs : observadoresJogo){
            obs.notificarJogoEncerrado();
        }        
    }
    
    public void observar(ObservadorJogo obs){
        observadoresJogo.add(obs);
    }
    
    public void pararObservacacao(ObservadorJogo obs){
        observadoresJogo.remove(obs);
    }
    
    public void realizaMovimentacao(int opcao, Peca atual, Peca padrao, Posicao destino){
        comandos.executaComando(opcao, objetosTabuleiro, atual, padrao, destino);
    }
        
}
