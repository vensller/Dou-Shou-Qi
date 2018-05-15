package Controller;

import Model.Animal;
import Model.Armadilha;
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
import Model.Lago;
import Model.Leao;
import Model.ObjetoJogo;
import Model.ObjetoTabuleiro;
import Model.ObservadorTabuleiro;
import Model.Rato;
import Model.Tigre;
import Model.Toca;
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
    private ObjetoTabuleiro[][] objetosPadroes;
    private List<ObservadorTabuleiro> observadores;
    private int jogadorAtual;
    private ObjetoJogo animalAtual;    
    private AndarUmaCasaParaCima andarPraCima;
    private AndarUmaCasaParaBaixo andarPraBaixo;
    private AndarUmaCasaParaEsquerda andarPraEsquerda;
    private AndarUmaCasaParaDireita andarPraDireita;
    private PularLagoParaBaixo pularLagoParaBaixo;
    private PularLagoParaCima pularLagoParaCima;
    private PularLagoParaEsquerda pularLagoParaEsquerda;
    private PularLagoParaDireita pularLagoParaDireita;
    
    public TabuleiroController(){
        objetosTabuleiro      = new ObjetoTabuleiro[7][9];
        objetosPadroes        = new ObjetoTabuleiro[7][9];
        observadores          = new ArrayList<>();
        jogadorAtual          = 1;
        animalAtual           = null;
        andarPraCima          = new AndarUmaCasaParaCima();
        andarPraBaixo         = new AndarUmaCasaParaBaixo();
        andarPraDireita       = new AndarUmaCasaParaDireita();
        andarPraEsquerda      = new AndarUmaCasaParaEsquerda();
        pularLagoParaCima     = new PularLagoParaCima();
        pularLagoParaBaixo    = new PularLagoParaBaixo();
        pularLagoParaEsquerda = new PularLagoParaEsquerda();
        pularLagoParaDireita  = new PularLagoParaDireita();
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
    
    public void movimentaPeca(int coluna, int linha){
        boolean movimentou = false;
        boolean fimJogo = false;
        
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
                if ((objetosTabuleiro[coluna][linha] instanceof Lago)&&(animalAtual instanceof Rato)){
                    movimentou = movimentaPecaParaPosicao(coluna, linha);
                }else if (objetosTabuleiro[coluna][linha] instanceof Armadilha){
                    movimentou = movimentaPecaParaPosicao(coluna, linha);                    
                }else if ((objetosTabuleiro[coluna][linha] instanceof Toca)&&(((Toca)objetosTabuleiro[coluna][linha]).getJogador() != jogadorAtual)){
                    movimentou = movimentaPecaParaPosicao(coluna, linha);
                    fimJogo = movimentou;
                }
            }else {
                movimentou = movimentaPecaParaPosicao(coluna, linha);
            }
        }    
        
        if (movimentou){
            notificaMovimentacaoPeca();
            if (fimJogo){
                notificaFimJogo();
            }
        }       
    }
    
    private void notificaMovimentacaoPeca(){
        for (ObservadorTabuleiro obs : observadores){
            obs.notificarAlteracaoTabuleiro();
        }
    }
    
    private void notificaFimJogo(){
        for (ObservadorTabuleiro obs : observadores){
            obs.notificarFimJogo(jogadorAtual);
        }
    }
    
    private boolean movimentaPecaPulandoLago(int coluna, int linha){
        boolean movimentou = false;
        
        if ((animalAtual instanceof Tigre) || (animalAtual instanceof Leao)){
            if (linha == animalAtual.getLinha()){
                if ((coluna == animalAtual.getColuna() + 3)&&(verificaSePodePularLagoParaDireita())){
                    pularLagoParaDireita.execute(objetosTabuleiro, animalAtual, retornaObjetoPadraoPosicao(coluna, linha));
                    movimentou = true;
                }
                if ((coluna == animalAtual.getColuna() - 3)&&(verificaSePodePularLagoParaEsquerda())){
                    pularLagoParaEsquerda.execute(objetosTabuleiro, animalAtual, retornaObjetoPadraoPosicao(coluna, linha));
                    movimentou = true;
                }
            }
            if (coluna == animalAtual.getColuna()){
                if ((linha == animalAtual.getLinha() + 4)&&(verificaSePodePularLagoParaBaixo())){
                    pularLagoParaBaixo.execute(objetosTabuleiro, animalAtual, retornaObjetoPadraoPosicao(coluna, linha));
                    movimentou = true;
                }
                if ((linha == animalAtual.getLinha() - 4)&&(verificaSePodePularLagoParaCima())){
                    pularLagoParaCima.execute(objetosTabuleiro, animalAtual, retornaObjetoPadraoPosicao(coluna, linha));
                }
            }
        }        
        
        return movimentou;
    }
    
    private boolean verificaSePodePularLagoParaEsquerda(){
        for (int i = -2; i < 0; i++){
            if (!(objetosTabuleiro[animalAtual.getColuna() + i][animalAtual.getLinha()] instanceof Lago)){
                return false;
            }
        }
        return true;
    }
    
    private boolean verificaSePodePularLagoParaDireita(){
        for (int i = 1; i <= 2; i++){
            if (!(objetosTabuleiro[animalAtual.getColuna() + i][animalAtual.getLinha()] instanceof Lago)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean verificaSePodePularLagoParaCima(){
        for (int i = -3; i < 0; i++){
            if (!(objetosTabuleiro[animalAtual.getColuna()][animalAtual.getLinha() + i] instanceof Lago)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean verificaSePodePularLagoParaBaixo(){
        for (int i = 1; i <= 3; i++){
            if (!(objetosTabuleiro[animalAtual.getColuna()][animalAtual.getLinha() + i] instanceof Lago)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean movimentaPecaParaPosicao(int coluna, int linha){
        boolean movimentou = false;
                
        if (coluna == animalAtual.getColuna()){
            if ((linha) == (animalAtual.getLinha() + 1)){                                               
                andarPraBaixo.execute(objetosTabuleiro, animalAtual, retornaObjetoPadraoPosicao(animalAtual.getColuna(), animalAtual.getLinha()));
                movimentou = true;
            }                                       
            if ((linha) == (animalAtual.getLinha() - 1)){
                andarPraCima.execute(objetosTabuleiro, animalAtual, retornaObjetoPadraoPosicao(animalAtual.getColuna(), animalAtual.getLinha()));                         
                movimentou = true;                        
            }
        } 

        if (linha == animalAtual.getLinha()){
            if ((coluna) == (animalAtual.getColuna() + 1)){                
                andarPraDireita.execute(objetosTabuleiro, animalAtual, retornaObjetoPadraoPosicao(animalAtual.getColuna(), animalAtual.getLinha()));
                movimentou = true;
            }
            if ((coluna) == animalAtual.getColuna() - 1){
                andarPraEsquerda.execute(objetosTabuleiro, animalAtual, retornaObjetoPadraoPosicao(animalAtual.getColuna(), animalAtual.getLinha()));
                movimentou = true;
            }
        }
        
        if (!movimentou){
            movimentou = movimentaPecaPulandoLago(coluna, linha);
        }

        if (movimentou) {
            inverteJogador();
            animalAtual = null;
        }
        
        return movimentou;
    }
    
    private ObjetoTabuleiro retornaObjetoPadraoPosicao(int coluna, int linha){        
        return objetosPadroes[coluna][linha];        
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
        fabrica.criaPecaJogador1(objetosTabuleiro);
        fabrica.criaPecaJogador2(objetosTabuleiro);
    }
    
    private void criaObjetosTabuleiro(FabricaDeObjetoTabuleiro fabrica){
        fabrica.criaObjetoTabuleiro(objetosTabuleiro);
        fabrica.criaObjetoTabuleiro(objetosPadroes);
    }
    
    private void enviarMensagemObservadores(String mensagem){
        for (ObservadorTabuleiro obs : observadores){
            obs.receberMensagem(mensagem);
        }
    }
        
}
