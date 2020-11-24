package bsu.rfact.java.laba3;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class MainFrame extends JFrame {
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
    private DecimalFormat formatter = (DecimalFormat)NumberFormat.getInstance();

    public MainFrame(Double[] coefficients){
        super("Tabulating a polynomial on a segment in 2 ways..");

        this.coefficients = coefficients;

        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width - WIDTH) / 2,
                (kit.getScreenSize().height - HEIGHT) / 2);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenu tableMenu = new JMenu("Table");
        menuBar.add(tableMenu);

        Action saveToTextAction = new AbstractAction("Save to text file") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fileChooser == null){
                    fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File("File_1.txt"));
                }
                if (fileChooser.showSaveDialog(MainFrame.this) ==
                        JFileChooser.APPROVE_OPTION){
                    saveToTextFile(fileChooser.getSelectedFile());
                }
            }
        };
        saveToTextMenuItem = fileMenu.add(saveToTextAction);
        saveToTextMenuItem.setEnabled(false);
    }

    public void saveToTextFile(File selectedFile) {
        try {
            FileWriter writer = new FileWriter(selectedFile);
            for (int i = 0; i < data.getColumnCount(); i++){
                writer.write(data.getColumnName(i));
                writer.append("\t|\t");
            }

            writer.append("\n---------   -------------------------   --------------" +
                    "-----------   -----------------------------------------\n");

            for (int i = 0; i < data.getRowCount(); i++){
                for (int j = 0; j < data.getColumnCount(); j++){
                    writer.write(String.valueOf(formatter.format(data.getValueAt(i,j))));
                    int a = formatter.format(data.getValueAt(i,j)).toString().length();
                    for (int l = 1; l < (25 - a); l++) {
                        writer.append(" ");
                    }
                }
                writer.append("\n");
            }
            writer.flush();
        }catch (IOException e){
            System.out.println("'File_1.txt' not found..");
        }
    }

    public static void main(String[] args) {

    }
}