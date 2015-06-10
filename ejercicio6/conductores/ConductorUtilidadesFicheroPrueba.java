package conductores;

import java.time.LocalDate;
import java.util.LinkedList;

import datos.*;
import utilidad.*;

public class ConductorUtilidadesFicheroPrueba {

	public static void main(String[] args) {
		AlumnoImpl crear = null, test = null;//lectura = null; 
		Object lectura = null;
		String rutaAlum = "Alumnos.dat";
		UtilidadesFicheroPruebas<AlumnoImpl> prueba = new UtilidadesFicheroPruebas<AlumnoImpl>();
		LinkedList <AlumnoImpl> aux = new LinkedList<AlumnoImpl>();
		
		crear = new AlumnoImpl("Pepito", "Grillo", "", "25566756", 15, 0, LocalDate.now(),0, "Nini");
		prueba.crearFichero(rutaAlum);
		prueba.escribirRegistroBinario(crear, rutaAlum);
		
		//lectura = (AlumnoImpl) prueba.leerObjetoPuro(rutaAlum).getFirst(); cuando lectura es un AlumnoImpl, hay que hacerle cast
		lectura = prueba.leerObjetoPuro(rutaAlum).getFirst();
		
		//System.out.println(lectura.mostrar());//lectura como AlumnoImpl, no necesita de nada mas para llamar a mostrar()
		System.out.println("Mostrando desde un objeto puro\n"+((AlumnoImpl) lectura).mostrar()+"\n");//pero como Objeto puro necesita del cast a AlumnoImpl para llamar a mostrar()
		
		//prueba de con genericos para usar mostrar como he hecho anteriormente
		prueba.setAG((AlumnoImpl) prueba.leerFicheroObjetos(rutaAlum).getAG().getFirst());
		
		System.out.println("Mostrando desde un generico\n"+prueba.getAG().mostrar()+"\n");
		
		//volcar la informacion desde un generico a un Objeto de la clase correspondiente
		if (prueba.getAG() instanceof AlumnoImpl){ //ahora mismo se que si es cierto, pero debera hacerse fuera del entorno de pruebas
			test = prueba.getAG();
			System.out.println("Preguntamos si el contenido del generico es del tipo que queremos he imprimimos\n"+test.mostrar()+"\n");
		}
		
		crear  = new AlumnoImpl("Joselito", "Grillo", "", "85566756", 15, 0, LocalDate.now(),0, "Nini");
		prueba.escribirRegistroBinario(crear, rutaAlum);
		
		for (int i = 0; i<prueba.leerObjetoPuro(rutaAlum).size(); i++) {
			if(prueba.leerObjetoPuro(rutaAlum).get(i) instanceof AlumnoImpl)
			System.out.println("Leyendo de un fichero, mostramos todos los registros\n"+prueba.leerObjetoPuro(rutaAlum).get(i).mostrar()+"\n");
		}
		/**Conclusiones de las pruebas:
		 * 		El uso de una utilidad de ficheros de tipo generica es viable, la utilidad en si no tratara de saber que es que cosa.
		 * 		En este momento se trabaja con objetos puros pero mas adelante probare a implementar el modo texto
		 * 		Inconvenientes: el metodo que la llame debe vigilar el tipo del objeto devuelto, ya que estimo no es responsabilidad de
		 * 						la clase de utilidades 
		 */
		prueba.borrarFichero(rutaAlum);
	}

}
