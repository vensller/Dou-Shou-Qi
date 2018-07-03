package Model;

import java.util.HashMap;

/**
 *
 * @author Ivens
 */
public class CriarTabuleiroVertical implements CriarTabuleiro{
        
    private HashMap<String, FabricaDePeca> fabricas;
    private Jogo jogo;
    
    public CriarTabuleiroVertical(){
        fabricas = new HashMap<String, FabricaDePeca>();
        this.criaFabricas();
    }
    
    @Override
    public void criarTabuleiro(Jogo jogo) {
        jogo.setObjetosTabuleiro(new ObjetoTabuleiro[7][9]);
        jogo.setObjetosPadroes(new ObjetoTabuleiro[7][9]);
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
    }
    
    private void criaJogadores(BuilderJogador builder){
        DiretorJogador diretor = new DiretorJogador(builder, fabricas);
        diretor.construir(jogo.getObjetosTabuleiro(), jogo.getObjetosPadroes());
    }
    
    private void criaTabuleiro(BuilderObjetoTabuleiro builder){
        DiretorTabuleiro diretor = new DiretorTabuleiro(builder);
        diretor.construir(jogo.getObjetosTabuleiro());
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
    
}
