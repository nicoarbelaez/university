package pointThree;

public class Libro {
	private String ISBN = "";
	private String titulo = "";
	private String autor = "";
	private int numeroDePagias = 0;
	
	public Libro(String ISBN, String titulo, String autor, int numeroDePagias) {
		setISBN(ISBN);
		setTitulo(titulo);
		setAutor(autor);
		setNumeroDePagias(numeroDePagias);
	}

	public String toString() {
		return "«El libro " + getTitulo() + " con ISBN " + getISBN() +" creado por el autor " + getTitulo() +" tiene " + getNumeroDePagias() +" páginas»";
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumeroDePagias() {
		return numeroDePagias;
	}

	public void setNumeroDePagias(int numeroDePagias) {
		this.numeroDePagias = numeroDePagias;
	}
	
	
}
