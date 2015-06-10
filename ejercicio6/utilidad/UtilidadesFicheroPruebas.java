package utilidad;
/**utilidadesFichero
 * 	propiedades:
 * 		aG(apoyoGeneralizado)	-->	básica, tipo generica
 * 									modificable --> si
 * 									consultable --> si
 * 	 
 */

import java.io.*;
import java.util.*;

public class UtilidadesFicheroPruebas<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//parametro generico
	private T aG;//aG significa apoyoGenerico... pero es mas corto con dos letras
	
	//constructor por defecto
	public UtilidadesFicheroPruebas(){
		this.aG = null;
	}
	
	//Gets y sets
	public T getAG(){
		return this.aG;
	}
	public void setAG(T nAG){
		this.aG = nAG;
	}
	
	//metodos
	public String toString() {
        return aG.toString();
    }
	

	/**Interfaz crearFichero
	 * Cabecera: public boolean crearFichero (UtilidadesFichero<String> nombreFichero)
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
		ObjectOutputStream escribir = null;
		
		if(nuevoFichero.isFile() != true){
			try {
				correcto = nuevoFichero.createNewFile();
				FileOutputStream fos = new FileOutputStream (nuevoFichero);
				escribir = new ObjectOutputStream (fos);
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("Fallo la creacion");
			} finally {
				try{
					if(escribir != null){ escribir.close();}
				} catch (IOException e) {
					//e.printStackTrace();
					System.out.println("No se pudo cerrar correctamente");
				}
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
		UtilidadesFicheroPruebas<Object> auxiliar = new UtilidadesFicheroPruebas<Object>(); 
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
				auxiliar.setAG(oisLectura.readObject());
				while(auxiliar.getAG() !=null) {
					oosCopia.writeObject(auxiliar.getAG());
					oosCopia.reset();
					//auxiliar = oisLectura.readObject();
					auxiliar.setAG(oisLectura.readObject());
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
	
	/**Interfaz ordenacionHibrida
	 * Cabecera: public boolean ordenacionHibrida(String desordenado, String ordenado)
	 * Comentario: Dado dos String que contienen la ruta de dos archivos, uno desordenado y el otro donde se va a ordenar; realiza la ordenacion por el metodo hibrido
	 * Precondiciones: Ninguna
	 * Entrada: Dos String
	 * Salida: un boolean
	 * Postcondiciones: Devuelve un true si se ordena correctamente y false en caso de error o si alguno de los ficheros no existia
	*/
	public boolean ordenacionHibrida(String desordenado, String ordenado) {
		boolean correcto = false;
		UtilidadesFicheroPruebas<List<Object>> objetos = new UtilidadesFicheroPruebas<List<Object>>();
		if (new File(desordenado).isFile() & new File(ordenado).isFile()) {
			objetos = ordenarArray(desordenado);
			if (objetos.getAG()!= null) {
				FileOutputStream fosOrdenado = null;
				ObjectOutputStream oosOrdenado = null;
				try {
					fosOrdenado = new FileOutputStream(ordenado);
					oosOrdenado = new ObjectOutputStream(fosOrdenado);
					for (int i = 0; i < objetos.getAG().size(); i++) {
						oosOrdenado.writeObject(objetos.getAG().get(i));
						oosOrdenado.reset();
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
	
	/**Interfaz ordenarArray
	 * Cabecera: private UtilidadesFichero<List<Object>> ordenarArray(String desordenado)
	 * Comentario: Dado un String que contienen la ruta del archivo a ordenar; devuelve un UtilidadesFichero<List<Object>> con los objetos ordenados o null si ocurrio algun 
	 * error 
	 * Precondiciones: Ninguna
	 * Entrada: un String
	 * Salida: un UtilidadesFichero<List<Object>>
	 * Postcondiciones: devuelve un UtilidadesFichero<List<Object>> con los objetos ordenados o null si ocurrio algun error 
	*/
	public /*ArrayList<T>*/UtilidadesFicheroPruebas<List<Object>> ordenarArray(String desordenado) {
		/**ArrayList<T> origen = listarObjetos(desordenado), ordenado = new ArrayList<T>();
		T [] operar = (T[])origen.toArray();
		Collections.sort((List<T>) origen);Da problemas
		Arrays.sort(operar);
		for(int i = 0; i < operar.length ; i++){
			ordenado.add(operar[i]);
		}
		ordenado = (ArrayList<T>) Arrays.asList(operar);*/
		UtilidadesFicheroPruebas<List<Object>> ordenado = new UtilidadesFicheroPruebas<List<Object>>();
		UtilidadesFicheroPruebas<LinkedList<Object>> origen = new UtilidadesFicheroPruebas<LinkedList<Object>>();
		UtilidadesFicheroPruebas<Object[]> operar = new UtilidadesFicheroPruebas<Object[]>();
		origen = listarObjetos(desordenado);
		operar.setAG(origen.getAG().toArray());
		Arrays.sort(operar.getAG());
		ordenado.setAG(Arrays.asList(operar.getAG()));
		return ordenado;
	}

	/**Interfaz listarObjetos
	 * Cabecera: private /*ArrayList<T>* UtilidadesFichero<List<Object>> listarObjetos(String desordenado)
	 * Comentario: Dado un String que contienen la ruta del archivo a listar; devuelve un UtilidadesFichero<List<Object>> con los objetos en él o null si ocurrio algun 
	 * error 
	 * Precondiciones: Ninguna
	 * Entrada: un String
	 * Salida: un UtilidadesFichero<List<Object>>
	 * Postcondiciones: devuelve un UtilidadesFichero<List<Object>> con los objetos en él o null si ocurrio algun error 
	*/
	private UtilidadesFicheroPruebas<LinkedList<Object>> listarObjetos(String desordenado) {
		UtilidadesFicheroPruebas<LinkedList<Object>> devolver = new UtilidadesFicheroPruebas<LinkedList<Object>>();
		UtilidadesFicheroPruebas<Object> escribir = new UtilidadesFicheroPruebas<Object>();
		LinkedList<Object> apoyo = new LinkedList<Object>();
		
		FileInputStream fisLectura = null;
		ObjectInputStream oisLectura = null;
		
		try {
			fisLectura = new FileInputStream (desordenado);
			oisLectura = new ObjectInputStream (fisLectura);
			escribir.setAG(oisLectura.readObject());
			while(escribir.getAG() != null){
				//devolver.getAG().add(escribir.getAG());//aqui es donde tengo el problemilla
				try {
					apoyo.add(escribir.getAG());
					escribir.setAG(oisLectura.readObject());
				} catch (Exception e) {
					escribir.setAG(null);
					//e.printStackTrace();
				}
			}
			devolver.setAG(apoyo);
		} catch (IOException e) {
			System.out.println("Algo no ha funcionado");
			//e.printStackTrace();
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
	/**Interfaz escribirRegistroBinario
	 * Cabecera: public boolean escribirRegistroBinario(UtilidadesFichero<Object> introducir, String ficheroIntroducir)
	 * Comentario: Dado un UtilidadesFichero<Object> y un String que contienen la ruta del archivo en el que queremos escribir el objeto; true si se escribio correctamente
	 * y false en caso contrario o error
	 * error 
	 * Precondiciones: Ninguna
	 * Entrada: un String y un UtilidadesFichero<Object>
	 * Salida: un boolean
	 * Postcondiciones: devuelve un boolean como true si se escribio bien y false en caso contrario o error 
	*/
	public boolean escribirRegistroBinario(String aux, String ficheroIntroducir){
		boolean correcto= false;
		FileOutputStream fosEscribir = null;
		ObjectOutputStream oosEscribir = null;
		
		if (new File(ficheroIntroducir).isFile()){
			try{
				fosEscribir = new FileOutputStream(ficheroIntroducir,true);
				oosEscribir = new MiObjectOutputStream(fosEscribir);
				oosEscribir.writeObject(aux);
				correcto = true;
			}catch (IOException e) {
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
	
	/**Interfaz contieneElementos
	 * Cabecera: private boolean contieneElementos(String ficheroIntroducir)
	 * Comentario: Dado un String que contienen la ruta del archivo en el que queremos saber si contiene elementos; devolvera true si los  
	 * contiene y false en caso contrario o error
	 * Precondiciones: Ninguna
	 * Entrada: un String y un UtilidadesFichero<Object>
	 * Salida: un boolean
	 * Postcondiciones: devuelve un boolean como true si contiene elementos y false en caso contrario o error 
	*/
	private boolean contieneElementos(String ficheroIntroducir) {
		boolean devolver = false;
		FileInputStream fis = null;
		ObjectInputStream leer = null;
		try {
			fis = new FileInputStream(ficheroIntroducir);
			leer = new ObjectInputStream(fis);
			if(leer.readObject()!=null) {
				devolver = true;
			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			try {
				if(fis != null){ fis.close();}
				if(leer != null){ leer.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return devolver;
	}

	/**Interfaz borrarRegistroBinario
	 * Cabecera: public boolean borrarregistroBinario(UtilidadesFichero<Object> aBorrar, String ficheroBorrar)
	 * Comentario: Dado un UtilidadesFichero<Object> y un String que contienen la ruta del archivo en el que queremos borrar el objeto; devolvera true si se borro 
	 * correctamente y false en caso contrario o error
	 * Precondiciones: Ninguna
	 * Entrada: un String y un UtilidadesFichero<Object>
	 * Salida: un boolean
	 * Postcondiciones: devuelve un boolean como true si se borro bien y false en caso contrario o error 
	*/
	public boolean borrarregistroBinario(UtilidadesFicheroPruebas<? extends Object> aBorrar, String ficheroBorrar){
		boolean correcto = false;
		UtilidadesFicheroPruebas<Object> comparando = new UtilidadesFicheroPruebas<Object>();
		FileInputStream fisLeer = null;
		ObjectInputStream oisLeer = null;
		FileOutputStream fosEscribir = null;
		ObjectOutputStream oosEscribir = null;
		String apoyo = "apoyo.dat";
		crearFichero(apoyo);
		File Borrar = new File(ficheroBorrar), aux = new File(apoyo);
		
		if(new File(ficheroBorrar).isFile()){
			try {
				fisLeer = new FileInputStream(Borrar);
				oisLeer = new ObjectInputStream(fisLeer);
				fosEscribir = new FileOutputStream(aux);
				oosEscribir = new MiObjectOutputStream(fosEscribir);
				comparando.setAG(oisLeer.readObject());
				while(comparando != null) {
					if( aBorrar.getAG() == comparando.getAG()) {
						comparando.setAG(oisLeer.readObject());
					}
					oosEscribir.writeObject(comparando.getAG());
					oosEscribir.reset();
					comparando.setAG(oisLeer.readObject());
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
			borrarFichero(ficheroBorrar);
			aux.renameTo(Borrar);
			borrarFichero(apoyo);
			correcto = true;
		}
		return correcto;
	}
	
	/**leerFicheroObjetos
	 * Cabecera: 	public UtilidadesFicheroImpl<List<Objects>> leerFicheroObjetos (String ruta) 
	 * Comentario: Dada la ruta de un fichero, lo lee y almacena en un UtilidadesFichero<List<Objects>> que devuelve
	 * Precondiciones: Ninguna
	 * Entradas: un String
	 * Salidas: un UtilidadesFichero<List<Objects>>
	 * Postcondiciones: devuelve un UtilidadesFichero<List<Objects>> con el contenido del fichero y null si estaba vacio o en caso de error 
	 */
	public UtilidadesFicheroPruebas<LinkedList<Object>> leerFicheroObjetos(String desordenado) {
		UtilidadesFicheroPruebas<LinkedList<Object>> devolver = new UtilidadesFicheroPruebas<LinkedList<Object>>();
		UtilidadesFicheroPruebas<Object> escribir = new UtilidadesFicheroPruebas<Object>();
		LinkedList<Object> auxiliar = new LinkedList<Object>();
		
		FileInputStream fisLectura = null;
		ObjectInputStream oisLectura = null;
		
		try {
			fisLectura = new FileInputStream (desordenado);
			oisLectura = new ObjectInputStream (fisLectura);
			escribir.setAG(oisLectura.readObject());
			devolver.setAG(auxiliar);
			while(escribir.getAG() != null){
				devolver.getAG().add(escribir.getAG());//aqui es donde tengo el problemilla
				try {
					devolver.getAG().add(escribir.getAG());
					escribir.setAG(oisLectura.readObject());
				} catch (EOFException e) {
					escribir.setAG(null);
					//e.printStackTrace();
				}
			}
		} catch (IOException e) {
			System.out.println("Algo no ha funcionado");
			//e.printStackTrace();
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
	
	/**leerObjetoPuro
	 * Cabecera: public LinkedList<Object> leerObjetoPuro (String ruta)
	 * Comentario: Dado un String con la ruta del fichero a leer, devuelve una LinkedList con todos los objetos de la lista ó null si 
	 * existio algun error.
	 * Precondiciones: ninguna
	 * Entradas: Un String
	 * Salidas: una LinkedList
	 * Postcondiciones: Se devuelve una LinkedList con los objetos del fichero ó null si existio algun error
	 * 
	 * Observaciones: necesita un cast al tipo de objeto que estemos leyendo.... no se si me gusta
	 */
	
	public  LinkedList<T> leerObjetoPuro (String rutaAlum) {
		LinkedList<T> devolver = null;
		FileInputStream fisLeer = null;
		ObjectInputStream leer = null;
		
			if (new File(rutaAlum).isFile()) {
				try {
					fisLeer = new FileInputStream(rutaAlum);
					leer = new ObjectInputStream(fisLeer);
					devolver = new LinkedList<T>();
					try {
						setAG((T) leer.readObject());
						while (getAG() != null) {
							devolver.add(getAG());
							setAG((T) leer.readObject());
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (EOFException e) {
						setAG(null);
					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (leer != null) {
							leer.close();
						}
						if (fisLeer != null) {
							fisLeer.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}		
		return devolver;
	}
	
	/**Interfaz escribirRegistroBinario*
	 * Cabecera: public boolean escribirRegistroBinario(UtilidadesFichero<Object> introducir, String ficheroIntroducir)
	 * Comentario: Dado un UtilidadesFichero<Object> y un String que contienen la ruta del archivo en el que queremos escribir el objeto; true si se escribio correctamente
	 * y false en caso contrario o error
	 * error 
	 * Precondiciones: Ninguna
	 * Entrada: un String y un UtilidadesFichero<Object>
	 * Salida: un boolean
	 * Postcondiciones: devuelve un boolean como true si se escribio bien y false en caso contrario o error 
	*/
	//probando a escribir objetos puros
	/*public boolean escribirRegistroBinario(Object introducir, String ficheroIntroducir){
		boolean correcto= false;
		FileOutputStream fosEscribir = null;
		ObjectOutputStream oosEscribir = null;
		
		if (new File(ficheroIntroducir).isFile()){
			try{
				fosEscribir = new FileOutputStream(ficheroIntroducir,true);
				oosEscribir = new MiObjectOutputStream(fosEscribir);
				oosEscribir.writeObject(introducir);
				correcto = true;
			}catch (IOException e) {
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

	/**Interfaz escribirRegistroBinario*
	 * Cabecera: public boolean escribirRegistroBinario(UtilidadesFichero<Object> introducir, String ficheroIntroducir)
	 * Comentario: Dado un UtilidadesFichero<Object> y un String que contienen la ruta del archivo en el que queremos escribir el objeto; true si se escribio correctamente
	 * y false en caso contrario o error
	 * error 
	 * Precondiciones: Ninguna
	 * Entrada: un String y un UtilidadesFichero<Object>
	 * Salida: un boolean
	 * Postcondiciones: devuelve un boolean como true si se escribio bien y false en caso contrario o error 
	*/
	//probando a escribir objetos puros
	public boolean escribirRegistroBinario(T introducir, String ficheroIntroducir){
		boolean correcto= false;
		FileOutputStream fosEscribir = null;
		ObjectOutputStream oosEscribir = null;
		
		if (new File(ficheroIntroducir).isFile()){
			try{
				fosEscribir = new FileOutputStream(ficheroIntroducir,true);
				oosEscribir = new MiObjectOutputStream(fosEscribir);
				oosEscribir.writeObject(introducir);
				correcto = true;
			}catch (IOException e) {
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
	
}
