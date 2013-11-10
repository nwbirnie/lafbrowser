/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.correlica.lafdefaults;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author inda
 */
class ObjectItem extends Item {

    ObjectItem(Object k, Object v) {
        super(k,v);
    }
    
    @Override
    void renderValue(JLabel label) {
        label.setText(getValue() == null ? "null" : getValue().toString());
        label.setBackground(Color.white);
        label.setIcon(null);
    }
}
