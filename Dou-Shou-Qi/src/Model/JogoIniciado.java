package Model;

/**
 *
 * @author Ivens
 */
public class JogoIniciado extends JogoEstado{
    
    public JogoIniciado(Jogo jogo) {
        super(jogo);
    }

    @Override
    public void movimentaPeca(Posicao posicao){    
        Jogador atual = jogo.retornaJogadorAtual();
        Jogador outro;        
       
        if (jogo.retornaJogadorAtual() == jogo.getJogador1()){
            outro = jogo.getJogador2();
        }else{
            outro = jogo.getJogador1();
        }        
        
        Animal animal = outro.retornaAnimalPelaPosicao(posicao.getY(), posicao.getX());
        
        if (animal != null){
            outro.removePeca(animal);
        }
        
        int opcao = 0;
        
        if (atual.getAnimalAtual().verificaSePosicaoELago(posicao)){
            opcao = 1;
        }
        
        if (atual.getAnimalAtual().isEstaNoLago() && !atual.getAnimalAtual().verificaSePosicaoELago(posicao)){
            opcao = 2;
        }
        
        if (outro.verificaSeEhArmadilha(posicao.getY(), posicao.getX())){
            opcao = 3;
        }
        
        if (outro.verificaSeEhArmadilha(atual.getAnimalAtual().getLinha(), atual.getAnimalAtual().getColuna()) && !outro.verificaSeEhArmadilha(posicao.getY(), posicao.getX())){
            opcao = 4;
        }
        
        Peca padrao = jogo.getObjetosPadroes()[atual.getAnimalAtual().getColuna()][atual.getAnimalAtual().getLinha()];
        
        jogo.realizaMovimentacao(opcao, atual.getAnimalAtual(), padrao, posicao);        
        jogo.verificaAlteracaoImagem();
        
        VisitorAnimaisQuantidade v1 = new VisitorAnimaisQuantidade();
        VisitorAnimaisQuantidade v2 = new VisitorAnimaisQuantidade();
        VisitorAnimaisDefinirPosicoes visitorPosicoes = new VisitorAnimaisDefinirPosicoes(); 
        VisitorAnimaisNaoDeixarEntrarToca visitorToca1 = new VisitorAnimaisNaoDeixarEntrarToca(jogo.getJogador1().getToca());
        VisitorAnimaisNaoDeixarEntrarToca visitorToca2 = new VisitorAnimaisNaoDeixarEntrarToca(jogo.getJogador2().getToca());                
        VisitorAnimaisSetarImagemArmadilha visitArm1   = new VisitorAnimaisSetarImagemArmadilha(jogo.getJogador1().getArmadilhas());
        VisitorAnimaisSetarImagemArmadilha visitArm2   = new VisitorAnimaisSetarImagemArmadilha(jogo.getJogador2().getArmadilhas());
        jogo.getJogador1().accept(v1);
        jogo.getJogador2().accept(v2);        
        jogo.getJogador1().accept(visitorPosicoes);
        jogo.getJogador2().accept(visitorPosicoes);
        jogo.getJogador1().accept(visitorToca1);
        jogo.getJogador2().accept(visitorToca2); 
        jogo.getJogador1().accept(visitArm1);
        jogo.getJogador2().accept(visitArm2); 
        VisitorAnimaisNaoDeixarMatarMesmoTime visitorTime1 = new VisitorAnimaisNaoDeixarMatarMesmoTime(jogo.getJogador1().getPecas());
        VisitorAnimaisNaoDeixarMatarMesmoTime visitorTime2 = new VisitorAnimaisNaoDeixarMatarMesmoTime(jogo.getJogador2().getPecas());
        jogo.getJogador1().accept(visitorTime1);
        jogo.getJogador1().accept(visitorTime2);
        boolean entrouNaToca = outro.getToca().getLinha() == posicao.getY() && outro.getToca().getColuna() == posicao.getX();        
        if (v1.getQtd() == 0 || v2.getQtd() == 0 || entrouNaToca){
            jogo.setEstado(new JogoFinalizado(jogo));
        }
    }
    
}
