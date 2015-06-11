package datos;

/**Interfaz documento
	public String getArea();
	public int getCodigo ();
	public String getEspecialidad();
	public String getFormato ();
	public int getNumeroEjemplares ();
	public int getTipoPrestamo ();
	public void setArea(String area);
	public void setCodigoDocumento(int codigo);
	public void setEspecialidad(String especialidad);
	public void setFormato (String nuevoFormato);
	public void setNumeroEjemplares(int nuevoNumeroEjemplares);
	public void setTipoPrestamo (int nuevoTipo);		
 *
 */

public interface Documento {

	public String getArea();
	public int getCodigo ();
	public String getEspecialidad();
	public String getFormato ();
	public int getNumeroEjemplares ();
	public int getTipoPrestamo ();
	
	public void setArea(String area);
	public void setCodigo(int codigo);
	public void setEspecialidad(String especialidad);
	public void setFormato (String nuevoFormato);
	public void setNumeroEjemplares(int nuevoNumeroEjemplares);
	public void setTipoPrestamo (int nuevoTipo);
}
