package gestion;
/** Funcionalidades:
 * 		Publicas:
 * 			public ArrayList<AlumnoImpl> alumnosDevPendientes (String rutaAlu)
 * 			public ArrayList<LibroImpl> libroMasPrestado(String rutaLibros)
 * 			public ArrayList<LibroImpl> libroMasPrestadoHistorico(String rutaLibros) 
 * 			public ArrayList<LibroImpl> libroMasPrestadoSituacion(String rutaLibros)
 * 			public ArrayList<String> especialidadMasConsultada(String rutaLibros) 
 * 			public ArrayList<String> especialidadMasConsultadaHistorico()
 * 			public ArrayList<String> especialidadMasConsultadaSituacion()
 * 			public ArrayList<PrestamoImpl> realizarPrestamo(ArrayList<PrestamoImpl> aInsertar, String rutaUsuarioSubClase, String rutaDocumentoSubClase) 
 * 			public boolean devolverPrestamo(ArrayList<PrestamoImpl> aDevolver, String rutaUsuarioSubClase, String rutaDocumentoSubClase)
 * 			public int identificarAlumno(String nombre, String apellido1, String apellido2, String rutaUsuarioSubClase)
 * 			public boolean listarLibrosDisponibles(String rutaDocumentoSubClase)
 * 		Privadas:
 * 			private ArrayList<T> eliminarRepetidos(ArrayList<T> elimina)
 * 			private void actualizarNumeroPrestamos(UsuarioImpl usu, int size, String rutaUsuarioSubClase)
 * 			private boolean sePuedePrestar(int codigoDocumento, String rutaDocumentoSubClase)
 * 			private boolean cumpleRestriccion(int codigoUsuario, String rutaUsuarioSubClase)
 * 			private boolean quedanEjemplares(int codigoDocumento, String rutaDocumentoSubClase)
 * 			private boolean noPenalizado(int codigoUsuario, String rutaUsuarioSubClase)
 * 			private boolean esUnicoUsuario(ArrayList<PrestamoImpl> aInsertar)
 * 			private void penalizar(ArrayList<PrestamoImpl> aDevolver, String rutaUsuarioSubClase, String rutaDocumentoSubClase)
 * 			private int multiplicadorTipoPrestamo(PrestamoImpl prestamoImpl, String rutaDocumentoSubClase)
 * 			private int diasRetraso(PrestamoImpl prestamoImpl, String rutaDocumentoSubClase)
 * 			private boolean modificar(ArrayList<PrestamoImpl> aModificar)
 * 			private boolean fueraPlazo(PrestamoImpl aDevolver, String rutaDocumentoSubClase)
 * 			private void pulseCualquierTeclaParaContinuar()
 */

import java.io.*;
import java.time.*;
import java.util.*;

import datos.*;
import utilidad.UtilFileGen;

public class GestionPrestamos <T> {
	
	/**Interfaz: alumnosDevPendientes
	 * Cabecera: public ArrayList<AlumnoImpl> alumnosDevPendientes (String ruta) 
	 * Comentario: Dada una ruta al fichero de alumnos, devuelve un Arraylist con los alumnos con devoluciones pendientes. Devolvera null en caso de error
	 * Precondiciones: ninguna
	 * Entradas: un String
	 * Salidas: un ArrayList 
	 * Postcondiciones: Devuelve un Arraylist con los alumnos con devoluciones pendientes. Devolvera null en caso de error.
	 */
	public ArrayList<AlumnoImpl> alumnosDevPendientes (String rutaAlu) {
		ArrayList<Object> aux = null;
		ArrayList<AlumnoImpl> devolver = null, auxAlu = new ArrayList<AlumnoImpl>();
		ArrayList<PrestamoImpl> compara = null;
		
		aux = new UtilFileGen<Object>().leerFicheroBinario(rutaAlu);
		if (!aux.isEmpty() && aux.get(0) instanceof AlumnoImpl) {
			for(int i = 0; i<aux.size();i++) {
				auxAlu.add((AlumnoImpl) aux.get(i));
			}
			compara = new UtilFileGen<PrestamoImpl>().leerFicheroBinario(Constantes.PRESTAMOSITUACION);
			for(int i = 0; i<compara.size();i++) {
				for(int j = 0; j < auxAlu.size(); j++) {
					if(devolver == null && compara.get(i).getCodigoUsuario() == auxAlu.get(j).getCodigo()) {
						devolver = new ArrayList<AlumnoImpl>();
						devolver.add(auxAlu.get(j));
					} else if (compara.get(i).getCodigoUsuario() == auxAlu.get(j).getCodigo()) {
						devolver.add(auxAlu.get(j));
					}
				}
			}
			devolver = new GestionPrestamos<AlumnoImpl>().eliminarRepetidos(devolver);
		}
		
		return devolver;
	}
	
