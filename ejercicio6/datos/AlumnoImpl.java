package datos;


import java.time.*;



/**Estudio Interfaz
 * 	Propiedades:
 * 		carrera-->Básica, tipo String, modificable y consultable
 * 
 * Interface:
 * 	public String getCarrera();
 * 	public void setCarrera(String nuevaCarrera);
 *
 */


public class AlumnoImpl extends UsuarioImpl implements Alumno{
	private static final long serialVersionUID = 1L;
	private String carrera;
	
	public AlumnoImpl() {
		super();
		this.carrera = null;
	}
	public AlumnoImpl(String nombre, String apellido1,
			String apellido2, String dni, int numeroMaximoPrestamos,
			int numeroPrestamos, LocalDate inicioSuspension, int periodoSuspension, String carrera) {
		super(nombre, apellido1, apellido2, dni, numeroMaximoPrestamos, numeroPrestamos, inicioSuspension,periodoSuspension);
		this.carrera = carrera;
	}
	//get
	public String getCarrera(){
		return this.carrera;
	}
	//set
	public void setCarrera(String nuevaCarrera) {
		this.carrera = nuevaCarrera;
	}
	@Override
	public String toString (){
		return /*super.toString().replaceAll("\\)","")*/"("+this.getCodigo()+","+this.getNombre()+","+this.getApellido1()+","+this.getApellido2()+","+this.getDni()+
				","+this.getNumeroPrestamos()+","+this.getNumeroMaximoPrestamos()+","+this.getInicioSuspension()+","+this.getPeriodoSuspension()+","+this.getCarrera()+")";
	}
	@Override//muestra todo los datos del alumno.
	public String mostrar() {
		return "Codigo: "+this.getCodigo()+"\nNombre: "+this.getNombre()+"\nApellidos: "+this.getApellido1()+" "+this.getApellido2()+"\nDNI: "+this.getDni()+
				"\nNumero de documentos prestados: "+this.getNumeroPrestamos()+"\nNumero maximo de prestamos permitidos: "+this.getNumeroMaximoPrestamos()+
				"\nDia Inicio suspension: "+this.getInicioSuspension()+"\nPeriodo suspension: "+this.getPeriodoSuspension()+"\nCarrera: "+this.getCarrera();
	}
	
}
