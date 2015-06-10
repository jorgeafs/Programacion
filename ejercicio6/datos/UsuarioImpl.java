package datos;


import java.io.*;
import java.time.LocalDate;

/**Estudio Usuario
 * 	Propiedades:
 * 		codigo					--> básica, tipo entero
 * 									consultable --> si
 * 		nombre					--> básica, tipo cadena
 * 									consultable --> si
 * 									modificable --> si
 * 		apellido1				--> básica, tipo cadena
 * 									consultable --> si
 * 									modificable --> si
 * 		apellido2				--> básica, tipo cadena
 * 									consultable --> si
 * 									modificable --> si
 * 		dni						--> básica, tipo cadena
 * 									consultable --> si
 * 									modificable --> si
 * 		numeroPrestamos			--> básica, tipo entero
 * 									consultable --> si
 * 									modificable --> si
 * 		numeroMaximoPrestamos	--> básica, tipo entero
 * 									consultable --> si
 * 		periodoSuspension		--> básica, tipo entero
 * 									consultable --> si
 * 									modificable --> si
 * 		inicioSuspension		--> basica, tipo LocalDate
 * 									consultable --> si
 * 									modificable --> si
 * 	
 * 	Funcionalidades:
 * 		public boolean equals(UsuarioImpl seraIgual);
 * 		public int compareTo(UsuarioImpl comparar);
 * 		public String toString();
 * 		public String mostrar();
 */

public class UsuarioImpl implements Usuario, Serializable, Comparable<UsuarioImpl> {
	
	private static final long serialVersionUID = 1L;

	//Propiedad de clase
	private static int codigoApoyo = 0;
	
	//propiedades de instancia
	private int codigo;
	private	String nombre;
	private	String apellido1;
	private	String apellido2;
	private	String dni;
	private int numeroMaximoPrestamos;
	private int numeroPrestamos;
	private int periodoSuspension;
	private LocalDate inicioSuspension;
	
	//Constructor default
	public UsuarioImpl() {
		this.codigo = ++codigoApoyo;
		this.nombre = null;
		this.apellido1 = null;
		this.apellido2 = null;
		this.dni = null;
		this.numeroMaximoPrestamos = 0;
		this.numeroPrestamos = 0;
		this.periodoSuspension = 0;
		this.inicioSuspension = null;
	}
	//Constructor con parametros
	public UsuarioImpl( String nombre, String apellido1,
			String apellido2, String dni, int numeroMaximoPrestamos,
			int numeroPrestamos, LocalDate inicioSuspension, int periodoSuspension) {
		this.codigo = ++codigoApoyo;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.numeroMaximoPrestamos = numeroMaximoPrestamos;
		this.numeroPrestamos = numeroPrestamos;
		this.periodoSuspension = periodoSuspension;
		this.inicioSuspension = inicioSuspension;
	}
	//getters
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public String getDni() {
		return dni;
	}
	public int getNumeroMaximoPrestamos() {
		return numeroMaximoPrestamos;
	}
	public int getNumeroPrestamos() {
		return numeroPrestamos;
	}
	public LocalDate getInicioSuspension() {
		return inicioSuspension;
	}
	public int getPeriodoSuspension() {
		return this.periodoSuspension;
	}
	//setters
	public void setCodigoApoyo(int codigo) {
		UsuarioImpl.codigoApoyo = codigo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setNumeroPrestamos(int numeroPrestamos) {
		this.numeroPrestamos = numeroPrestamos;
	}
	public void setInicioSuspension(LocalDate inicioSuspension) {
		this.inicioSuspension = inicioSuspension;
	}
	public void SetPeriodoSuspension(int periodoSuspension) {
		this.periodoSuspension = periodoSuspension;
	}
	//metodos 
	
	//Criterio de igualdad --> por el codigo
	public boolean equals(UsuarioImpl seraIgual) {
		boolean igual = false;
		if (this.getCodigo() == seraIgual.getCodigo()) {
			igual = true;
		}
		return igual;
	}
	//Criterio de comparacion --> por el codigo
	@Override
	public int compareTo(UsuarioImpl comparar) {
		int devolver = 0;
		
		if(comparar.getCodigo() > this.getCodigo()){
			devolver = -1;
		} else if (comparar.getCodigo() < this.getCodigo()) {
			devolver = 1;
		}
		return devolver;
	}
	@Override
	public String toString() {
		return "("+this.getCodigo()+","+this.getNombre()+","+this.getApellido1()+","+this.getApellido2()+","+this.getDni()+
				","+this.getNumeroPrestamos()+","+this.getNumeroMaximoPrestamos()+","+this.getInicioSuspension()+","+this.getPeriodoSuspension()+")";
	}
	public String mostrar() {
		return "Codigo: "+this.getCodigo()+"\nNombre: "+this.getNombre()+"\nApellidos: "+this.getApellido1()+" "+this.getApellido2()+"\nDNI: "+this.getDni()+
				"\nNumero de documentos prestados: "+this.getNumeroPrestamos()+"\nNumero maximo de prestamos permitidos: "+this.getNumeroMaximoPrestamos()+
				"\nDia Inicio suspension: "+this.getInicioSuspension()+"\nPeriodo suspension: "+this.getPeriodoSuspension();
	}
}