	/**Interfaz: eliminarRepetidos
	 * Cabecera: private ArrayList<T> eliminarRepetidos(ArrayList<T> elimina)
	 * Comentario: Dado un ArrayList generico, devuelve un ArrayList generico sin elementos repetidos
	 * Precondiciones: ninguna
	 * Entradas: un ArrayList
	 * Salidas: un ArrayList 
	 * Postcondiciones: Devuelve un ArrayList, en caso de estar vacio devuelve el ArrayList a null
	 */
	private ArrayList<T> eliminarRepetidos(ArrayList<T> elimina) {
		if(!elimina.isEmpty()) {
			for (int i = 0 ; i < elimina.size()-1 ; i++) {
				for(int j = elimina.size()-1 ; j > i ; j--) {
					if(elimina.get(j) == elimina.get(j-1)){
						elimina.remove(j-1);
					}
				}
			}
			elimina.trimToSize();
		} else {
			elimina = null;
		}
		return elimina;
	}
	
	/**Interfaz: libroMasPrestado
	 * Cabecera: public ArrayList<LibroImpl> libroMasPrestado(String rutaLibros)
	 * Comentario: Dada la ruta al fichero de libros, devuelve un ArrayList con los libros mas prestados. Devolvera null en caso de error.
	 * Precondiciones: ninguna
	 * Entradas: un String
	 * Salidas: un ArrayList
	 * Postcondiciones: Devuelve un ArrayList con los libros mas prestados, devolvera null en caso de error.
	 */
	public ArrayList<LibroImpl> libroMasPrestado(String rutaLibros) {
		ArrayList<LibroImpl> devolver = null, situacion = new ArrayList<LibroImpl>(), historico = new ArrayList<LibroImpl>();
		
		situacion = new GestionPrestamos<LibroImpl>().libroMasPrestadoSituacion(rutaLibros);		
		historico = new GestionPrestamos<LibroImpl>().libroMasPrestadoHistorico(rutaLibros);
		if (!situacion.isEmpty()) {
			devolver = new ArrayList<LibroImpl>();
			devolver.addAll(situacion);
		}
		if(!historico.isEmpty() && devolver != null) {
			devolver.addAll(historico);
		} else if (!historico.isEmpty() && devolver == null){
			devolver = new ArrayList<LibroImpl>();
			devolver.addAll(historico);
		}
		if (!devolver.isEmpty()){
			devolver = new GestionPrestamos<LibroImpl>().eliminarRepetidos(devolver);
		}
		return devolver;
	}
	
	/**Interfaz: libroMasPrestadoHistorico
	 * Cabecera: public ArrayList<LibroImpl> libroMasPrestadoHistorico(String rutaLibros)
	 * Comentario: Dada la ruta al fichero de libros, devuelve un ArrayList con los libros, del prestamo historico, mas prestados. Devolvera null en caso de error.
	 * Precondiciones: ninguna
	 * Entradas: un String
	 * Salidas: un ArrayList
	 * Postcondiciones: Devuelve un ArrayList con los libros, del prestamo historico, mas prestados, devolvera null en caso de error.
	 */
	public ArrayList<LibroImpl> libroMasPrestadoHistorico(String rutaLibros) {
		ArrayList<Object> aux = new UtilFileGen<Object>().leerFicheroBinario(rutaLibros);
		ArrayList<PrestamoImpl> auxPrest = new UtilFileGen<PrestamoImpl>().leerFicheroBinario(Constantes.PRESTAMOHSITORICO);
		ArrayList<LibroImpl> devolver = null; 
		int contador = 0;
		
		if(!auxPrest.isEmpty() && !aux.isEmpty() && aux.get(0) instanceof LibroImpl) {
			devolver = new ArrayList<LibroImpl>();
			contador = Collections.frequency(auxPrest, auxPrest.get(0));
			devolver.add(new UtilFileGen<LibroImpl>().busqueda(auxPrest.get(0).toString(), rutaLibros).get(0));
			for(int i=1 ; i < auxPrest.size(); i++) {
				if(contador == Collections.frequency(auxPrest, auxPrest.get(i))) {
					devolver.add(new UtilFileGen<LibroImpl>().busqueda(auxPrest.get(0).toString(), rutaLibros).get(i));
				} else if (contador < Collections.frequency(auxPrest, auxPrest.get(i))) {
					devolver.removeAll(devolver);
					devolver.add(new UtilFileGen<LibroImpl>().busqueda(auxPrest.get(0).toString(), rutaLibros).get(i));
					contador = Collections.frequency(auxPrest, auxPrest.get(i));
				}
			}
			devolver = new GestionPrestamos<LibroImpl>().eliminarRepetidos(devolver);
		}
		return devolver;
	}
	
