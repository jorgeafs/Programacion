package datos;

/**
 * Aqui defino las constantes referentes al numero maximo de prestamos, los tipos de prestamos y los formatos de los documentos.
 * 	El numero maximo de prestamos se refiere al numero total de documentos que puede sacar a la vez un usuario.
 *	El tipo de prestamo define el numero de dias que se puede sacar un documento y quien lo puede sacar
 * 	El formato define el tipo de formato en el que esta disponible el documento
 *
 */
public interface Constantes {
//Numero maximo de prestamos por usuario
int ALUMNO = 5;
//int profesor = 15; A dia de hoy no existe la clase profesor, pero se podria contemplar la existencia futura de esta clase y alguna mas de usuarios
//Tipo de prestamo
int SOLOCONSULTA = 0;
int RESTRINGIDO = 2;
int NORMAL = 5;
//int soloProfesores = 15;
//Formato de documentos
String LIBRO= "Libro";
//String dvd = "DVD";
//String vhs= "VHS";
//String electronico = "Electronico";
String PRESTAMOHSITORICO = "PrestHisto";
String PRESTAMOSITUACION = "PrestSitua";
int RESTRINGIDOMULTIPLO = 7;
int NORMALMULTIPLO = 2;


}
