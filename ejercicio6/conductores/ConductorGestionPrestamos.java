package conductores;

import java.util.*;

import utilidad.UtilFileGen;
import datos.*;
import gestion.GestionPrestamos;

public class ConductorGestionPrestamos {

	public static void main(String[] args) {
		GestionPrestamos<AlumnoImpl> auxA = new GestionPrestamos<AlumnoImpl>();
		GestionPrestamos<LibroImpl> auxL = new GestionPrestamos<LibroImpl>();
		GestionPrestamos<String> auxS = new GestionPrestamos<String>();
		GestionPrestamos<PrestamoImpl> auxP = new GestionPrestamos<PrestamoImpl>();
		PrestamoImpl auxiliar = new PrestamoImpl();
		//Pruebo alumnosDevPendientes
		ArrayList<AlumnoImpl> apoyoA = auxA.alumnosDevPendientes(Constantes.ALUMNOS);
		for(AlumnoImpl aux : apoyoA) {
			System.out.println(aux.toString()+"\n");
		}
		//Pruebo libroMasPrestado (se preuban tambien el prestadoHistorico y el prestadoSituacion
		System.out.println("\nAhora muestro el/los libros mas consultados\n");
		ArrayList<LibroImpl> apoyoL = auxL.libroMasPrestado();
		for (LibroImpl aux : apoyoL) {
			System.out.println(aux.toString()+"\n");
		}
		//Pruebo especialidadMasConsultada
		ArrayList<String> apoyoS = auxS.especialidadMasConsultada();
		System.out.println("\nAhora muestro la/s especialidad mas consultada/s\n");
		for (String string : apoyoS) {
			System.out.println(string+"\n");
		}
		auxS.listarLibrosDisponibles(Constantes.LIBROS);
		//Pruebo realizarPrestamo
		//primero miro si me deja sacar un libro prestado
		auxiliar = new PrestamoImpl(2, 3);
		ArrayList<PrestamoImpl> auxiliarP = new ArrayList<PrestamoImpl>();
		auxiliarP.add(auxiliar);
		System.out.println("Probamos a sacar un libro al que no le quedan mas ejemplares\n"+auxP.realizarPrestamo(auxiliarP, Constantes.ALUMNOS, Constantes.LIBROS));
		auxiliar = new PrestamoImpl(3,5);
		auxiliarP.add(auxiliar);
		System.out.println("\nProbamos a prestar dos libros a distintos usuarios\n"+auxP.realizarPrestamo(auxiliarP, Constantes.ALUMNOS, Constantes.LIBROS));
		auxiliarP.remove(1);//.remove me funciona indicando el indice y por ahora no me funciona con el objeto
		auxiliarP.add( new PrestamoImpl(2, 5));
		System.out.println("\nProbamos a prestar dos libros al mismo usuario, pero uno de ellos solo tiene un ejemplar que ya esta prestado\n"+auxP.realizarPrestamo(auxiliarP, Constantes.ALUMNOS, Constantes.LIBROS));
		//System.out.println("\n"+new UtilFileGen<PrestamoImpl>().leerFicheroBinario(Constantes.ALUMNOS));
		
	}

}