	/**Interfaz: libroMasPrestadoSituacion
	 * Cabecera: public ArrayList<LibroImpl> libroMasPrestadoSituacion(String rutaLibros)
	 * Comentario: Dada la ruta al fichero de libros, devuelve un ArrayList con los libros, del prestamo situacion, mas prestados. Devolvera null en caso de error.
	 * Precondiciones: ninguna
	 * Entradas: un String
	 * Salidas: un ArrayList
	 * Postcondiciones: Devuelve un ArrayList con los libros, del prestamo situacion, mas prestados, devolvera null en caso de error.
	 */
	public ArrayList<LibroImpl> libroMasPrestadoSituacion(String rutaLibros) {
		ArrayList<Object> aux = new UtilFileGen<Object>().leerFicheroBinario(rutaLibros);
		ArrayList<PrestamoImpl> auxPrest = new UtilFileGen<PrestamoImpl>().leerFicheroBinario(Constantes.PRESTAMOSITUACION);
		ArrayList<LibroImpl> devolver = null; 
		int contador = 0;
		
		if(!auxPrest.isEmpty() && !aux.isEmpty() && aux.get(0) instanceof LibroImpl) {
			devolver = new ArrayList<LibroImpl>();
			contador = Collections.frequency(auxPrest, auxPrest.get(0));
			devolver.add(new UtilFileGen<LibroImpl>().busqueda(auxPrest.get(0).toString(), rutaLibros).get(0));
			for(int i=1 ; i < auxPrest.size(); i++) {
				if(contador == Collections.frequency(auxPrest, auxPrest.get(i))) {
					devolver.add(new UtilFileGen<LibroImpl>().busqueda(auxPrest.get(0).toString(), rutaLibros).get(i));
				} else if (contador < Collections.frequency(auxPrest, auxPrest.get(i))) {
					devolver.removeAll(devolver);
					devolver.add(new UtilFileGen<LibroImpl>().busqueda(auxPrest.get(0).toString(), rutaLibros).get(i));
					contador = Collections.frequency(auxPrest, auxPrest.get(i));
				}
			}
			devolver = new GestionPrestamos<LibroImpl>().eliminarRepetidos(devolver);
		}
		return devolver;
	}
	
	/**Interfaz: especialidadMasConsultada
	 * Cabecera: public ArrayList<String> especialidadMasConsultada(String rutaLibros)
	 * Comentario: Dada la ruta al fichero de libros, devuelve un ArrayList con las especialidades mas consultados. Devolvera null en caso de error.
	 * Precondiciones: ninguna
	 * Entradas: un String
	 * Salidas: un ArrayList
	 * Postcondiciones: Devuelve un ArrayList con las especialidades mas consultados, devolvera null en caso de error.
	 */
	public ArrayList<String> especialidadMasConsultada(String rutaLibros) {
		ArrayList<String> devolver = null, situacion = new ArrayList<String>(), historico = new ArrayList<String>();
		
		situacion = new GestionPrestamos<String>().especialidadMasConsultadaSituacion();		
		historico = new GestionPrestamos<String>().especialidadMasConsultadaHistorico();
		if (!situacion.isEmpty()) {
			devolver = new ArrayList<String>();
			devolver.addAll(situacion);
		}
		if(!historico.isEmpty() && devolver != null) {
			devolver.addAll(historico);
		} else if (!historico.isEmpty() && devolver == null){
			devolver = new ArrayList<String>();
			devolver.addAll(historico);
		}
		if (!devolver.isEmpty()){
			devolver = new GestionPrestamos<String>().eliminarRepetidos(devolver);
		}
		return devolver;
	}
	
	/**Interfaz: especialidadMasConsultadaHistorico
	 * Cabecera: public ArrayList<String> especialidadMasConsultadaHistorico()
	 * Comentario: Dada la ruta al fichero de libros, devuelve un ArrayList con las especialidades mas consultados, del prestamo historico. Devolvera null en caso de error.
	 * Precondiciones: ninguna
	 * Entradas: un String
	 * Salidas: un ArrayList
	 * Postcondiciones: Devuelve un ArrayList con las especialidades mas consultados, del prestamo historico. Devolvera null en caso de error.
	 */
	public ArrayList<String> especialidadMasConsultadaHistorico() {
		ArrayList<String> devolver = null;
		ArrayList<PrestamoImpl> auxPrest  = new UtilFileGen<PrestamoImpl>().leerFicheroBinario(Constantes.PRESTAMOHSITORICO);
		int contador = 0;
		
		if(!auxPrest.isEmpty()) {
			devolver = new ArrayList<String>();
			devolver.add(auxPrest.get(0).getEspecialidad());
			contador = Collections.frequency(auxPrest, auxPrest.get(0));
			for(int i=1 ; i < auxPrest.size(); i++) {
				if(contador == Collections.frequency(auxPrest, auxPrest.get(i))) {
					devolver.add(auxPrest.get(0).getEspecialidad());
				} else if (contador < Collections.frequency(auxPrest, auxPrest.get(i))) {
					devolver.removeAll(devolver);
					devolver.add(auxPrest.get(0).getEspecialidad());
					contador = Collections.frequency(auxPrest, auxPrest.get(i));
				}
			}
			devolver = new GestionPrestamos<String>().eliminarRepetidos(devolver);
		}
		return devolver;
	}
	
