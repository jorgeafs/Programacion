package datos;



/**Interface:	
 * 	public int getCodigoAlumno();
 * 	public int getCodigoDocumento();
 * 	public LocalDate getDiaDelPrestamo();
 * 	public LocalDate getDiaDevolucion();
 * 	public long getDiasEnPrestamo();
 * 	public void setCodigoAlumno(int nuevoCodigoAlumno);
 * 	public void setCodigoDocumento(int nuevoCodigoDocumento);
 * 	public void setDiaDelPrestamo(LocalDate nuevoDiadelPrestamo);
 * 	public void setDiaDevolucion(LocalDate diaDvolucion);
 *
 */


import java.time.*;

public interface Prestamo {
	public int getCodigoUsuario();
	public int getCodigoDocumento();
	public LocalDate getDiaDelPrestamo();
	public LocalDate getDiaDevolucion();
	public long getDiasEnPrestamo();
	public void setCodigoUsuario(int nuevoCodigoAlumno);
	public void setCodigoDocumento(int nuevoCodigoDocumento);
	public void setDiaDelPrestamo(LocalDate nuevoDiadelPrestamo);
	public void setDiaDevolucion(LocalDate diaDvolucion);
}
