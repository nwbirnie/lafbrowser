/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.correlica.lafdefaults;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author inda
 */
class Presenter extends JPanel {

    private final JTable table;

    public Presenter(Model model) {
        this.table = new JTable(new ModelAdapter(model));
        table.setDefaultRenderer(Object.class, new CellRenderer());
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private static class ModelAdapter implements TableModel {

        private final Model model;

        private ModelAdapter(Model model) {
            this.model = model;
        }

        public int getRowCount() {
            return model.getItems().size();
        }

        public int getColumnCount() {
            return 2;
        }

        public String getColumnName(int i) {
            return i == 0 ? "Key" : "Value";
        }

        public Class<?> getColumnClass(int i) {
            return Item.class;
        }

        public boolean isCellEditable(int i, int i1) {
            return false;
        }

        public Object getValueAt(int row, int col) {
            return model.getItems().get(row);
        }

        public void setValueAt(Object o, int i, int i1) {
        }

        public void addTableModelListener(TableModelListener tl) {
        }

        public void removeTableModelListener(TableModelListener tl) {
        }
    }

    private static class CellRenderer extends JLabel implements TableCellRenderer {

        private static final int bwidth = 1;
        private static final Color bcolor = Color.blue;
        private static final Border selectedBorderLeft = BorderFactory.createMatteBorder(bwidth, bwidth, bwidth, 0, bcolor);
        private static final Border selectedBorderRight = BorderFactory.createMatteBorder(bwidth, 0, bwidth, bwidth, bcolor);
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (column == 0) {
                ((Item) value).renderKey(this);
                setBorder(table.isRowSelected(row) ? selectedBorderLeft : null);
            } else {
                ((Item) value).renderValue(this);
                setBorder(table.isRowSelected(row) ? selectedBorderRight : null);
            }
            return this;
        }
    }
}
