/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.correlica.lafdefaults;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author inda
 */
public class StatsGen {
    private static final Logger logger = Logger.getLogger(StatsGen.class.getName());
    
    public static void main(String [] args) {
        Set<Class<?>> classes = new HashSet<>();
        for (Item item : new Model(UIManager.getDefaults()).getItems()){
            classes.add(item.getValue().getClass());
        }
        for (Class c : classes) {
            logger.log(Level.INFO, "class: {0}", c.getCanonicalName());
        }
    }
}
