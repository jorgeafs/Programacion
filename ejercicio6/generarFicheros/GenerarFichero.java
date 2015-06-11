package generarFicheros;

import gestion.GestionPrestamos;

import java.time.LocalDate;
import java.util.*;

import utilidad.UtilFileGen;
import datos.*;

public class GenerarFichero {
	static ArrayList<AlumnoImpl> auxAlu = new ArrayList<AlumnoImpl>();
	static ArrayList<LibroImpl> auxLib = new ArrayList<LibroImpl>();
	static ArrayList<PrestamoImpl> auxPres = new ArrayList<PrestamoImpl>();
	public static void main(String[] args) {
		UtilFileGen<AlumnoImpl> auxA = new UtilFileGen<AlumnoImpl>(); 
		UtilFileGen<LibroImpl> auxL = new UtilFileGen<LibroImpl>();
		auxAlu.add(new AlumnoImpl("Pepito", "Grillo", "Malatesta", "25566756", Constantes.ALUMNO, 0, LocalDate.now(),0, "Nini"));
		auxAlu.add(new AlumnoImpl("Joselito", "Grillo", "Malatesta", "28566756", Constantes.ALUMNO, 0, LocalDate.now(),0, "Nini"));
		auxAlu.add(new AlumnoImpl("Jose", "Ruiz", "Malatesta", "25566757", Constantes.ALUMNO, 0, LocalDate.now(),0, "Nini"));
		auxAlu.add(new AlumnoImpl("Luis", "Mac", "Murdoc", "65566757", Constantes.ALUMNO, 0, LocalDate.now(),0, "Medicina"));
		auxAlu.add(new AlumnoImpl("Xurxo", "Lopez", "Ruiz", "27866756", Constantes.ALUMNO, 0, LocalDate.now(),0, "Industrial"));
		auxAlu.add(new AlumnoImpl("Manuel", "Gomez", "Sanchez", "37566756", Constantes.ALUMNO, 0, LocalDate.now(),0, "Arquitectura"));
		auxAlu.add(new AlumnoImpl("David", "Sainz", "Muñoz", "78526757", Constantes.ALUMNO, 0, LocalDate.now(),0, "Biologia"));
		auxAlu.add(new AlumnoImpl("Luis", "Gonzalez", "Sanchez", "88566757", Constantes.ALUMNO, 0, LocalDate.now(),0, "Periodismo"));
		auxAlu.add(new AlumnoImpl("Julian", "Montenegro", "Muñoz", "78577757", Constantes.ALUMNO, 0, LocalDate.now(),0, "Biologia"));
		auxAlu.add(new AlumnoImpl("Luis", "Muñoz", "Sanchez", "10566797", Constantes.ALUMNO, 0, LocalDate.now(),0, "Periodismo"));
		System.out.println(new AlumnoImpl().getCodigo());
		auxA.crearFicheroBinario(Constantes.ALUMNOS);
		auxA.escribirMultiplesRegistroBinario(auxAlu, Constantes.ALUMNOS);
		
		auxLib.add(new LibroImpl("Historia", "Culto Romano", Constantes.LIBRO, 1, Constantes.SOLOCONSULTA, "La religión del poder.", "Fernando", "una", LocalDate.now().minusYears(10), 5, 1841713198L));
		auxLib.add(new LibroImpl("Historia", "Culto Romano", Constantes.LIBRO, 2, Constantes.NORMAL, "Roma en grecia.", "Fernando", "una", LocalDate.now().minusYears(7), 0, 1841713118L));
		auxLib.add(new LibroImpl("Historia", "Culto Romano", Constantes.LIBRO, 1, Constantes.RESTRINGIDO, "La antiguedad en la modernidad.", "Fernando", "una", LocalDate.now().minusYears(5), 1, 1842513118L));
		auxLib.add(new LibroImpl("Derecho", "Constitucional", Constantes.LIBRO, 1, Constantes.SOLOCONSULTA, "Derecho vital", "Laura", "Bolson", LocalDate.now().minusYears(1), 5, 2541713198L));
		auxLib.add(new LibroImpl("Medicina", "Cirugia", Constantes.LIBRO, 10, Constantes.NORMAL, "Laparoscopia", "Manuel", "Bayer", LocalDate.now().minusYears(15), 0, 1841755118L));
		auxLib.add(new LibroImpl("Medicina", "Cirugia", Constantes.LIBRO, 5, Constantes.RESTRINGIDO, "Cirugia del estomago", "Manuel", "Tull", LocalDate.now().minusYears(35), 1, 1002513118L));auxLib.add(new LibroImpl("Historia", "Culto Romano", Constantes.LIBRO, 1, Constantes.RESTRINGIDO, "La antiguedad en la modernidad.", "Fernando", "una", LocalDate.now().minusYears(5), 1, 1842513118L));
		auxLib.add(new LibroImpl("Derecho", "Constitucional", Constantes.LIBRO, 1, Constantes.SOLOCONSULTA, "Derecho vital: Decision de vida y muerte", "Laura", "Bolson", LocalDate.now().minusYears(5), 5, 3331713198L));
		auxLib.add(new LibroImpl("Ingenieria", "Calculo Estructural", Constantes.LIBRO, 10, Constantes.NORMAL, "Forjados bidireccionales. Variables del calculo", "Egroj", "Castillar", LocalDate.now().minusYears(3), 0, 5693755118L));
		auxLib.add(new LibroImpl("Magia", "Cartomagia", Constantes.LIBRO, 5, Constantes.RESTRINGIDO, "Cartomagia fundamental", "Vicente Canuto", "Autor-Editor", LocalDate.now().minusYears(15), 1, 9788460465751L));
		auxLib.add(new LibroImpl("Literatura", "Ciencia-Ficcion", Constantes.LIBRO, 5, Constantes.NORMAL, "Los Clanes de la Luna Alfana", "Phillip K. Dick", "Autor-Editor", LocalDate.now().minusYears(15), 1, 9788445076293L));
		System.out.println(new LibroImpl().getCodigo());
		auxL.crearFicheroBinario(Constantes.LIBROS);
		auxL.escribirMultiplesRegistroBinario(auxLib, Constantes.LIBROS);
	}

}
