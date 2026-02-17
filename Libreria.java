package Libreria;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Libreria {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JSpinner spinner1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton guadarLibroButton;
    private JButton mostrarLibrosButton;
    private JButton guardarAutorButton;
    private JButton mostrarAutoresButton;
    private JButton guardarEditorialButton;
    private JButton mostrarEditorialesButton;

    List<Autor> autorList = new ArrayList<>();
    List<Editorial> editorialList = new ArrayList<>();
    List<Libro> libroList = new ArrayList<>();

    public Libreria() {
        guardarAutorButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guardarAutor();
            }
        });
        guardarEditorialButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guardarEditorial();
            }
        });
        guadarLibroButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guardarLibro();
            }
        });
        mostrarAutoresButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarAutores();
            }
        });
    }

    public void guardarAutor()
    {
        Autor autor = new Autor(textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText());
        autorList.add(autor);
        JOptionPane.showMessageDialog(null, "Autor guardado correctamente");
        comboBox2.addItem(autor.getNombre());
    }

    public void guardarEditorial()
    {
        Editorial editorial = new Editorial(textField5.getText(),textField6.getText(),textField7.getText(),textField8.getText());
        editorialList.add(editorial);
        JOptionPane.showMessageDialog(null, "Editorial guardada correctamente");
        comboBox3.addItem(editorial.getNombre());
    }

    public void guardarLibro()
    {
        int editorial = comboBox3.getSelectedIndex();
        int autor = comboBox2.getSelectedIndex();

        Libro libro = new Libro(textField9.getText(),(int)spinner1.getValue(),comboBox1.getSelectedItem().toString(),editorialList.get(editorial),autorList.get(autor));
        libroList.add(libro);
        JOptionPane.showMessageDialog(null, "Libro guardado correctamente");
    }

    void mostrarAutores()
    {

        for (Autor autor: autorList)
        {
            StringBuilder sb = new StringBuilder();
            sb.append("Autor"+"\n");
            sb.append(autor.getNombre()+"\n");
            sb.append(autor.getApellido()+"\n");
            sb.append(autor.getEdad()+"\n");
            sb.append(autor.getCorreo()+"\n");
            JOptionPane.showMessageDialog(null,sb);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Libreria");
        frame.setContentPane(new Libreria().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
    }
}
