package bsu.rfact.java.laba3;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class GornerTableCellRenderer implements TableCellRenderer{

    private String needle = null;
    private JLabel label = new JLabel();
    private JPanel panel = new JPanel();
    private DecimalFormat formatter = (DecimalFormat)NumberFormat.getInstance();

    public GornerTableCellRenderer(){
        panel.add(label);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        formatter.setMaximumFractionDigits(5);
        formatter.setGroupingUsed(false);
        DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);
    }

    public void setNeedle(String needle) {
        this.needle = needle;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        String formattedDouble = formatter.format(value);
        label.setText(formattedDouble);
        if ((column == 1 || column == 2 || column == 3) && needle != null && needle.equals(formattedDouble)){
            panel.setBackground(Color.ORANGE);
        }else{
            panel.setBackground(Color.WHITE);
        }
        return panel;
    }

}
