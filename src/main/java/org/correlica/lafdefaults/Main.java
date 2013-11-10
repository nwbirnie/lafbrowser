/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.correlica.lafdefaults;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.logging.LogManager;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author inda
 */
public class Main {

    public static void main(String[] args) throws IOException {
        LogManager.getLogManager().readConfiguration();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame() {
                    {
                        setLayout(new BorderLayout());
                        add(new Presenter(new Model(UIManager.getDefaults())), BorderLayout.CENTER);
                        setDefaultCloseOperation(EXIT_ON_CLOSE);
                    }
                };
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