	/**Interfaz: especialidadMasConsultadaSituacion
	 * Cabecera: public ArrayList<String> especialidadMasConsultadaSituacion()
	 * Comentario: Dada la ruta al fichero de libros, devuelve un ArrayList con las especialidades mas consultados, del prestamo situacion. Devolvera null en caso de error.
	 * Precondiciones: ninguna
	 * Entradas: un String
	 * Salidas: un ArrayList
	 * Postcondiciones: Devuelve un ArrayList con las especialidades mas consultados, del prestamo situacion. Devolvera null en caso de error.
	 */
	public ArrayList<String> especialidadMasConsultadaSituacion() {
		ArrayList<String> devolver = null;
		ArrayList<PrestamoImpl> auxPrest  = new UtilFileGen<PrestamoImpl>().leerFicheroBinario(Constantes.PRESTAMOSITUACION);
		int contador = 0;
		
		if(!auxPrest.isEmpty()) {
			devolver = new ArrayList<String>();
			devolver.add(auxPrest.get(0).getEspecialidad());
			contador = Collections.frequency(auxPrest, auxPrest.get(0));
			for(int i=1 ; i < auxPrest.size(); i++) {
				if(contador == Collections.frequency(auxPrest, auxPrest.get(i))) {
					devolver.add(auxPrest.get(0).getEspecialidad());
				} else if (contador < Collections.frequency(auxPrest, auxPrest.get(i))) {
					devolver.removeAll(devolver);
					devolver.add(auxPrest.get(0).getEspecialidad());
					contador = Collections.frequency(auxPrest, auxPrest.get(i));
				}
			}
			devolver = new GestionPrestamos<String>().eliminarRepetidos(devolver);
		}
		return devolver;
	}
	
	/**Interfaz: realizarPrestamo
	 * Cabecera: public ArrayList<PrestamoImpl> realizarPrestamo(ArrayList<PrestamoImpl> aInsertar, String rutaUsuarioSubClase, String rutaLibros)
	 * Comentario: Dado un ArrayList con prestamos a realizar de un mismo usuario, y la rutas al fichero de usuarioSubClase y al documentoSubClase; 
	 * 			   devuelve un ArrayList a vacio si se pudieron prestar todos, o con los que no se pudieron prestar porque no estan disponibles, o 
	 * 			   los devuelve todos si el usuario sobrepasaba el numero maximo de prestamos o en caso de error.  			    			   
	 * Precondiciones: ninguna
	 * Entradas: un ArrayList, dos String
	 * Salidas: un ArrayList
	 * Postcondiciones: Devuelve un ArrayList a vacio si se pudieron prestar todos, o con los que no se pudieron prestar porque no estan disponibles, o los devuelve todos
	 * 					si el usuario sobrepasaba el numero maximo de prestamos o en caso de error.  			    			    
	 */
	public ArrayList<PrestamoImpl> realizarPrestamo(ArrayList<PrestamoImpl> aInsertar, String rutaUsuarioSubClase, String rutaDocumentoSubClase) {
		ArrayList<PrestamoImpl> devolver = new ArrayList<PrestamoImpl>(), auxiliar = new ArrayList<PrestamoImpl>();
		UsuarioImpl aux = new UsuarioImpl();
		UtilFileGen<UsuarioImpl> auxUsu = new UtilFileGen<UsuarioImpl>();
		
		devolver.addAll(aInsertar);
		if(aInsertar != null && !aInsertar.isEmpty() && esUnicoUsuario(aInsertar) && noPenalizado(aInsertar.get(0).getCodigoUsuario(),rutaUsuarioSubClase) 
				&& cumpleRestriccion(aInsertar.get(0).getCodigoUsuario(),rutaUsuarioSubClase)) {
			for(int i = 0; i<aInsertar.size(); i++) {
				if(sePuedePrestar(aInsertar.get(i).getCodigoDocumento(), rutaDocumentoSubClase) && 
						quedanEjemplares(aInsertar.get(i).getCodigoDocumento(), rutaDocumentoSubClase)){
					auxiliar.add(aInsertar.get(i));
				}
			}
			aux = auxUsu.busqueda(aux.toString(), rutaUsuarioSubClase).get(0);
			if(!auxiliar.isEmpty() && (aux.getNumeroMaximoPrestamos()>(aux.getNumeroPrestamos()+auxiliar.size()))) { 
				devolver.remove(auxiliar);
				actualizarNumeroPrestamos(aux, auxiliar.size(), rutaUsuarioSubClase);
				modificar(auxiliar);
			}
		}
		return devolver;
	}

