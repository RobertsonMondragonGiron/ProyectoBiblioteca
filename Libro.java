package Libreria;

public class Libro {

    private String nombre;
    private int cantPaginas;
    private String genero;
    private Editorial editorial;
    private Autor autor;

    public Libro(String nombre, int cantPaginas, String genero, Editorial editorial, Autor autor) {
        this.nombre = nombre;
        this.cantPaginas = cantPaginas;
        this.genero = genero;
        this.editorial = editorial;
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
