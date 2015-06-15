package generarFicheros;

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
		UtilFileGen<PrestamoImpl> auxP = new UtilFileGen<PrestamoImpl>();
		/**
/*1*/	auxAlu.add(new AlumnoImpl("Pepito", "Grillo", "Malatesta", "25566756", Constantes.ALUMNO, 0, null,0, "Nini"));
		auxAlu.add(new AlumnoImpl("Joselito", "Grillo", "Malatesta", "28566756", Constantes.ALUMNO, 0, null,0, "Nini"));
		auxAlu.add(new AlumnoImpl("Jose", "Ruiz", "Malatesta", "25566757", Constantes.ALUMNO, 0, null,0, "Nini"));
		auxAlu.add(new AlumnoImpl("Luis", "Mac", "Murdoc", "65566757", Constantes.ALUMNO, 0, null,0, "Medicina"));
/*5*/	auxAlu.add(new AlumnoImpl("Xurxo", "Lopez", "Ruiz", "27866756", Constantes.ALUMNO, 0, null,0, "Industrial"));
		auxAlu.add(new AlumnoImpl("Manuel", "Gomez", "Sanchez", "37566756", Constantes.ALUMNO, 0, null,0, "Arquitectura"));
		auxAlu.add(new AlumnoImpl("David", "Sainz", "Muñoz", "78526757", Constantes.ALUMNO, 0, null,0, "Biologia"));
		auxAlu.add(new AlumnoImpl("Luis", "Gonzalez", "Sanchez", "88566757", Constantes.ALUMNO, 0, null,0, "Periodismo"));
		auxAlu.add(new AlumnoImpl("Julian", "Montenegro", "Muñoz", "78577757", Constantes.ALUMNO, 0, null,0, "Biologia"));
/*10*/	auxAlu.add(new AlumnoImpl("Luis", "Muñoz", "Sanchez", "10566797", Constantes.ALUMNO, 0, null,0, "Periodismo"));
		System.out.println(auxAlu.get(auxAlu.size()-1).getCodigo());
		auxA.crearFicheroBinario(Constantes.ALUMNOS);
		auxA.escribirMultiplesRegistroBinario(auxAlu, Constantes.ALUMNOS);
		
/*1*/	auxLib.add(new LibroImpl("Historia", "Culto Romano", Constantes.LIBRO, 1, Constantes.SOLOCONSULTA, "La religión del poder.", "Fernando", "una", LocalDate.now().minusYears(10), 5, 1841713198L));
		auxLib.add(new LibroImpl("Historia", "Culto Romano", Constantes.LIBRO, 2, Constantes.NORMAL, "Roma en grecia.", "Fernando", "una", LocalDate.now().minusYears(7), 0, 1841713118L));
		auxLib.add(new LibroImpl("Historia", "Culto Romano", Constantes.LIBRO, 1, Constantes.RESTRINGIDO, "La antiguedad en la modernidad.", "Fernando", "una", LocalDate.now().minusYears(5), 1, 1842513118L));
		auxLib.add(new LibroImpl("Derecho", "Constitucional", Constantes.LIBRO, 1, Constantes.SOLOCONSULTA, "Derecho vital", "Laura", "Bolson", LocalDate.now().minusYears(1), 5, 2541713198L));
/*5*/	auxLib.add(new LibroImpl("Medicina", "Cirugia Nuevas tecnicas", Constantes.LIBRO, 10, Constantes.NORMAL, "Laparoscopia", "Manuel", "Bayer", LocalDate.now().minusYears(15), 0, 1841755118L));
		auxLib.add(new LibroImpl("Medicina", "Cirugia general", Constantes.LIBRO, 5, Constantes.RESTRINGIDO, "Cirugia del estomago", "Manuel", "Tull", LocalDate.now().minusYears(35), 1, 1002513118L));auxLib.add(new LibroImpl("Historia", "Culto Romano", Constantes.LIBRO, 1, Constantes.RESTRINGIDO, "La antiguedad en la modernidad.", "Fernando", "una", LocalDate.now().minusYears(5), 1, 1842513118L));
		auxLib.add(new LibroImpl("Derecho", "Constitucional", Constantes.LIBRO, 1, Constantes.SOLOCONSULTA, "Derecho vital: Decision de vida y muerte", "Laura", "Bolson", LocalDate.now().minusYears(5), 5, 3331713198L));
		auxLib.add(new LibroImpl("Ingenieria", "Calculo Estructural", Constantes.LIBRO, 10, Constantes.NORMAL, "Forjados bidireccionales. Variables del calculo", "Egroj", "Castillar", LocalDate.now().minusYears(3), 0, 5693755118L));
		auxLib.add(new LibroImpl("Magia", "Cartomagia", Constantes.LIBRO, 5, Constantes.RESTRINGIDO, "Cartomagia fundamental", "Vicente Canuto", "Autor-Editor", LocalDate.now().minusYears(15), 1, 9788460465751L));
/*10*/	auxLib.add(new LibroImpl("Literatura", "Ciencia-Ficcion", Constantes.LIBRO, 5, Constantes.NORMAL, "Los Clanes de la Luna Alfana", "Phillip K. Dick", "Autor-Editor", LocalDate.now().minusYears(15), 1, 9788445076293L));
		System.out.println(auxLib.get(auxAlu.size()-1).getCodigo());
		auxL.crearFicheroBinario(Constantes.LIBROS);
		auxL.escribirMultiplesRegistroBinario(auxLib, Constantes.LIBROS);
		
