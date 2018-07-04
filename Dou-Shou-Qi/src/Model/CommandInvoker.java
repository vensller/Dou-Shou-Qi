package Model;

import java.util.HashMap;

/**
 *
 * @author Ivens
 */
public class CommandInvoker {
    
    private HashMap<Integer, Command> comandos;
    
    public CommandInvoker(){
        comandos = new HashMap<>();
    }
    
    public void addComando(Integer codComando, Command comando){
        comandos.put(codComando, comando);
    }
    
    public void removeComando(Integer codComando){
        comandos.remove(codComando);
    }
    
    public void executaComando(Integer codComando, Peca[][] pecas, Peca animal, Peca padrao, Posicao destino){
        comandos.get(codComando).execute(pecas, animal, padrao, destino);
    }
    
}
