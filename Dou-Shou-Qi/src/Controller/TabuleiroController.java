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
import Model.Peca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Ivens
 */
public class TabuleiroController implements ObservadorJogo{
    
    private List<ObservadorTabuleiro> observadores;    
    private AndarUmaCasaParaCima andarPraCima;
    private AndarUmaCasaParaBaixo andarPraBaixo;
    private AndarUmaCasaParaEsquerda andarPraEsquerda;
    private AndarUmaCasaParaDireita andarPraDireita;
    private PularLagoParaBaixo pularLagoParaBaixo;
    private PularLagoParaCima pularLagoParaCima;
    private PularLagoParaEsquerda pularLagoParaEsquerda;
    private PularLagoParaDireita pularLagoParaDireita;    
    private Jogo jogo;
    private CriarTabuleiro criarTabuleiro;
    private HashMap<String, FabricaDePeca> fabricas;
    
    public TabuleiroController(String nomeJogador1, String nomeJogador2, boolean vertical){        
        jogo                  = new Jogo(nomeJogador1, nomeJogador2);
        observadores          = new ArrayList<>();        
        andarPraCima          = new AndarUmaCasaParaCima();
        andarPraBaixo         = new AndarUmaCasaParaBaixo();
        andarPraDireita       = new AndarUmaCasaParaDireita();
        andarPraEsquerda      = new AndarUmaCasaParaEsquerda();
        pularLagoParaCima     = new PularLagoParaCima();
        pularLagoParaBaixo    = new PularLagoParaBaixo();
        pularLagoParaEsquerda = new PularLagoParaEsquerda();
        pularLagoParaDireita  = new PularLagoParaDireita();
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
    
    public void movimentaPeca(int coluna, int linha){
        boolean movimentou = false;
        boolean fimJogo = false;
        boolean trocouImagem = false;
        
        /* if (animalAtual == null){
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
                    if (movimentou){
                        ((Rato)animalAtual).setEstaNoLago(true);
                        animalAtual.setImagem("Imagens/rato" + jogadorAtual + "NoLago.png");
                        trocouImagem = true;
                    }
                }else if ((objetosTabuleiro[coluna][linha] instanceof Armadilha) && (((Armadilha)objetosTabuleiro[coluna][linha]).getJogador() != jogadorAtual)){
                    movimentou = movimentaPecaParaPosicao(coluna, linha);   
                    if (movimentou){
                        animalAtual.setEstaNaArmadilha(true);
                        animalAtual.setImagem(animalAtual.getImagemOriginal() + "NaArmadilha.png");
                        trocouImagem = true;
                    }
                }else if ((objetosTabuleiro[coluna][linha] instanceof Toca)&&(((Toca)objetosTabuleiro[coluna][linha]).getJogador() != jogadorAtual)){
                    movimentou = movimentaPecaParaPosicao(coluna, linha);
                    fimJogo = movimentou;
                }
            }else {
                movimentou = movimentaPecaParaPosicao(coluna, linha);
            }
        }    
        
        if (movimentou){
            if (!trocouImagem){
                if (animalAtual.isEstaNaArmadilha()){
                    animalAtual.setEstaNaArmadilha(false);
                    animalAtual.setImagem(animalAtual.getImagemOriginal() + ".png");
                }else if ((animalAtual instanceof Rato) && ((Rato)animalAtual).isEstaNoLago()){
                    ((Rato)animalAtual).setEstaNoLago(false);
                    animalAtual.setImagem(animalAtual.getImagemOriginal() + ".png");
                }
            }else notificaImagemAlterada(((ObjetoTabuleiro)animalAtual).getImagem());
            
            inverteJogador();
            animalAtual = null;        
            notificaMovimentacaoPeca();
            if (fimJogo){
                notificaFimJogo();
            }
        }    */   
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
    
    private boolean movimentaPecaPulandoLago(int coluna, int linha){
        boolean movimentou = false;
        
        /*if ((animalAtual instanceof Tigre) || (animalAtual instanceof Leao)){
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
        */
        return movimentou;
    }
    
    /*private boolean verificaSePodePularLagoParaEsquerda(){
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
    */
    private boolean movimentaPecaParaPosicao(int coluna, int linha){
        boolean movimentou = false;
                
        /*if (coluna == animalAtual.getColuna()){
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
        */
        return movimentou;
    }
    
    private Peca retornaObjetoPadraoPosicao(int coluna, int linha){        
        return jogo.getObjetosPadroes()[coluna][linha];        
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
    
    private void notificaImagemAlterada(String imagem){
        for (ObservadorTabuleiro obs : observadores){
            obs.notificaTrocouImagem(imagem);
        }
    }

    @Override
    public void notificarJogoEncerrado() {
        this.notificaFimJogo();
    }
        
}
