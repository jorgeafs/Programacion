package datos;

/**Estudio Prestamo
 * 	Propiedades:
 * 		codigoAlumno-->Básica, tipo String, modificable y consultable
 * 		codigoDocumento --> Básica, tipo cadena caracteres, modifacable y consultable
 * 		diaDelPrestamo --> Básica, tipo LocalDate, modificable y consultable
 * 		diaDevolucion --> Basica, tipo LocalDate, modificable y consutable
 * 		diasEnPrestamo --> derivado, tipo entero, consultable
 * 	
 * 	Funcionalidades:
 * 		public boolean equals(PrestamoImpl seraIgual);
 * 		public String toString();
 * 		public String mostrar();
 *
 */
import java.io.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class PrestamoImpl implements Prestamo, Serializable, Comparable <PrestamoImpl> {
	private static final long serialVersionUID = 20L;
	private int codigoUsuario;
	private int codigoDocumento;
	private LocalDate diaDelPrestamo;
	private LocalDate diaDevolucion;
	
	public PrestamoImpl(){
		this.codigoUsuario = 0;
		this.codigoDocumento = 0;
		this.diaDelPrestamo = null;
		this.diaDevolucion = null;
	}
	
	public PrestamoImpl(int nuevoCodigoUsuario, int nuevoCodigoDocumento) {
		this.codigoUsuario = nuevoCodigoUsuario;
		this.codigoDocumento = nuevoCodigoDocumento;
		this.diaDelPrestamo = LocalDate.now();
		this.diaDevolucion = null;
	}

	public int getCodigoUsuario(){
		return this.codigoUsuario;
	}
	public int getCodigoDocumento(){
		return this.codigoDocumento;
	}
	public LocalDate getDiaDelPrestamo(){
		return this.diaDelPrestamo;
	}
	public long getDiasEnPrestamo(){//cambiar para tener en cuenta cuando el prestamo ya ha concluido
		long diasEnPrestamo=0;
		if(this.diaDevolucion == null){
			LocalDate hoy = LocalDate.now();
			diasEnPrestamo = ChronoUnit.DAYS.between(this.diaDelPrestamo,hoy);
		} else {
			diasEnPrestamo = ChronoUnit.DAYS.between(this.diaDelPrestamo,this.diaDevolucion);
		}
		
		return diasEnPrestamo;
	}
	public LocalDate getDiaDevolucion() {
		return this.diaDevolucion;
	}
	public void setCodigoUsuario(int nuevoCodigoUsuario){
		this.codigoUsuario = nuevoCodigoUsuario;
	}
	public void setCodigoDocumento(int nuevoCodigoDocumento){
		this.codigoDocumento = nuevoCodigoDocumento;
	}
	public void setDiaDelPrestamo(LocalDate nuevoDiadelPrestamo){
		this.diaDelPrestamo = nuevoDiadelPrestamo;
	}
	public void setDiaDevolucion(LocalDate diaDevolucion) {
		this.diaDevolucion = diaDevolucion;
	}
	//Metodos
	
	//Criterio de igualdad-->  codigoUsuario codigoDocumento y diaDelprestamo son iguales
	@Override
	public boolean equals(Object o) {
		boolean igual = false;
		PrestamoImpl aux = null;
		
		if(o != null && o instanceof PrestamoImpl) {
			aux = (PrestamoImpl) o;
			if(this.getCodigoUsuario() == aux.getCodigoUsuario() && this.getCodigoDocumento() 
					== aux.getCodigoDocumento() && this.getDiaDelPrestamo().isEqual(aux.getDiaDelPrestamo())){
				igual = true;
			}
		}
		return igual;
	}
	//criterio de comparacion: sigue el criterio de igualdad, devolvera 0 si es exactamente el mismo objeto, -1 si this es menor en cualquiera de sus campos y 1 si es mayor en cualquiera de sus campos
	//la prioridad en la comparacion es codigoAlumno, codigoDocumento, diaDelPrestamo y diaDevolucion.
	public int compareTo(PrestamoImpl aComparar) {
		int compara = 0;
		if ((this.getCodigoUsuario() < aComparar.getCodigoUsuario())||
			(this.getCodigoUsuario() == aComparar.getCodigoUsuario()&& this.getCodigoDocumento() < aComparar.getCodigoDocumento())||
			(this.getCodigoUsuario() == aComparar.getCodigoUsuario()&& this.getCodigoDocumento() == aComparar.getCodigoDocumento()&& this.getDiaDelPrestamo().isBefore(aComparar.getDiaDelPrestamo()))) {
			compara = -1;
		}	else if ((this.getCodigoUsuario() > aComparar.getCodigoUsuario())||
				(this.getCodigoUsuario() == aComparar.getCodigoUsuario()&& this.getCodigoDocumento() > aComparar.getCodigoDocumento()) ||
				(this.getCodigoUsuario() == aComparar.getCodigoUsuario()&& this.getCodigoDocumento() == aComparar.getCodigoDocumento()&&this.getDiaDelPrestamo().isAfter(aComparar.getDiaDelPrestamo()))) {
			compara = 1;
		}
			
		return compara;
	}
	public String toString() {
		return "("+this.getCodigoUsuario()+","+this.getCodigoDocumento()+","+this.getDiaDelPrestamo()+","+this.getDiaDevolucion()+","+this.getDiasEnPrestamo()+")";
	}
	public String mostrar() {
		 return "Codigo del Alumno: "+this.getCodigoUsuario()+"\nCodigo del documento: "+this.getCodigoDocumento()+
				 "\nDia inicio del prestamo: "+this.getDiaDelPrestamo()+"\nDia de la devolucion: "+this.getDiaDevolucion()
				 +"\nDias prestado: "+this.getDiasEnPrestamo();
	 }
}
