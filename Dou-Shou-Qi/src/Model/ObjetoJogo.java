package Model;

/**
 *
 * @author Ivens
 */
public abstract class ObjetoJogo {
    
    protected String imagem;   
    protected int jogador;
    protected boolean estaNaArmadilha;
    private int linha;
    private int coluna;
    private String imagemOriginal;
    
    public ObjetoJogo(String imagem, int jogador, int linha, int coluna){
        this.imagem = imagem;
        this.jogador = jogador;
        this.linha = linha;
        this.coluna = coluna;
        this.estaNaArmadilha = false;
        this.imagemOriginal = imagem.substring(0, imagem.length() - 4);
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
    
    public void setImagem(String imagem){
        this.imagem = imagem;
    }

    public boolean isEstaNaArmadilha() {
        return estaNaArmadilha;
    }

    public void setEstaNaArmadilha(boolean estaNaArmadilha) {
        this.estaNaArmadilha = estaNaArmadilha;
    }
    
    public String getImagemOriginal(){
        return this.imagemOriginal;
    }
    
}
