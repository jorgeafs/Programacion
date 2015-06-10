package datos;


import java.time.*;

/**Interface Usuario
	public int getCodigo();
	public String getNombre ();
	public String getApellido1();
	public String getApellido2();
	public String getDni();
	public int getNumeroPrestamos();
	public int getNumeroMaximoPrestamos();
	public LocalDate getInicioSuspension();
	public int getPeriodoSuspension();

	public void setCodigoApoyo(int codigo);
	public void setNumeroPrestamos(int nMaxLibros);
	public void setNombre(String nombre);
	public void setApellido1(String apellido1);
	public void setApellido2(String apellido2);
	public void setDni(String dni);
	public void setInicioSuspension(LocalDate inicioSuspension);
	public int SetPeriodoSuspension();
 *  
 *
 */

public interface Usuario {
	public int getCodigo();
	public String getNombre ();
	public String getApellido1();
	public String getApellido2();
	public String getDni();
	public int getNumeroPrestamos();
	public int getNumeroMaximoPrestamos();
	public LocalDate getInicioSuspension();
	public int getPeriodoSuspension();

	public void setCodigoApoyo(int codigo);
	public void setNumeroPrestamos(int nMaxLibros);
	public void setNombre(String nombre);
	public void setApellido1(String apellido1);
	public void setApellido2(String apellido2);
	public void setDni(String dni);
	public void setInicioSuspension(LocalDate inicioSuspension);
	public void SetPeriodoSuspension(int periodoSuspension);
}
