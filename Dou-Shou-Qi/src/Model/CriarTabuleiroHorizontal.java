package Model;

import java.util.HashMap;

/**
 *
 * @author Ivens
 */
public class CriarTabuleiroHorizontal implements CriarTabuleiro{
        
    private HashMap<String, FabricaDePeca> fabricas;
    private Jogo jogo;

    public CriarTabuleiroHorizontal(HashMap<String, FabricaDePeca> fabricas, Jogo jogo) {
        this.fabricas = fabricas;
        this.jogo = jogo;
    }   
    
    @Override
    public void criarTabuleiro() {
        jogo.setObjetosTabuleiro(new Peca[9][7]);
        jogo.setObjetosPadroes(new Peca[9][7]);
        VisitorAnimaisSetarTabuleiro visitorSetarTabuleiro = new VisitorAnimaisSetarTabuleiro(jogo.getObjetosTabuleiro());
        VisitorAnimaisDefinirPosicoes visitorPosicoes      = new VisitorAnimaisDefinirPosicoes();
        ConcretBuilderJogador1Horizontal builderJogador1   = new ConcretBuilderJogador1Horizontal(jogo.getJogador1());
        ConcretBuilderJogador2Horizontal builderJogador2   = new ConcretBuilderJogador2Horizontal(jogo.getJogador2());
        ConcretBuilderTabuleiroHorizontal builderTabuleiro = new ConcretBuilderTabuleiroHorizontal();
        this.jogo = jogo;
        
        criaTabuleiro(builderTabuleiro);
        criaJogadores(builderJogador1);
        criaJogadores(builderJogador2);
        
        jogo.getJogador1().accept(visitorSetarTabuleiro);
        jogo.getJogador2().accept(visitorSetarTabuleiro);
        jogo.getJogador1().accept(visitorPosicoes);
        jogo.getJogador2().accept(visitorPosicoes);
        VisitorAnimaisJogadorSetarJogador visitorJogador1 = new VisitorAnimaisJogadorSetarJogador(jogo.getJogador1());        
        VisitorAnimaisJogadorSetarJogador visitorJogador2 = new VisitorAnimaisJogadorSetarJogador(jogo.getJogador2());  
        VisitorAnimaisNaoDeixarEntrarToca visitorToca1    = new VisitorAnimaisNaoDeixarEntrarToca(jogo.getJogador1().getToca());
        VisitorAnimaisNaoDeixarEntrarToca visitorToca2    = new VisitorAnimaisNaoDeixarEntrarToca(jogo.getJogador2().getToca());
        jogo.getJogador1().accept(visitorJogador1);
        jogo.getJogador2().accept(visitorJogador2);
        jogo.getJogador1().accept(visitorToca1);
        jogo.getJogador2().accept(visitorToca2);   
    }
    
    private void criaJogadores(BuilderJogador builder){
        DiretorJogador diretor = new DiretorJogador(builder, fabricas);
        diretor.construir(jogo.getObjetosTabuleiro(), jogo.getObjetosPadroes());
    }
    
    private void criaTabuleiro(BuilderObjetoTabuleiro builder){
        DiretorTabuleiro diretor = new DiretorTabuleiro(builder);
        diretor.construir(jogo.getObjetosTabuleiro(), jogo.getObjetosPadroes());
    }
      
}