	/**Interfaz: actualizarNumeroPrestamos
	 * Cabecera: private void actualizarNumeroPrestamos(UsuarioImpl aux, int size, String rutaUsuarioSubClase)
	 * Comentario: Dado un UsuarioImpl y la ruta al fichero de UsuarioSubClase, se actualiza el campo numeroPrestamos del UsuarioImpl
	 * Precondiciones: ninguna
	 * Entradas: un UsuarioImpl, un int y un String
	 * Salidas: ninguna
	 * Postcondiciones: ninguna
	 */	
	private void actualizarNumeroPrestamos(UsuarioImpl usu, int size, String rutaUsuarioSubClase) {
		UtilFileGen<UsuarioImpl> aux = new UtilFileGen<UsuarioImpl>();
		String codigo = "("+usu.getCodigo();
		ArrayList <UsuarioImpl> auxAlum = new UtilFileGen<UsuarioImpl>().busqueda(codigo, rutaUsuarioSubClase);
		auxAlum.remove(usu);
		usu.setNumeroPrestamos(size);
		auxAlum.add(usu);
		aux.borrarFicheroBinario(rutaUsuarioSubClase);
		aux.crearFicheroBinario(rutaUsuarioSubClase);
	}

	/**Interfaz: sePuedePrestar
	 * Cabecera: private boolean sePuedePrestar(int codigoDocumento, String rutaDocumentoSubClase)
	 * Comentario: Dado un codigo de documento y la ruta al fichero de UsuarioSubClase, se comprueba que se pueda presta; devuelve true si se puede y false en caso contrario
	 * 			   o en caso de error
	 * Precondiciones: ninguna
	 * Entradas: un int y un String
	 * Salidas: un boolean
	 * Postcondiciones: Devuelve true si se puede y false en caso contrario o en caso de error
	 */	
	private boolean sePuedePrestar(int codigoDocumento, String rutaDocumentoSubClase) {
		boolean devolver = false;
		String codigo = "("+codigoDocumento;
		DocumentoImpl aux = new UtilFileGen<DocumentoImpl>().busqueda(codigo, rutaDocumentoSubClase).get(0);
		
		if(aux != null && aux.getTipoPrestamo() > 0) {
			devolver = true;
		}
		return devolver;
	}

	/**Interfaz: cumpleRestriccion
	 * Cabecera: private boolean cumpleRestriccion(int codigoUsuario, String rutaUsuarioSubClase) 
	 * Comentario: Dado un codigo de usuario y la ruta al fichero de UsuarioSubClase, se comprueba que cumpla la restriccion de libros prestados; devuelve true si las cumple
	 * 			   false en caso contrario o en caso de error
	 * Precondiciones: ninguna
	 * Entradas: un int y un String
	 * Salidas: un boolean
	 * Postcondiciones: Devuelve true si cumple la restriccion de libros y false en caso contrario o de error
	 */
	private boolean cumpleRestriccion(int codigoUsuario, String rutaUsuarioSubClase) {
		boolean devolver = false;
		String codigo = "("+codigoUsuario;
		UsuarioImpl aux = new UsuarioImpl();
		ArrayList<Object> apoyo = new UtilFileGen<Object>().busqueda(codigo, rutaUsuarioSubClase);
		
		if(apoyo!= null && apoyo.size() == 1 && apoyo.get(0) instanceof UsuarioImpl){
			aux = (UsuarioImpl) apoyo.get(0);
			if(aux.getNumeroPrestamos()<aux.getNumeroMaximoPrestamos()) {
				devolver = true;
			}
		}
		return devolver;
	}

	/**Interfaz: quedanEjemplares
	 * Cabecera: private boolean quedanEjemplares(int codigoDocumento, String rutaDocumentoSubClase) 
	 * Comentario: Dado un codigoDocumento y la ruta al fichero de documentos, devuelve true si quedan ejemplares accesibles y false en caso contrario o de error
	 * Precondiciones: ninguna
	 * Entradas: un int y un String
	 * Salidas: un boolean
	 * Postcondiciones: Devuelve true si quedan ejemplares accesibles y false en caso contrario o de error
	 */
	private boolean quedanEjemplares(int codigoDocumento, String rutaDocumentoSubClase) {
		boolean devolver = false;
		String codigo = "("+codigoDocumento;
		LibroImpl consultado = new UtilFileGen<LibroImpl>().busqueda(codigo, rutaDocumentoSubClase).get(0);
		int contadorEjemplares = new UtilFileGen<PrestamoImpl>().busqueda(codigo,Constantes.PRESTAMOSITUACION).size();
		
		if(consultado != null && consultado.getNumeroEjemplares()>contadorEjemplares) {
			devolver = true;
		}
		return devolver;
	}
	
