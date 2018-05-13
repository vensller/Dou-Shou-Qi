package Controller;

import Model.Animal;
import Model.FabricaDeArmadilha;
import Model.FabricaDeCachorro;
import Model.FabricaDeElefante;
import Model.FabricaDeGato;
import Model.FabricaDeLago;
import Model.FabricaDeLeao;
import Model.FabricaDeLeopardo;
import Model.FabricaDeLobo;
import Model.FabricaDeObjetoTabuleiro;
import Model.FabricaDePeca;
import Model.FabricaDeRato;
import Model.FabricaDeTigre;
import Model.FabricaDeToca;
import Model.ObjetoJogo;
import Model.ObjetoTabuleiro;
import Model.ObservadorTabuleiro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivens
 */
public class TabuleiroController {
    
    //objetosTabuleiro[x][y] sendo o tabuleiro em pé 7x9
    //x = coluna, y = linha
    private ObjetoTabuleiro[][] objetosTabuleiro; 
    private List<ObservadorTabuleiro> observadores;
    private int jogadorAtual;
    private ObjetoJogo animalAtual;    
    private AndarUmaCasaParaCima andarPraCima;
    private AndarUmaCasaParaBaixo andarPraBaixo;
    private AndarUmaCasaParaEsquerda andarPraEsquerda;
    private AndarUmaCasaParaDireita andarPraDireita;
    
    public TabuleiroController(){
        objetosTabuleiro = new ObjetoTabuleiro[7][9];
        observadores     = new ArrayList<>();
        jogadorAtual     = 1;
        animalAtual      = null;
        andarPraCima     = new AndarUmaCasaParaCima();
        andarPraBaixo    = new AndarUmaCasaParaBaixo();
        andarPraDireita  = new AndarUmaCasaParaDireita();
        andarPraEsquerda = new AndarUmaCasaParaEsquerda();
    }
    
    public void adicionaTodasPecasNoTabuleiro(){ 
        criaPecasDosJogadores(new FabricaDeToca());
        criaPecasDosJogadores(new FabricaDeArmadilha());
        criaPecasDosJogadores(new FabricaDeCachorro());
        criaPecasDosJogadores(new FabricaDeElefante());
        criaPecasDosJogadores(new FabricaDeGato());
        criaPecasDosJogadores(new FabricaDeLeao());
        criaPecasDosJogadores(new FabricaDeLeopardo());
        criaPecasDosJogadores(new FabricaDeLobo());
        criaPecasDosJogadores(new FabricaDeRato());
        criaPecasDosJogadores(new FabricaDeTigre());
        criaObjetosTabuleiro(new FabricaDeLago());
        notificarCarregamentoTabuleiro();
    }
    
    public void observarTabuleiro(ObservadorTabuleiro obs){
        observadores.add(obs);
    }
    
    public String retornaCaminhoImagemPelaPosicao(int coluna, int linha){
        if (objetosTabuleiro[coluna][linha] != null){
            return objetosTabuleiro[coluna][linha].getImagem();
        }else return "Imagens/grama.png";
    }
    
    public boolean movimentaPeca(int coluna, int linha){
        if (animalAtual == null){
            if (objetosTabuleiro[coluna][linha] != null){
                if (objetosTabuleiro[coluna][linha] instanceof Animal){
                    if (((Animal)objetosTabuleiro[coluna][linha]).getJogador() == jogadorAtual){
                        animalAtual = (ObjetoJogo)objetosTabuleiro[coluna][linha];                           
                    }else enviarMensagemObservadores("O animal selecionado é do outro jogador!");
                } else enviarMensagemObservadores("Não é uma peça movimentável!");
            }else enviarMensagemObservadores("Não é uma peça movimentável!");
        }else{
            if (objetosTabuleiro[coluna][linha] != null){
                
            }else {
                boolean movimentou = false;
                
                if (coluna == animalAtual.getColuna()){
                    if ((linha) == (animalAtual.getLinha() + 1)){                                               
                        andarPraBaixo.execute(objetosTabuleiro, animalAtual);
                        movimentou = true;
                    }                                       
                    if ((linha) == (animalAtual.getLinha() - 1)){
                        andarPraCima.execute(objetosTabuleiro, animalAtual);                         
                        movimentou = true;                        
                    }
                } 
                
                if (linha == animalAtual.getLinha()){
                    if ((coluna) == (animalAtual.getColuna() + 1)){
                        andarPraDireita.execute(objetosTabuleiro, animalAtual);
                        movimentou = true;
                    }
                    if ((coluna) == animalAtual.getColuna() - 1){
                        andarPraEsquerda.execute(objetosTabuleiro, animalAtual);
                        movimentou = true;
                    }
                }
                
                if (movimentou) {
                    inverteJogador();
                    animalAtual = null;
                }
            }
        }
        return false;
    }
    
    private void inverteJogador(){
        if (jogadorAtual == 1) jogadorAtual = 2;
        else jogadorAtual = 1;    
    }

    private void notificarCarregamentoTabuleiro(){
        for (ObservadorTabuleiro obs : observadores){
            obs.notificarCarregamentoTabuleiro();
        }
    }
    
    private void criaPecasDosJogadores(FabricaDePeca fabrica){
        fabrica.CriaPecaJogador1(objetosTabuleiro);
        fabrica.CriaPecaJogador2(objetosTabuleiro);
    }
    
    private void criaObjetosTabuleiro(FabricaDeObjetoTabuleiro fabrica){
        fabrica.criaObjetoTabuleiro(objetosTabuleiro);
    }
    
    private void enviarMensagemObservadores(String mensagem){
        for (ObservadorTabuleiro obs : observadores){
            obs.receberMensagem(mensagem);
        }
    }
        
}
