/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author HEISENBERG
 */
public class LimpaTela {
    //metodo de limpar tela
    public void LimpaTela(JPanel container){
        Component componente[] = container.getComponents();
        for (Component component : componente){
            if(component instanceof JTextField){
               ((JTextField) component).setText(null);
            }
        }
    }
}