	/**Interfaz: noPenalizado
	 * Cabecera: private boolean noPenalizado(int codigoUsuario, String rutaUsuarioSubClase)
	 * Comentario: Dado un codigoUsuario y la ruta al fichero de usuarioSubclase, devuelve true si el usuario no esta penalizado y false en caso contrario o de error
	 * Precondiciones: ninguna
	 * Entradas: un int y un String
	 * Salidas: un boolean
	 * Postcondiciones: Devuelve true si el usuario no esta penalizado y false en caso contrario o de error
	 */
	private boolean noPenalizado(int codigoUsuario, String rutaUsuarioSubClase) {
		boolean devolver = false;
		String codigo = "("+codigoUsuario;
		ArrayList<Object> auxAlu = new UtilFileGen<Object>().busqueda(codigo, rutaUsuarioSubClase);
		LocalDate hoy = LocalDate.now();
		UsuarioImpl apoyo = new UsuarioImpl();
		
		if(auxAlu != null && auxAlu.size()==1 && auxAlu.get(0) instanceof UsuarioImpl) {
			apoyo=(UsuarioImpl) auxAlu.get(0);
			if(apoyo.getInicioSuspension() == null || hoy.isAfter(apoyo.getInicioSuspension().plusDays(apoyo.getPeriodoSuspension()))) {
				devolver = true;
			}
		}
		return devolver;
	}
	
	/**Interfaz: esElMismoUsuario
	 * Cabecera: private boolean esElMismoUsuario(ArrayList<PrestamoImpl> aInsertar)
	 * Comentario: Dado un ArrayList con los prestamos a insertar se comprueba que es solo un usuario, devuelve true si todos los prestamos son del mismo usuario y
	 * 			   false en caso contrario o de error
	 * Precondiciones: ninguna
	 * Entradas: un ArrayList
	 * Salidas: un boolean
	 * Postcondiciones: Devuelve true si todos los prestamos son del mismo usuario y false en caso contrario o de error
	 */
	private boolean esUnicoUsuario(ArrayList<PrestamoImpl> aInsertar) {
		boolean devolver = true;
		int aux = aInsertar.get(0).getCodigoUsuario();
		
		for(int i = 1; i<aInsertar.size() || devolver; i++) {
			if(aux != aInsertar.get(i).getCodigoUsuario()) {
				devolver = false;
			}
		}
		return devolver;
	}
	
	/**Interfaz: devolverPrestamo
	 * Cabecera: public boolean devolverPrestamo(ArrayList<PrestamoImpl> aDevolver, String rutaUsuarioSubClase, String rutaDocumentoSubClase) 
	 * Comentario: Dado un ArrayList con prestamos a devolver de un mismo usuario, y la rutas al fichero de usuarioSubClase y al documentoSubClase; 
	 * 			   devuelve true si se realizo con exito y false en caso contrario  			    			   
	 * Precondiciones: ninguna
	 * Entradas: un ArrayList, dos String
	 * Salidas: un ArrayList
	 * Postcondiciones: Devuelve un ArrayList a vacio si se pudieron prestar todos, o con los que no se pudieron prestar porque no estan disponibles, o los devuelve todos
	 * 					si el usuario sobrepasaba el numero maximo de prestamos o en caso de error.  			    			    
	 */
	public boolean devolverPrestamo(ArrayList<PrestamoImpl> aDevolver, String rutaUsuarioSubClase, String rutaDocumentoSubClase) {
		boolean devolver = false;
		ArrayList<PrestamoImpl> auxiliar = new ArrayList<PrestamoImpl>();
		
		if(aDevolver != null && !aDevolver.isEmpty() && esUnicoUsuario(aDevolver))
			if(modificar(aDevolver)) {
				for (PrestamoImpl aux : aDevolver) {
					if (fueraPlazo(aux,rutaDocumentoSubClase)){
						auxiliar.add(aux);
					}
				}
				if(!auxiliar.isEmpty()) {
					penalizar(auxiliar,rutaUsuarioSubClase,rutaDocumentoSubClase);
				}
				devolver = true;
			}
		return devolver;
	}
	
	/**Interfaz: penalizar
	 * 	Cabecera: private void penalizar(ArrayList<PrestamoImpl> aDevolver, String rutaUsuarioSubClase, String rutaDocumentoSubClase)
	 *  Comentario: Dado un ArrayList aDevolver, comprueba libro a libro si el usuario se ha excedido de dias por el tipo de prestamo y lo penaliza correspondientemente.
	 *  Precondiciones: Ninguna
	 *  Entradas: un ArrayList y dos String
	 *  Salida: nada
	 *  Postcondiciones: ninguna
	 */
	private void penalizar(ArrayList<PrestamoImpl> aDevolver, String rutaUsuarioSubClase, String rutaDocumentoSubClase) {
		AlumnoImpl auxAlu = new AlumnoImpl();
		ArrayList<AlumnoImpl> alumnos = new ArrayList<AlumnoImpl>();
		String codigoAlumno = "("+aDevolver.get(0).getCodigoUsuario();
		UtilFileGen<AlumnoImpl> auxAlumnos = new UtilFileGen<AlumnoImpl>();
		int dias = 0, diasAux, multPen;
		
		auxAlu = auxAlumnos.busqueda(codigoAlumno, rutaUsuarioSubClase).get(0);
		alumnos = auxAlumnos.leerFicheroBinario(rutaUsuarioSubClase);
		alumnos.remove(auxAlu);
		dias = auxAlu.getPeriodoSuspension();
		for (PrestamoImpl prestamoImpl : aDevolver) {
			diasAux = diasRetraso(prestamoImpl, rutaDocumentoSubClase);
			multPen = multiplicadorTipoPrestamo(prestamoImpl, rutaDocumentoSubClase);
			if(diasAux != 0 && multPen != 0){
				dias += (diasAux*multPen);
			}
		}
		auxAlu.SetPeriodoSuspension(dias);
		auxAlumnos.escribirRegistroBinario(auxAlu, rutaUsuarioSubClase);
	}
	
