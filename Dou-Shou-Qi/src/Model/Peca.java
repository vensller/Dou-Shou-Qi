package Model;

/**
 *
 * @author Ivens
 */
public abstract class Peca{
        
    protected String imagem;   
    protected boolean estaNaArmadilha;
    protected int linha;
    protected int coluna;
    private String imagemOriginal;
    
    public Peca(String imagem, int linha, int coluna){
        this.imagem = imagem;
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

    public String getImagem(){
        return this.imagem;
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
    
    public abstract int getForca();
    
    public void accept(VisitorAtaque visitor){
        visitor.visit(this);
    }
}
