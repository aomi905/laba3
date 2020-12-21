package bsu.rfact.java.laba3;

import javax.swing.table.AbstractTableModel;
import static java.lang.Math.*;

public class GornerTableModel extends AbstractTableModel {

    private Double[] coefficients;
    private Double from,
            to,
            step;

    public GornerTableModel(Double from, Double to, Double step,
                            Double[] coefficients){
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Double.class;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

        @Override
        public String getColumnName(int column) {
            switch (column){
                case 0:
                    return "X value";
                case 1:
                    return "Gorner polynomial value";
                case 2:
                    return "Power polynomial value";
                default:
                    return "Difference between 2 polynomial values";
            }
        }

        @Override
        public int getRowCount() {
            return new Double(Math.ceil((to - from) / step)).intValue() + 1;
        }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        double x = from + step * rowIndex;
        if (columnIndex == 0){
            return x;
        }
        if (columnIndex == 1){
            Double result = 0.;
            for (Double a : coefficients){
                result = result * x + a;
            }
            return result;
        }
        if (columnIndex == 2){
            Double result = 0.;
            for (Double a : coefficients){
                result += pow(x, a);
            }
            return result;
        }else{
            Double result1 = 0.,
                    result2 = 0.;
            for (Double a : coefficients){
                result1 = result1 * x + a;
            }
            for (Double a : coefficients){
                result2 += pow(x, a);
            }
            return result1 - result2;
        }
    }

}