	/**Interfaz: multiplicadorTipoPrestamo
	 * 	Cabecera: private int multiplicadorTipoPrestamo(PrestamoImpl prestamoImpl, String rutaDocumentoSubClase) 
	 *  Comentario: Dado un prestamoImpl y la ruta al fichero de los documentos, devuelve el multiplicador del penalizador
	 *  Precondiciones: Ninguna
	 *  Entradas: un PrestamoImpl y un String
	 *  Salida: un int
	 *  Postcondiciones: Devuelve el multiplicador del penalizador
	 */
	private int multiplicadorTipoPrestamo(PrestamoImpl prestamoImpl, String rutaDocumentoSubClase) {
		int multiplo = 0;
		String codigoLibro = "("+prestamoImpl.getCodigoDocumento();
		LibroImpl auxLibro = new UtilFileGen<LibroImpl>().busqueda(codigoLibro, rutaDocumentoSubClase).get(0);
		if(auxLibro.getTipoPrestamo()==Constantes.RESTRINGIDO){
			multiplo = Constantes.RESTRINGIDOMULTIPLO;
		} else if (auxLibro.getTipoPrestamo()==Constantes.NORMAL) {
			multiplo = Constantes.NORMALMULTIPLO;
		}
		
		return multiplo;
	}

	/**Interfaz: diasRetraso
	 * 	Cabecera: private int diasRetraso(PrestamoImpl prestamoImpl, String rutaDocumentoSubClase)
	 *  Comentario: Dado un prestamoImpl y la ruta al fichero de los documentos, calcula el numero de dias excedidos con respecto al tipo de prestamo. Devuelve el exceso 
	 *  			de dias	
	 *  Precondiciones: Ninguna
	 *  Entradas: un PrestamoImpl y un String
	 *  Salida: un int
	 *  Postcondiciones: Devuelve el exceso dias
	 */
	private int diasRetraso(PrestamoImpl prestamoImpl, String rutaDocumentoSubClase) {
		int devolver=0;
		String codigoLibro = "("+prestamoImpl.getCodigoDocumento();
		LibroImpl auxLibro = new UtilFileGen<LibroImpl>().busqueda(codigoLibro, rutaDocumentoSubClase).get(0);
		int dias = (int) prestamoImpl.getDiasEnPrestamo();
		
		devolver = dias - auxLibro.getTipoPrestamo();
		return devolver;
	}

	/**Interfaz: modificar
	 * 	Cabecera: private boolean modificar(ArrayList<PrestamoImpl> aDevolver)
	 *  Comentario: Dado un ArrayList aDevolver, modifica el fichero PRESTAMOSITUACION para que refleje la realidad actual de los prestamos; devuelve true si se modifico 
	 *  			correctamente y false en caso contrario o de error
	 *  Precondiciones: Ninguna
	 *  Entradas: un ArrayList
	 *  Salida: un boolean
	 *  Postcondiciones: Devuelve true si se modifico correctamente y false en caso contrario o de error
	 */
	private boolean modificar(ArrayList<PrestamoImpl> aModificar) {
		boolean devolver= false, encontrado = false;
		UtilFileGen<PrestamoImpl> aux = new UtilFileGen<PrestamoImpl>();
		ArrayList<PrestamoImpl> sinActualizar = null, actualizado = new ArrayList<PrestamoImpl>();

		if(aModificar.get(0).getDiaDevolucion() == null) {  // se estan prestando los documentos
			/*for (PrestamoImpl prestamoImpl : aModificar) {
				aux.escribirRegistroBinario(prestamoImpl, Constantes.PRESTAMOSITUACION);
			}
			devolver = true;*/
			aux.escribirMultiplesRegistroBinario(aModificar, Constantes.PRESTAMOSITUACION);
		} else {											//se estan devolviendo
			sinActualizar = aux.leerFicheroBinario(Constantes.PRESTAMOSITUACION);
			for(int i = 0 ; i< aModificar.size(); i++, encontrado = false) {
				for(int j = 0; j < sinActualizar.size()  || !encontrado; j++) {
					if(sinActualizar.get(j).compareTo(aModificar.get(i))==0 && sinActualizar.get(j).getDiaDevolucion() == null) {
						encontrado = true;
					} else {
						actualizado.add(sinActualizar.get(j));
					}
				}
			}
			aux.borrarFicheroBinario(Constantes.PRESTAMOSITUACION);
			aux.crearFicheroBinario(Constantes.PRESTAMOSITUACION);
			//for (PrestamoImpl prestamoImpl : actualizado) {
				aux.escribirMultiplesRegistroBinario(actualizado, Constantes.PRESTAMOSITUACION);
			//}
			devolver = true;
		}
		return devolver;
	}

