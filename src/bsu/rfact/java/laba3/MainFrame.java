package bsu.rfact.java.laba3;

import javax.swing.*;
import java.awt.*;

public  class  MainFrame extends Frame {

    private static final int WIDTH = 1000,
            HEIGHT = 500;
    private Double[] coefficients;
    private JFileChooser fileChooser = null;
    private JMenuItem saveToTextMenuItem,
            saveToGraphicsMenuItem,
            searchValueMenuItem;

    private JTextField textFieldFrom,
            textFieldTo,
            textFieldStep;
    private Box hBoxResult;
    private GornerTableCellRenderer renderer = new GornerTableCellRenderer();
    private GornerTableModel data;

    public MainFrame(Double[] coefficients){
        super("Tabulating a polynomial on a segment in 2 ways..");
        this.coefficients = coefficients;
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width - WIDTH) / 2,
                (kit.getScreenSize().height - HEIGHT) / 2);
        JMenuBar menuBar = new JMenuBar();
        JFrame frame = new JFrame();
        frame.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenu tablaMenu = new JMenu("Table");
        menuBar.add(tablaMenu);

    }

    public  static  void  main ( String [] args ) {

    }

}