/*1*/	auxPres.add(new PrestamoImpl(1, 3,"Culto Romano"));
		auxPres.add(new PrestamoImpl(2, 2, "Culto Romano"));
		auxPres.add(new PrestamoImpl(10, 9, "Cartomagia"));
		auxPres.add(new PrestamoImpl(9, 9, "Cartomagia"));
/*5*/	auxPres.add(new PrestamoImpl(8, 9, "Cartomagia"));
		auxPres.add(new PrestamoImpl(7, 8, "Calculo Estructural"));
		auxPres.add(new PrestamoImpl(5, 5, "Cirugia nuevas tecnicas"));
		auxPres.add(new PrestamoImpl(4, 6, "Cirugia general"));
		auxPres.add(new PrestamoImpl(3, 1, "Culto Romano"));
/*10*/	auxPres.add(new PrestamoImpl(5, 6, "Cirugia general"));
//convirtiendolos en prestamos completados
		auxPres.get(0).setDiaDelPrestamo(LocalDate.now().minusMonths(2));
		auxPres.get(0).setDiaDevolucion(LocalDate.now().minusDays(58));
		auxPres.get(1).setDiaDelPrestamo(LocalDate.now().minusMonths(2));
		auxPres.get(1).setDiaDevolucion(LocalDate.now().minusDays(57));
		auxPres.get(2).setDiaDelPrestamo(LocalDate.now().minusMonths(2));
		auxPres.get(2).setDiaDevolucion(LocalDate.now().minusDays(56));
		auxPres.get(3).setDiaDelPrestamo(LocalDate.now().minusMonths(2));
		auxPres.get(3).setDiaDevolucion(LocalDate.now().minusDays(50));
		auxPres.get(4).setDiaDelPrestamo(LocalDate.now().minusMonths(2));
		auxPres.get(4).setDiaDevolucion(LocalDate.now().minusDays(49));
		auxPres.get(5).setDiaDelPrestamo(LocalDate.now().minusMonths(2));
		auxPres.get(5).setDiaDevolucion(LocalDate.now().minusDays(55));
		auxPres.get(6).setDiaDelPrestamo(LocalDate.now().minusMonths(2));
		auxPres.get(6).setDiaDevolucion(LocalDate.now().minusDays(50));
		auxPres.get(7).setDiaDelPrestamo(LocalDate.now().minusMonths(2));
		auxPres.get(7).setDiaDevolucion(LocalDate.now().minusDays(51));
		auxPres.get(8).setDiaDelPrestamo(LocalDate.now().minusMonths(2));
		auxPres.get(8).setDiaDevolucion(LocalDate.now().minusDays(52));
		auxPres.get(9).setDiaDelPrestamo(LocalDate.now().minusMonths(2));
		auxPres.get(9).setDiaDevolucion(LocalDate.now().minusDays(57));
		/*for(PrestamoImpl aux : auxPres){
			System.out.println("\n"+aux.mostrar());
		}*/
		auxP.crearFicheroBinario(Constantes.PRESTAMOHISTORICO);
		auxP.escribirMultiplesRegistroBinario(auxPres, Constantes.PRESTAMOHISTORICO);
		auxPres.clear();
		
/*1*/	auxPres.add(new PrestamoImpl(1, 3,"Culto Romano"));
		auxPres.add(new PrestamoImpl(2, 2, "Culto Romano"));
		auxPres.add(new PrestamoImpl(10, 9, "Cartomagia"));
		auxPres.add(new PrestamoImpl(9, 9, "Cartomagia"));
/*5*/	auxPres.add(new PrestamoImpl(8, 9, "Cartomagia"));
		auxPres.add(new PrestamoImpl(7, 8, "Calculo Estructural"));
		auxPres.add(new PrestamoImpl(5, 5, "Cirugia nuevas tecnicas"));
		auxPres.add(new PrestamoImpl(4, 6, "Cirugia general"));
		auxPres.add(new PrestamoImpl(3, 1, "Culto Romano"));
/*10*/	auxPres.add(new PrestamoImpl(5, 6, "Cirugia general"));
		
		auxPres.get(0).setDiaDelPrestamo(LocalDate.now().minusDays(5));
		auxPres.get(1).setDiaDelPrestamo(LocalDate.now().minusDays(3));
		auxPres.get(2).setDiaDelPrestamo(LocalDate.now().minusDays(4));
		auxPres.get(3).setDiaDelPrestamo(LocalDate.now().minusDays(2));
		auxPres.get(4).setDiaDelPrestamo(LocalDate.now());
		auxPres.get(5).setDiaDelPrestamo(LocalDate.now().minusDays(1));
		auxPres.get(6).setDiaDelPrestamo(LocalDate.now());
		auxPres.get(7).setDiaDelPrestamo(LocalDate.now().minusDays(3));
		auxPres.get(8).setDiaDelPrestamo(LocalDate.now().minusDays(2));
		auxPres.get(9).setDiaDelPrestamo(LocalDate.now().minusDays(1));
		for(PrestamoImpl aux : auxPres){
			System.out.println("\n"+aux.mostrar());
		}
		auxP.crearFicheroBinario(Constantes.PRESTAMOSITUACION);
		auxP.escribirMultiplesRegistroBinario(auxPres, Constantes.PRESTAMOSITUACION);
		/*for(int i= 0; i<auxA.leerFicheroBinario(Constantes.ALUMNOS).size();i++) {
			System.out.println(auxA.leerFicheroBinario(Constantes.ALUMNOS).get(i).toString()+"\n");
		}*/
	}

}
