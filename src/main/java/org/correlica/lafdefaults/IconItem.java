/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.correlica.lafdefaults;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author inda
 */
class IconItem extends Item<Object,Icon> {

    private static final Logger logger = Logger.getLogger(IconItem.class.getName());
    private boolean initialised = false;
    private boolean canPaint = true;
    
    public IconItem(Object key, Icon icon) {
        super(key,icon);
    }

    @Override
    void renderValue(JLabel label) {
        if (!initialised) {
            Graphics g = new DummyGraphics();
            try {
                getValue().paintIcon(label, g, 0, 0);
            } catch (Exception ex) {
                logger.log(Level.FINEST, null, ex);
                canPaint = false;
            } finally {
                label.setIcon(null);
            }
            initialised = true;
        }
        label.setBackground(Color.white);
        label.setText(canPaint ? null : "Icon: excption on paint()");
        label.setIcon(canPaint ? getValue() : null);
    }
    
}
