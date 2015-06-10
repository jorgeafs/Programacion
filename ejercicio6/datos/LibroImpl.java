package datos;


import java.time.*;

public class LibroImpl extends DocumentoImpl implements Libro {
	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private String autor;
	private String editorial;
	private LocalDate edicion;
	private int reimpresion;
	private long isbn;

	//constructor por defecto
	public LibroImpl() {
		super();
		this.titulo = null;
		this.autor = null;
		this.editorial = null;
		this.edicion = null;
		this.reimpresion = 0;
		this.isbn = 0;
	}

	//constructor con parametros
	public LibroImpl(String area, String especialidad,
						String formato, int numeroEjemplares, int tipoPrestamo,
						String titulo, String autor, String editorial,
						LocalDate edicion, int reimpresion, long isbn) {
		super( area,  especialidad, formato,  numeroEjemplares,  tipoPrestamo);
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.edicion = edicion;
		this.reimpresion = reimpresion;
		this.isbn = isbn;
	}

	public String getTitulo() {
		return this.titulo;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public String getEditorial() {
		return this.editorial;
	}
	
	public LocalDate getEdicion() {
		return this.edicion;
	}
	
	public int getReimpresion() {
		return this.reimpresion;
	}
	
	public long getIsbn() {
		return this.isbn;
	}
		
	public void setTitulo(String nuevoTitulo) {
		this.titulo = nuevoTitulo;
	}
	
	public void setAutor(String nuevoAutor) {
		this.autor = nuevoAutor;
	}
	
	public void setEditorial(String nuevaEditorial) {
		this.editorial = nuevaEditorial;
	}
	
	public void setEdicion(LocalDate nuevaEdicion) {
		this.edicion = nuevaEdicion;
	}
	
	public void setReimpresion(int nuevaReimpresion) {
		this.reimpresion = nuevaReimpresion;
	}
	
	public void setIsbn(long nuevoISBN) {
		this.isbn = nuevoISBN;
	}
	public String toString() {
		return super.toString().replaceAll("\\)", "")+";"+this.getTitulo()+";"+this.getAutor()+";"+this.getEditorial()+";"+this.getEdicion()+
				";"+this.getReimpresion()+";"+this.getIsbn()+")";
	}
	
	@Override
	public String mostrar() {
		return super.mostrar()+this.mostrarObjeto();
	}
	
	public String mostrarObjeto(){
		return "\nTitulo: "+this.getTitulo()+"\nAutor: "+this.getAutor()+"\nEditorial: "+this.getEditorial()+"\nEdicion: "+this.getEdicion()+
				"; Reimpresion: "+this.getReimpresion()+"\nISBN: "+this.getIsbn();
	}
	
}
