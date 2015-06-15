package conductores;
import java.util.ArrayList;

import datos.*;
import utilidad.*;

public class MostrarFicheros {

	public static void main(String[] args) {
		ArrayList<PrestamoImpl> arrayP = new ArrayList<PrestamoImpl>();
		ArrayList<LibroImpl> arrayL = new ArrayList<LibroImpl>();
		ArrayList<AlumnoImpl> arrayA = new ArrayList<AlumnoImpl>();
		UtilFileGen<?> aux = new UtilFileGen<>();
		
		arrayA = (ArrayList<AlumnoImpl>) aux.leerFicheroBinario(Constantes.ALUMNOS);
		for (AlumnoImpl alumnoImpl : arrayA) {
			System.out.println(alumnoImpl.toString());
		}
		System.out.println("\n");
		
		arrayL = (ArrayList<LibroImpl>) aux.leerFicheroBinario(Constantes.LIBROS);
		for (LibroImpl libro : arrayL) {
			System.out.println(libro.toString());
		}
		
		arrayP = (ArrayList<PrestamoImpl>) aux.leerFicheroBinario(Constantes.PRESTAMOHISTORICO);
		System.out.println("\n Prestamos historico");
		for (PrestamoImpl prest : arrayP) {
			System.out.println(prest.toString());
		}
		
		arrayP.clear();
		arrayP = (ArrayList<PrestamoImpl>) aux.leerFicheroBinario(Constantes.PRESTAMOSITUACION);
		System.out.println("\n Prestamos situacion");
		for (PrestamoImpl prest : arrayP) {
			System.out.println(prest.toString());
		}
		
	}

}
