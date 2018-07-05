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
        jogo.getJogador1().accept(v1);
        jogo.getJogador2().accept(v2);        
        boolean entrouNaToca = outro.getToca().getLinha() == posicao.getY() && outro.getToca().getColuna() == posicao.getX();        
        if (v1.getQtd() == 0 || v2.getQtd() == 0 || entrouNaToca){
            jogo.setEstado(new JogoFinalizado(jogo));
        }
    }
    
}
