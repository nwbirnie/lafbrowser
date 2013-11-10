/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.correlica.lafdefaults;

import java.awt.Color;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.UIDefaults;

class ItemFactory {

    private static final Logger logger = Logger.getLogger(ItemFactory.class.getName());
    private UIDefaults defaults;

    //javax.swing.plaf.metal.MetalLookAndFeel.MetalLazyValue
    //sun.swing.SwingLazyValue
    //javax.swing.plaf.metal.MetalLookAndFeel.FontActiveValue
    //javax.swing.plaf.ColorUIResource
    Item create(Object key, Object value) {
        if (value instanceof UIDefaults.LazyValue) {
            Object realValue = ((UIDefaults.LazyValue) value).createValue(null);
            logger.info("lazy key=" + key + " value = " + realValue);
            return create(key, realValue);
        } else if (value instanceof Icon) {
            return new IconItem(key, (Icon) value);
        } else if (value instanceof Color) {
            return new ColorItem(key, (Color) value);
        } else {
            return new ObjectItem(key, value);
        }
    }
}
