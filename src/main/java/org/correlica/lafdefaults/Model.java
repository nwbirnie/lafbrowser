/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.correlica.lafdefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import javax.swing.UIDefaults;

/**
 *
 * @author inda
 */
class Model {
    private static final ItemFactory factory = new ItemFactory();
    private final List<Item> items = new ArrayList<>();

    Model(UIDefaults defaults) {
        for (Entry<Object, Object> e : defaults.entrySet()) {
            items.add(factory.create(e.getKey(), e.getValue()));
        }
    }

    List<Item> getItems() {
        return items; 
    }
 
}
