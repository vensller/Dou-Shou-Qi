package Model;

import java.util.List;

/**
 *
 * @author Ivens
 */
public class VisitorAnimaisSetarImagemArmadilha implements VisitorAnimaisJogador{

    List<Armadilha> armadilhas;

    public VisitorAnimaisSetarImagemArmadilha(List<Armadilha> armadilhas) {
        this.armadilhas = armadilhas;
    }
    
    @Override
    public void visit(Animal animal) {        
        animal.verificarSeEstaNaPropriaArmadilha(armadilhas);
    }
    
}
