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
class ColorItem extends Item<Object, Color> {

    public ColorItem(Object key, Color value) {
        super(key, value);
    }

    @Override
    void renderValue(JLabel label) {
        label.setText(getValue().toString());
        label.setBackground(getValue());
        label.setIcon(null);
    }
    
}
