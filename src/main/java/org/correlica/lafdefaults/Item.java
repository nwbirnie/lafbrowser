/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.correlica.lafdefaults;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author inda
 */
abstract class Item<K,V> {
    
    private static final Logger logger = Logger.getLogger(Item.class.getName());
    private final K key;
    private final V value;

    Item(K key, V value) {
        this.key = key;
        this.value = value;
        logger.log(Level.INFO, "key = {0} value = {1}", new Object[]{key, value});
    }
    
    void renderKey(JLabel label) {
        label.setText(getKey().toString());
        label.setBackground(Color.GRAY);
        label.setIcon(null);
    }
    
    abstract void renderValue(JLabel label);

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }
    
}
