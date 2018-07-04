package Model;

import java.util.HashMap;

/**
 *
 * @author Ivens
 */
public class CriarTabuleiroVertical implements CriarTabuleiro{
        
    private HashMap<String, FabricaDePeca> fabricas;
    private Jogo jogo;

    public CriarTabuleiroVertical(HashMap<String, FabricaDePeca> fabricas, Jogo jogo) {
        this.fabricas = fabricas;
        this.jogo = jogo;
    }   
    
    @Override
    public void criarTabuleiro() {
        jogo.setObjetosTabuleiro(new Peca[7][9]);
        jogo.setObjetosPadroes(new Peca[7][9]);
        ConcretBuilderJogador1 builderJogador1             = new ConcretBuilderJogador1(jogo.getJogador1());
        ConcretBuilderJogador2 builderJogador2             = new ConcretBuilderJogador2(jogo.getJogador2());        
        ConcretBuilderTabuleiro builderTabuleiro           = new ConcretBuilderTabuleiro();
        VisitorAnimaisSetarTabuleiro visitorSetarTabuleiro = new VisitorAnimaisSetarTabuleiro(jogo.getObjetosTabuleiro());
        VisitorAnimaisDefinirPosicoes visitorPosicoes      = new VisitorAnimaisDefinirPosicoes();        
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
        jogo.getJogador1().accept(visitorJogador1);
        jogo.getJogador2().accept(visitorJogador2);
    }
    
    private void criaJogadores(BuilderJogador builder){
        DiretorJogador diretor = new DiretorJogador(builder, fabricas);
        diretor.construir(jogo.getObjetosTabuleiro(), jogo.getObjetosPadroes());
    }
    
    private void criaTabuleiro(BuilderObjetoTabuleiro builder){
        DiretorTabuleiro diretor = new DiretorTabuleiro(builder);
        diretor.construir(jogo.getObjetosTabuleiro());
    }
    
}
