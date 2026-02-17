package Libreria;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Libreria {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;  // Nombre Autor
    private JTextField textField2;  // Apellido Autor
    private JTextField textField3;  // Edad Autor
    private JTextField textField4;  // Correo Autor
    private JTextField textField5;  // Nombre Editorial
    private JTextField textField6;  // Direccion Editorial
    private JTextField textField7;  // Telefono Editorial
    private JTextField textField8;  // Correo Editorial
    private JTextField textField9;  // Nombre Libro
    private JSpinner spinner1;      // Cantidad Paginas
    private JComboBox comboBox1;    // Genero
    private JComboBox comboBox2;    // Autor
    private JComboBox comboBox3;    // Editorial
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
        guardarAutorButton.addActionListener(e -> guardarAutor());
        guardarEditorialButton.addActionListener(e -> guardarEditorial());
        guadarLibroButton.addActionListener(e -> guardarLibro());
        mostrarAutoresButton.addActionListener(e -> mostrarAutores());
        mostrarEditorialesButton.addActionListener(e -> mostrarEditoriales());
        mostrarLibrosButton.addActionListener(e -> mostrarLibros());
    }

    public void guardarAutor() {
        Autor autor = new Autor(textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText());
        autorList.add(autor);
        comboBox2.addItem(autor.getNombre());
        JOptionPane.showMessageDialog(null, "Autor guardado correctamente");
    }

    public void guardarEditorial() {
        Editorial editorial = new Editorial(textField5.getText(), textField6.getText(), textField7.getText(), textField8.getText());
        editorialList.add(editorial);
        comboBox3.addItem(editorial.getNombre());
        JOptionPane.showMessageDialog(null, "Editorial guardada correctamente");
    }

    public void guardarLibro() {
        int editorial = comboBox3.getSelectedIndex();
        int autor = comboBox2.getSelectedIndex();
        Libro libro = new Libro(textField9.getText(), (int)spinner1.getValue(), comboBox1.getSelectedItem().toString(), editorialList.get(editorial), autorList.get(autor));
        libroList.add(libro);
        JOptionPane.showMessageDialog(null, "Libro guardado correctamente");
    }

    void mostrarAutores() {
        for (Autor autor : autorList) {
            StringBuilder sb = new StringBuilder();
            sb.append("Autor\n");
            sb.append(autor.getNombre()).append("\n");
            sb.append(autor.getApellido()).append("\n");
            sb.append(autor.getEdad()).append("\n");
            sb.append(autor.getCorreo()).append("\n");
            JOptionPane.showMessageDialog(null, sb);
        }
    }

    void mostrarEditoriales() {
        for (Editorial editorial : editorialList) {
            StringBuilder sb = new StringBuilder();
            sb.append("Editorial\n");
            sb.append(editorial.getNombre()).append("\n");
            sb.append(editorial.getDireccion()).append("\n");
            sb.append(editorial.getTelefono()).append("\n");
            sb.append(editorial.getCorreo()).append("\n");
            JOptionPane.showMessageDialog(null, sb);
        }
    }

    void mostrarLibros() {
        for (Libro libro : libroList) {
            StringBuilder sb = new StringBuilder();
            sb.append("Libro\n");
            sb.append(libro.getNombre()).append("\n");
            sb.append("Páginas: ").append(libro.getCantPaginas()).append("\n");
            sb.append("Género: ").append(libro.getGenero()).append("\n");
            sb.append("Autor: ").append(libro.getAutor().getNombre()).append(" ").append(libro.getAutor().getApellido()).append("\n");
            sb.append("Editorial: ").append(libro.getEditorial().getNombre()).append("\n");
            JOptionPane.showMessageDialog(null, sb);
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
