package Model;

/**
 *
 * @author Ivens
 */
public abstract class ObjetoJogo {
    
    protected String imagem;
    protected int jogador;
    private int linha;
    private int coluna;
    
    public ObjetoJogo(String imagem, int jogador, int linha, int coluna){
        this.imagem = imagem;
        this.jogador = jogador;
        this.linha = linha;
        this.coluna = coluna;
    }
    
    public void setLinha(int linha){
        this.linha = linha;
    }
    
    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    
}
