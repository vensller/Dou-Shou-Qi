package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivens
 */
public class Jogo {

    private ObjetoTabuleiro[][] objetosTabuleiro;
    private ObjetoTabuleiro[][] objetosPadroes;
    private Jogador jogador1;
    private Jogador jogador2;
    private JogoEstado estado;
    private List<ObservadorJogo> observadoresJogo;

    public Jogo(String nomeJogador1, String nomeJogador2) {
        objetosTabuleiro = new ObjetoTabuleiro[7][9];
        objetosPadroes   = new ObjetoTabuleiro[7][9];
        estado           = new JogoAguardandoInicio(this);
        jogador1         = new Jogador(nomeJogador1);
        jogador2         = new Jogador(nomeJogador2);
        observadoresJogo = new ArrayList();
        jogador1.setJogadorAtual(true);
    }

    public ObjetoTabuleiro[][] getObjetosTabuleiro() {
        return objetosTabuleiro;
    }

    public void setObjetosTabuleiro(ObjetoTabuleiro[][] objetosTabuleiro) {
        this.objetosTabuleiro = objetosTabuleiro;
    }

    public ObjetoTabuleiro[][] getObjetosPadroes() {
        return objetosPadroes;
    }

    public void setObjetosPadroes(ObjetoTabuleiro[][] objetosPadroes) {
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
    }
    
    public void movimentaPeca() throws Exception{
        estado.movimentaPeca();
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
        
}
