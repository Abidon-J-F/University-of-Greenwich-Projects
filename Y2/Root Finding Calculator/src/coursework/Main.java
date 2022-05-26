/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg001013672_comp1555_coursework;

/**
 *
 * @author Abido
 */
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

//Secure way to run the program
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, "Abidon Jude Fernandes - 001013672");
                Coursework cw = new Coursework();
            }

        });

    }

}
