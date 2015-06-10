package conductores;

import java.time.*;
import java.util.ArrayList;

import datos.*;
import utilidad.UtilFileGen;

public class ConductorUtilFileFGen {

	public static void main(String[] args) {
		String prueba = "Alumnos", copia = "acopiar", ordenar = "ordenado";
		UtilFileGen<AlumnoImpl> testeando = new UtilFileGen<AlumnoImpl>();
		AlumnoImpl auxiliar = null;
		ArrayList<AlumnoImpl> consulta = new ArrayList<AlumnoImpl>();
		
		
		//Creo los archivos
		System.out.println("¿creo el fichero binario?  "+testeando.crearFicheroBinario(prueba));
		//System.out.println("\n¿creo el fichero de texto?  "+testeando.crearFicheroTexto(prueba));
		
		System.out.println("\n¿copio el fichero binario?  "+testeando.copiarFicheroBinario(prueba, copia));
		//System.out.println("\n¿copio el fichero de texto?  "+testeando.copiarFicheroTexto(prueba, copia));
		//testeando.borrarFicheroTexto(copia);
		
		//Borro los archivos
		//System.out.println("\n¿Borro el fichero binario?  "+testeando.borrarFichero(prueba)); NO DESCOMENTAR --> Se sigue usando y se borrara mas adelante
		//System.out.println("\n¿Borro el fichero de texto?  "+testeando.borrarFicheroTexto(prueba1));  NO DESCOMENTAR --> Se sigue usando y se borrara mas adelante
		
		//Empiezo las pruebas de escritura y lectura
		auxiliar = new AlumnoImpl("Pepito", "Grillo", "Malatesta", "25566756", 15, 0, LocalDate.now(),0, "Nini");
		
		System.out.println("\nProbando a escribir y leer de un archivo binario\nEscritura efectuada: "+testeando.escribirRegistroBinario(auxiliar, prueba)
				+"\nLectura efectuada: "+testeando.leerFicheroBinario(prueba)+"\nLeyo lo siguiente:\n"+
				testeando.leerFicheroBinario(prueba).get(0).mostrar());
		
		//System.out.println("\nProbando a escribir y leer de un archivo texto\nEscritura efectuada: "+testeando.escribirRegistroTexto(auxiliar.toString(), prueba)
		//		+"\nLectura efectuada: "+testeando.leerFicheroTexto(prueba)+"\nLeyo lo siguiente:\n"+
		//		testeando.leerFicheroTexto(prueba));
		
		testeando.escribirRegistroBinario(new AlumnoImpl("Joselito", "Grillo", "Malatesta", "85566756", 15, 0, LocalDate.now(),0, "Nini"), prueba);
		System.out.println("\nPruebo a copiar de nuevo: "+testeando.copiarFicheroBinario(prueba, copia));
		
		if(testeando.leerFicheroBinario(copia).get(0) instanceof AlumnoImpl){
			System.out.println("\nUso el metodo mostrar() para enseñar el contenido del fichero copia");
			for(int i = 0; i <testeando.leerFicheroBinario(copia).size() ;i++){
				System.out.println("\n"+testeando.leerFicheroBinario(copia).get(i).mostrar());
			}
		}
		
		System.out.println("\nSeguimos probando, para ello cambiamos de orden el fichero copia.");
		testeando.borrarFicheroBinario(copia);
		testeando.crearFicheroBinario(copia);
		
		testeando.escribirRegistroBinario(testeando.leerFicheroBinario(prueba).get(1), copia);
		testeando.escribirRegistroBinario(testeando.leerFicheroBinario(prueba).get(0), copia);
		
		if(testeando.leerFicheroBinario(copia).get(0) instanceof AlumnoImpl){
			System.out.println("\nUso el metodo mostrar() para enseñar el contenido del fichero copia");
			for(int i = 0; i <testeando.leerFicheroBinario(copia).size() ;i++){
				System.out.println("\n"+testeando.leerFicheroBinario(copia).get(i).mostrar());
			}
		}
		
		testeando.crearFicheroBinario(ordenar);
		System.out.println("\nY ahora lo ordenamos por el metodo hibrido: "+testeando.ordenacionHibrida(copia, ordenar));
		if(testeando.leerFicheroBinario(copia).get(0) instanceof AlumnoImpl){
			System.out.println("\nUso el metodo mostrar() para enseñar el contenido del fichero "+ordenar);
			for(int i = 0; i <testeando.leerFicheroBinario(ordenar).size() ;i++){
				System.out.println("\n"+testeando.leerFicheroBinario(ordenar).get(i).mostrar());
			}
		}
		
		System.out.println("\nAhora realizamos tres busquedas la primera no deberia encontrar ninguna coincidencia, la segunda"
				+ "una sola coincidencia y en la tercera dos");
		consulta = testeando.busqueda("Perez", ordenar);
		
		System.out.println("\nLa busqueda no encontro nada: "+consulta);
		
		consulta = testeando.busqueda("Pepito", ordenar);
		
		System.out.println("\nLa busqueda encontro un elemento: "+consulta.size()+
				"\nY obtuvimos: "+consulta.toString());
		
		
		consulta = testeando.busqueda("Grillo", ordenar);
		
		System.out.println("\nLa busqueda encontro dos elementos: "+consulta.size()+
				"\nY obtuvimos: "+consulta.toString());
		
		consulta = testeando.busqueda("(1", ordenar);
		
		System.out.println("\nLa busqueda encontro un elementos: "+consulta.size()+
				"\nY obtuvimos: "+consulta.toString());
		
		testeando.borrarFicheroBinario(prueba);
		//testeando.borrarFicheroTexto(prueba);
		testeando.borrarFicheroBinario(copia);
		//testeando.borrarFicheroTexto(copia);
		testeando.borrarFicheroBinario(ordenar);
	}

}
