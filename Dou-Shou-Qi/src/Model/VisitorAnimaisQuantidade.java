package Model;

/**
 *
 * @author Ivens
 */
public class VisitorAnimaisQuantidade implements VisitorAnimaisJogador{   

    private int qtd;

    public VisitorAnimaisQuantidade() {
        qtd = 0;
    }    
    
    public int getQtd(){
        return qtd;
    }
    
    @Override
    public void visit(Animal animal) {
        if (animal != null){
            qtd++;
        }
    }
    
}
