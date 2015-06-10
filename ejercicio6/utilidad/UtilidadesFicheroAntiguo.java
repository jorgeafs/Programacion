package utilidad;

/**GestionFichero: 
 * Esta gestora de ficheros manejara cinco ficheros, uno de movimientos, otro de situacion y otro historico del mismo tipo de 
 * objeto y los otros dos seran de situacion, de los cuales leeremos en la mayoria de los casos y puntualmente se actualizaran.
 *
 * 
 *  
 *
 */

import java.io.*;
import java.util.*;

public class UtilidadesFicheroAntiguo {
	
	/**Interfaz crearFichero
	 * Cabecera: public boolean crearFichero (String nombreFichero)
	 * Comentario: Dado un string crea un fichero con ese nombre en la carpeta activa, devuelve true si se creo correctamente y
	 * 				false si ya existia u ocurrio algun error
	 * Precondiciones: Ninguna
	 * Entrada: Un String
	 * Salida: un boolean
	 * Postcondiciones: Devuelve un true si se crea correctamente y false en caso de error o si ya existia
	*/
	public boolean crearFichero (String nombreFichero){
		boolean correcto = false;
		File nuevoFichero = new File(nombreFichero);
		if(nuevoFichero.isFile() != true){
			try {
				correcto = nuevoFichero.createNewFile();
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("Fallo la creacion");
			}
		}		
		return correcto;
	}
	
	/**Interfaz borrarFichero
	 * Cabecera: public boolean borrarFichero (String nombreFichero)
	 * Comentario: Dado un string borra un fichero con ese nombre en la carpeta activa, devuelve true si se borro correctamente y
	 * 				false si no existia u ocurrio algun error
	 * Precondiciones: Ninguna
	 * Entrada: Un String
	 * Salida: un boolean
	 * Postcondiciones: Devuelve un true si se borra correctamente y false en caso de error o si no existia
	*/
	public boolean borrarFichero (String nombreFichero){
		boolean correcto = false;
		File aBorrar = new File (nombreFichero);
		if(aBorrar.isFile()){
			aBorrar.delete();
			correcto = true;
		}
		return correcto;
	}
	/**Interfaz copiarFichero
	 * Cabecera: public boolean copiarFichero (String ficheroOrigen, String ficheroACopiar)
	 * Comentario: Dado un string borra un fichero con ese nombre en la carpeta activa, devuelve true si se borro correctamente y
	 * 				false si no existia u ocurrio algun error
	 * Precondiciones: Ninguna
	 * Entrada: Un String
	 * Salida: un boolean
	 * Postcondiciones: Devuelve un true si se borra correctamente y false en caso de error o si no existia
	*/
	public boolean copiarFichero(String ficheroOrigen, String ficheroACopiar){
		boolean correcto = false;
		GenericoApoyo<Object> auxiliar = new GenericoApoyo<Object>(); //uso mi clase Mio, buscar mejor nombre, para iniciar auxiliar parametrizado como object
		if(new File(ficheroOrigen).isFile() & new File(ficheroACopiar).isFile()){
			//para leer
			FileInputStream fisLectura = null;
			ObjectInputStream oisLectura = null;
			//para copiar
			FileOutputStream fosCopia = null;
			ObjectOutputStream oosCopia = null;
			try {
				fisLectura = new FileInputStream (ficheroOrigen);
				oisLectura = new ObjectInputStream(fisLectura);
				fosCopia = new FileOutputStream (ficheroACopiar); 
				oosCopia = new ObjectOutputStream(fosCopia);
				
				//auxiliar =  oisLectura.readObject();
				auxiliar.setT(oisLectura.readObject());
				while(auxiliar !=null) {
					oosCopia.writeObject(auxiliar);
					//auxiliar = oisLectura.readObject();
					auxiliar.setT(oisLectura.readObject());
				}
				
			} catch (FileNotFoundException e) {
				// e1.printStackTrace();
				System.out.println("Algun fichero no se pudo encontrar");
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("La copia no se pudo realizar");
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
				System.out.println("No se identifico ningun objeto");
			} finally {
				try{
					if(oosCopia != null){ oosCopia.close();}
					if(oisLectura != null){	oisLectura.close();}
					if(fosCopia != null){fosCopia.close();}
					if(fisLectura != null){fisLectura.close();}
				} catch (IOException e) {
					//e.printStackTrace();
					System.out.println("No se pudo cerrar correctamente");
				}
			correcto = true;
			}
		}	
		return correcto;		
	}
	
