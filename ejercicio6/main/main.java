package main;

import java.util.*;

import datos.*;
import gestion.*;


/**Analisis:
 * 	El programa gestiona el prestamo de una biblioteca, ademas de permitir realizar las siguientes consultas sobre el uso:
 * 		Libro mas prestado, en general y por situacion e historico
 * 		Especialidad mas consultada, en general y por situacion e historico
 * 		Mostrar los alumnos pendientes de devolucion
 * 		
 * Pseudocodigo Generalizado:
 * 	INICIO
 * 		Hacer
 * 			Mostrar Menu 		
 * 			Segun Opcion
 * 				Opcion 1
 * 					Realizar/Devolver Prestamo
 * 				Opcion 2
 * 					Mostrar libro mas prestado
 * 				Opcion 3
 * 					Mostrar especialidad mas consultada
 * 				Opcion 4
 * 					Mostrar Alumnos pendientes de Devolucion
 * 			Fin segun
 * 		Mientras el usuario quiera seguir
 * 	FIN
 *
 */

public class main {

	public static void main (String[] args) {
		Scanner leer = new Scanner(System.in);
		int opcion, submenu,codigoAlu,codigoLib, menuPrestar, contador;
		String nombre, apellido1, apellido2, especialidad;
		PrestamoImpl apoyo = new PrestamoImpl();
		ArrayList<PrestamoImpl> prestamo = new ArrayList<PrestamoImpl>(), prestamoAux = new ArrayList<PrestamoImpl>();
		GestionPrestamos<AlumnoImpl> auxL = new GestionPrestamos<AlumnoImpl>();
		ArrayList<LibroImpl> apoyoL;
		GestionPrestamos<String> auxS = new GestionPrestamos<String>();
		ArrayList<String> apoyoS;
		GestionPrestamos<AlumnoImpl> auxA = new GestionPrestamos<AlumnoImpl>();
		ArrayList<AlumnoImpl> apoyoA;
		//INICIO
		//Hacer
		do{
		//Mostrar Menu
			do{
				mostrarMenu();
				opcion = leer.nextInt();
			}while(opcion<1 || opcion>5);
		//Segun Opcion
			switch (opcion) {
		//Opcion 1
		//Realizar/Devolver Prestamo
			case 1:
				contador=0;
				do{
				System.out.println("Por favor identifiquese, introduzca su nombre");
				leer.nextLine();
				nombre = leer.nextLine();
				System.out.println("Por favor introduzca su primer apellido");
				apellido1=leer.nextLine();
				System.out.println("Por favor introduzca su segundo apellido");
				apellido2=leer.nextLine();
				codigoAlu=new GestionPrestamos<AlumnoImpl>().identificarAlumno(nombre, apellido1, apellido2, Constantes.ALUMNOS);
				contador++;
				if(codigoAlu == -1 && contador<2){
					System.out.println("\nTiene "+(3-contador)+" oportunidad/es ó volvera al menu principal");
				} else if (contador==2) {
					System.out.println("\nEs su ultima oportunidad ó volvera al menu principal");
				}
				}while(codigoAlu == -1 && contador<3); //codigoAlu distinto de -1 o contador mayor que 3
				if(codigoAlu!=-1) {
				do{
					mostrarSubmenu();
					//System.out.println("Esta utilidad todavia no esta implementada");
					submenu = leer.nextInt();
				}while(submenu<1||submenu>3);
				switch(submenu) {
				case 1:
					do {
						do {
							menuPrestamo();
							menuPrestar = leer.nextInt();
						} while (menuPrestar<1 || menuPrestar>2);
						if(menuPrestar ==1) {

							new GestionPrestamos<>().listarLibrosDisponibles(Constantes.LIBROS);
							System.out.println("Introduzca el codigo del libro");
							codigoLib=leer.nextInt();
							especialidad =  new GestionPrestamos<String>().obtenerEspecialidad(codigoLib);
							apoyo = new PrestamoImpl(codigoAlu,codigoLib,especialidad);
							prestamo.add(apoyo);
						}
					}while (menuPrestar != 2);
					prestamoAux = new GestionPrestamos<PrestamoImpl>().realizarPrestamo(prestamo, Constantes.ALUMNOS, Constantes.LIBROS);
					for (PrestamoImpl prestamoImpl : prestamoAux) {
						System.out.println("\nNo se pudo/pudieron realizar el/los siguiente/s prestamo/s\n"+prestamoImpl);
					}
					break;
				case 2:
					do {
						do {
							menuDevolucion();
							menuPrestar = leer.nextInt();
						} while (menuPrestar<1 || menuPrestar>2);
						if(menuPrestar ==1) {

							if(new GestionPrestamos<>().listarLibrosADevolver(codigoAlu, Constantes.LIBROS)){
							System.out.println("Introduzca el codigo del libro");
							codigoLib=leer.nextInt();
							//System.out.println("Introduzca la especialidad del libro");
							//leer.nextLine();
							//especialidad =  leer.nextLine();
							apoyo = new PrestamoImpl(codigoAlu,codigoLib);
							prestamo.add(apoyo);
							} else {
								System.out.println("No hay libros a devolver");
							}
						}
					}while (menuPrestar != 2);
					if(new GestionPrestamos<PrestamoImpl>().devolverPrestamo(prestamo, Constantes.ALUMNOS, Constantes.LIBROS)){
						System.out.println("Se devolvieron con exito");
					} else {
						System.out.println("Ocurrio algun error en la devolucion, pongase en contacto con el personal de la biblioteca");
					}
					break;
				}
			}				
			break;
		//Opcion 2
		//Mostrar libro mas prestado
			case 2:
				apoyoL = auxL.libroMasPrestado();
				for (LibroImpl aux : apoyoL) {
					System.out.println(aux.toString()+"\n");
				}
				break;
		//Opcion 3
		//Mostrar especialidad mas consultada
			case 3:
				apoyoS = auxS.especialidadMasConsultada();
				System.out.println("\nAhora muestro la/s especialidad mas consultada/s\n");
				for (String string : apoyoS) {
					System.out.println(string+"\n");
				}
				break;
		//Opcion 4
		//Mostrar Alumnos pendientes de Devolucion
			case 4:
				apoyoA = auxA.alumnosDevPendientes(Constantes.ALUMNOS);
				for(AlumnoImpl aux : apoyoA) {
					System.out.println(aux.toString()+"\n");
				}
				break;
		//Fin segun
			}
		//Mientras el usuario quiera seguir
		} while(opcion != 5);
		leer.close();
		//FIN
	}

	private static void mostrarMenu() {
		System.out.println("\nPor favor elija una de las opciones a continuacion:"
				+ "\n1\\) Prestar ó devolver libros"
				+ "\n2\\) Mostrar libro/s mas prestado/s"
				+ "\n3\\) Mostrar especialidad/es mas consultada/s"
				+ "\n4\\) Mostrar alumno/s pendiente/s de devolucion"
				+ "\n5\\) Salir");
	}
	private static void mostrarSubmenu() {
		System.out.println("\nPor favor elija una de las opciones a continuacion:"
				+ "\n1\\) Prestar"
				+ "\n2\\) Devolver"
				+ "\n3\\) Salir");
	}
	private static void menuPrestamo() {
		System.out.println("\nPor favor elija una de las opciones a continuacion:"
				+ "\n1\\) Seguir añadiendo libro a prestar"
				+ "\n2\\) Terminar y salir");
	}
	private static void menuDevolucion() {
		System.out.println("\nPor favor elija una de las opciones a continuacion:"
				+ "\n1\\) Seguir añadiendo libro a devolver"
				+ "\n2\\) Terminar y salir");
	}



}
