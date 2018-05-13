package View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivens
 */
public class Tabuleiro extends javax.swing.JFrame{
    
    private static Tabuleiro instance; 
    private TabuleiroTableModel tableModel;
    private TabuleiroRenderer renderer;

    private Tabuleiro() {                
        initComponents();  
        jTabuleiro.setCellSelectionEnabled(true);                
        renderer = new TabuleiroRenderer();     
        jTabuleiro.setDefaultRenderer(Object.class, renderer);
        tableModel = new TabuleiroTableModel();        
        jTabuleiro.setModel(tableModel);    
        setResizable(false);
        jTabuleiro.addMouseListener(new TabuleiroMouseListener());
        JOptionPane.showMessageDialog(this, "Jogador 1 (Vermelho) começa!");
    }
    
    public synchronized static Tabuleiro getInstance(){
        if (instance == null){
            instance = new Tabuleiro();
        }
        
        return instance;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabuleiro = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabuleiro.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabuleiro, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabuleiro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jTabuleiro;
    // End of variables declaration//GEN-END:variables

   
    private class TabuleiroMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            ((TabuleiroTableModel)jTabuleiro.getModel()).movimentaPecas(jTabuleiro.getSelectedColumn(), jTabuleiro.getSelectedRow());
        }

        @Override
        public void mousePressed(MouseEvent e) {            
        }

        @Override
        public void mouseReleased(MouseEvent e) {            
        }

        @Override
        public void mouseEntered(MouseEvent e) {            
        }

        @Override
        public void mouseExited(MouseEvent e) {            
        }
        
    }
}