	public boolean ordenacionHibrida(String desordenado, String ordenado) {
		boolean correcto = false;
		GenericoApoyo<ArrayList<Object>> objetos = new GenericoApoyo<ArrayList<Object>>();
		if (new File(desordenado).isFile() & new File(ordenado).isFile()) {
			if ((objetos = ordenarArray(desordenado))!= null) {
				FileOutputStream fosOrdenado = null;
				ObjectOutputStream oosOrdenado = null;
				try {
					fosOrdenado = new FileOutputStream(ordenado);
					oosOrdenado = new ObjectOutputStream(fosOrdenado);
					for (int i = 0; i < objetos.getT().size(); i++) {
						oosOrdenado.writeObject(objetos.getT().get(i));
					}
				} catch (FileNotFoundException e) {
					// e1.printStackTrace();
					System.out.println("Algun fichero no se pudo encontrar");
				} catch (IOException e) {
					// e.printStackTrace();
					System.out.println("La copia no se pudo realizar");
				} finally {
					try {
						if (oosOrdenado != null) { oosOrdenado.close();}
						if (fosOrdenado != null) { fosOrdenado.close();;}
					} catch (IOException e) {
						// e.printStackTrace();
						System.out.println("No se pudo cerrar correctamente");
					}
				}
				correcto = true;
			}
		}
		return correcto;
	}

	private /*ArrayList<T>*/GenericoApoyo<ArrayList<Object>> ordenarArray(String desordenado) {
		/**ArrayList<T> origen = listarObjetos(desordenado), ordenado = new ArrayList<T>();
		T [] operar = (T[])origen.toArray();
		Collections.sort((List<T>) origen);Da problemas
		Arrays.sort(operar);
		for(int i = 0; i < operar.length ; i++){
			ordenado.add(operar[i]);
		}
		ordenado = (ArrayList<T>) Arrays.asList(operar);*/
		GenericoApoyo<ArrayList<Object>> ordenado = new GenericoApoyo<ArrayList<Object>>();
		GenericoApoyo<ArrayList<Object>> origen = new GenericoApoyo<ArrayList<Object>>();
		GenericoApoyo<Object[]> operar = new GenericoApoyo<Object[]>();
		origen = listarObjetos(desordenado);
		operar.setT(origen.getT().toArray());
		Arrays.sort(operar.getT());
		ordenado.setT(Arrays.asList(operar.getT()));
		return ordenado;
	}

	private /*ArrayList<T>*/GenericoApoyo<ArrayList<Object>> listarObjetos(String desordenado) {
		GenericoApoyo<ArrayList<Object>> devolver = new GenericoApoyo<ArrayList<Object>>();
		GenericoApoyo<Object> escribir = new GenericoApoyo<Object>();
		
		FileInputStream fisLectura = null;
		ObjectInputStream oisLectura = null;
		
		try {
			fisLectura = new FileInputStream (desordenado);
			oisLectura = new ObjectInputStream (fisLectura);
			escribir.setT(oisLectura.readObject());
			while(escribir.getT() != null){
				devolver.getT().add(escribir.getT());
				escribir.setT(oisLectura.readObject());
			}
		} catch (IOException e) {
			System.out.println("Algo no ha funcionado");
		} catch (ClassNotFoundException e) {
			System.out.println("No se encontro nada en el fichero");
		} catch (ClassCastException e) {
			System.out.println("Surgio un problema en ");
		} finally{
			try {
			if (oisLectura != null){ oisLectura.close();}
			if (fisLectura != null){ fisLectura.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return devolver;
	}
	
	public boolean escribirRegistro(GenericoApoyo<Object> introducir, String ficheroIntroducir){
		boolean correcto= false;
		FileOutputStream fosEscribir = null;
		ObjectOutputStream oosEscribir = null;
		if (new File(ficheroIntroducir).isFile()){
			try {
				fosEscribir = new FileOutputStream(ficheroIntroducir);
				oosEscribir = new MiObjectOutputStream(fosEscribir);
				oosEscribir.writeObject(introducir);
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				try {
					if(fosEscribir != null){ fosEscribir.close();}
					if(oosEscribir != null){ oosEscribir.close();}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} 
		return correcto;		
	}
	
	public boolean borrarregistro(GenericoApoyo<Object> aBorrar, String ficheroBorrar){
		boolean correcto = false;
		GenericoApoyo<Object> comparando = new GenericoApoyo<Object>();
		FileInputStream fisLeer = null;
		ObjectInputStream oisLeer = null;
		FileOutputStream fosEscribir = null;
		ObjectOutputStream oosEscribir = null;
		String apoyo = "apoyo.dat";
		crearFichero(apoyo);
		
		if(new File(ficheroBorrar).isFile()){
			try {
				fisLeer = new FileInputStream(ficheroBorrar);
				oisLeer = new ObjectInputStream(fisLeer);
				fosEscribir = new FileOutputStream(apoyo);
				oosEscribir = new MiObjectOutputStream(fosEscribir);
				comparando.setT(oisLeer.readObject());
				while(comparando != null) {
					if( aBorrar.getT() == comparando.getT()) {
						comparando.setT(oisLeer.readObject());
					}
					oosEscribir.writeObject(comparando.getT());
					comparando.setT(oisLeer.readObject());
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					if(oisLeer != null) {oisLeer.close();}
					if(fisLeer != null) {fisLeer.close();}
					if(fosEscribir != null) {fosEscribir.close();}
					if(oosEscribir != null) {oosEscribir.close();}
				} catch (IOException e) {
					//e.printStackTrace();
				}
				
			}
		}
		return correcto;
	}
}
