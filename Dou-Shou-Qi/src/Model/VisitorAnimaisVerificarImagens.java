package Model;

/**
 *
 * @author Ivens
 */
public class VisitorAnimaisVerificarImagens implements VisitorAnimaisJogador{

    @Override
    public void visit(Animal animal) {
        animal.verificarImagem();
    }
    
}
