package datos;


import java.time.LocalDate;

public interface Libro {
	public String getTitulo ();
	public String getAutor ();
	public String getEditorial ();
	public LocalDate getEdicion ();
	public int getReimpresion ();
	public long getIsbn ();
	public void setTitulo (String nuevoTitulo);
	public void setAutor (String nuevoAutor);
	public void setEditorial (String nuevaEditorial);
	public void setEdicion (LocalDate nuevaEdicion);
	public void setReimpresion (int nuevaReimpresion);
	public void setIsbn (long nuevoIsbn);	
}