	/**Interfaz: fueraPlazo
	 * 	Cabecera: private boolean fueraPlazo(int codigoDocumento, String rutaDocumentoSubClase)
	 *  Comentario: Dado el codigo de un documento y  la ruta al fichero de documentoSubClase; devuelve true si esta fuera de plazo y false en caso contrario o de error
	 *  Precondiciones: Ninguna
	 *  Entradas: un int y un String
	 *  Salida: un boolean
	 *  Postcondiciones: Devuelve true si esta fuera de plazo y false en caso contrario o de error
	 */
	private boolean fueraPlazo(PrestamoImpl aDevolver, String rutaDocumentoSubClase) {
		boolean fuera = false;
		DocumentoImpl auxDoc = new DocumentoImpl();
		String codigo = "("+aDevolver.getCodigoDocumento();
		int dias = 0;
		
		auxDoc = new UtilFileGen<DocumentoImpl>().busqueda(codigo, rutaDocumentoSubClase).get(0);
		dias = aDevolver.getDiaDelPrestamo().until(aDevolver.getDiaDevolucion()).getDays();
		if(dias > auxDoc.getTipoPrestamo()){
			fuera = true;
		}
		
		return fuera;
	}

	/**Interfaz: identificarAlumno
	 * 	Cabecera: public int identificarAlumno(String nombre, String apellido1, String apellido2, String rutaUsuarioSubClase)
	 *  Comentario: Dado el nombre y los apellidos de un Usuario y la ruta al fichero de usuarioSubClase; devuelve el codigo del usuario o -1 en caso de error
	 *  Precondiciones: Ninguna
	 *  Entradas: cuatro String
	 *  Salida: un int
	 *  Postcondiciones: Devuelve el codigo del usuario o -1 en caso de error 
	 */
	public int identificarAlumno(String nombre, String apellido1, String apellido2, String rutaUsuarioSubClase) {
		int devolver = -1;
		String codigo = "([0-9]+,"+nombre+","+apellido1+","+apellido2;
		AlumnoImpl aux = new UtilFileGen<AlumnoImpl>().busqueda(codigo , rutaUsuarioSubClase).get(0);
		if(aux != null) {
			devolver = aux.getCodigo();
		}
		return devolver;
	}
	
	/**Interfaz: listarLibrosDisponibles
	 * 	Cabecera: public boolean listarLibrosDisponibles(String rutaDocumentoSubClase)
	 *  Comentario: Dada la ruta al fichero de documentoSubClase; muestra por pantalla de 5 en 5 los libros disponibles. Devuelve true si se muestra con exito y false en
	 *  		    caso contrario.
	 *  Precondiciones: Ninguna
	 *  Entradas: un String
	 *  Salida: un boolean
	 *  Postcondiciones: Devuelve true si se muestra con exito y false en caso contrario. 
	 */
	public boolean listarLibrosDisponibles(String rutaDocumentoSubClase) {
		boolean correcto = false;
		ArrayList<LibroImpl> auxLibro = new ArrayList<LibroImpl>();
		UtilFileGen<LibroImpl> aux = new UtilFileGen<LibroImpl>();
		
		auxLibro.addAll(aux.leerFicheroBinario(rutaDocumentoSubClase));
		if(auxLibro!=null && !auxLibro.isEmpty()){
			for (int i = 0, j=0; i<auxLibro.size(); i++) {
				if(quedanEjemplares(auxLibro.get(i).getCodigoDocumento(), rutaDocumentoSubClase)) {
					j++;
					System.out.println("\n"+auxLibro.get(i).mostrarObjeto());
					if(j%5 == 0) {
						pulseCualquierTeclaParaContinuar();
					}
				}
			}
		}
		return correcto;
	}
	
	/**Interfaz: pulseCualquierTeclaParaContinuar
	 * 	Cabecera: public void pulseCualquierTeclaParaContinuar()
	 *  Comentario: Bloquea el avance del metodo que la llama hasta que se pulsa cualquier tecla
	 *  Precondiciones: Ninguna
	 *  Entradas: ninguna
	 *  Salida: ninguna
	 *  Postcondiciones: ninguna 
	 */
	private void pulseCualquierTeclaParaContinuar()
	 { 
	        System.out.println("Pulse cualquier tecla para continuar ...");
	        try
	        {
	            System.in.read();
	        }  
	        catch(IOException e)
	        {}  
	 }
}
