package datos;


import static org.junit.Assert.*;

import java.time.*;

import org.junit.Test;

public class UsuarioImplTest {

	@Test
	public void testUsuarioImpl() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = null;
		assertNull("El objeto ha sido inicializado a null", prueba);
		prueba = new UsuarioImpl();
		assertNotNull("Lo inicializamos con el constructor por defecto", prueba);
		UsuarioImpl prueba1 = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5,0, LocalDate.of(2015,2,15),0);
		assertNotNull("Declaramos e inicializamos prueba1 con el constructor con parametros", prueba1);
		assertNotEquals(prueba, prueba1);
	}

	@Test
	public void testGetCodigo() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 0, LocalDate.of(2015,2,15),0);
		assertEquals("No funciono el getCodigo",3,prueba.getCodigo());
		//porque anteriormente cree dos objetos, tener en cuenta cuando creemos nuevos usuarios para añadirlos al fichero
		//de usuarios.
	}

	@Test
	public void testGetNombre() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 0,LocalDate.of(2015,2,15),0);
		assertEquals("No funciono el getNombre","Pepito",prueba.getNombre());
	}

	@Test
	public void testGetApellido1() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 0, LocalDate.of(2015,2,15),0);
		assertEquals("No funciono el getApellido1","Grillo",prueba.getApellido1());
	}

	@Test
	public void testGetApellido2() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 0, LocalDate.of(2015,2,15),0);
		assertEquals("No funciono el getApellido2","solo",prueba.getApellido2());
	}

	@Test
	public void testGetDni() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 0, LocalDate.of(2015,2,15),0);
		assertEquals("No funciono el getDni","27744569",prueba.getDni());
	}

	@Test
	public void testGetNumeroMaximoPrestamos() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 0, LocalDate.of(2015,2,15),0);
		assertEquals("No funciono el getNumeroMaximoPrestamos",5,prueba.getNumeroMaximoPrestamos());
	}

	@Test
	public void testGetNumeroPrestamos() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 4, LocalDate.of(2015,2,15),0);
		assertEquals("No funciono el getNumeroPrestamos",4,prueba.getNumeroPrestamos());
	}

	@Test
	public void testGetLevantamientoSuspension() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 4, LocalDate.of(2015,2,15),0);
		assertEquals("No funciono el getPeriodoSuspension", LocalDate.of(2015,2,15),prueba.getInicioSuspension());
	}

	@Test
	public void testSetLevantamientoSuspension() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 4, LocalDate.of(2015,2,15),0);
		prueba.setInicioSuspension(LocalDate.now());
		assertEquals("No funciono el getPeriodoSuspension",LocalDate.now(),prueba.getInicioSuspension());
	}

	@Test
	public void testSetCodigoApoyo() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 4, LocalDate.of(2015,2,15),0);
		prueba.setCodigoApoyo(0);
		UsuarioImpl prueba1 = new UsuarioImpl("Luisito", "Grillo", "solo", "27744569", 5, 4, LocalDate.of(2015,2,15),0);
		assertEquals("No funciono el setCodigoApoyo",1,prueba1.getCodigo());
		UsuarioImpl prueba2 = new UsuarioImpl("Luisito", "Grillo", "solo", "27744569", 5, 4, LocalDate.of(2015,2,15),0);
		assertEquals("No funciono el setCodigoApoyo",2,prueba2.getCodigo());
	}

	@Test
	public void testSetNombre() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 4, LocalDate.of(2015,2,15),0);
		prueba.setNombre("Joselito");
		assertEquals("No funciono el setNombre","Joselito",prueba.getNombre());
	}

	@Test
	public void testSetApellido1() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 4, LocalDate.of(2015,2,15),0);
		prueba.setApellido1("Gamez");
		assertEquals("No funciono el setApellido1","Gamez",prueba.getApellido1());
	}

	@Test
	public void testSetApellido2() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 4, LocalDate.of(2015,2,15),0);
		prueba.setApellido2("Gamez");
		assertEquals("No funciono el setApellido2","Gamez",prueba.getApellido2());
	}

	@Test
	public void testSetDni() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 4, LocalDate.of(2015,2,15),0);
		prueba.setDni("11155566");
		assertEquals("No funciono el setDni","11155566",prueba.getDni());
	}

	@Test
	public void testSetNumeroPrestamos() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 4, LocalDate.of(2015,2,15),0);
		prueba.setNumeroPrestamos(1);
		assertEquals("No funciono el setNumeroPrestamos",1,prueba.getNumeroPrestamos());
	}

	@Test
	public void testEqualsUsuarioImpl() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 4, LocalDate.of(2015,2,15),0);
		assertEquals("No funciono el EqualsUsuarioImpl",prueba,prueba);
		UsuarioImpl prueba1 = new UsuarioImpl("Luisito", "Grillo", "solo", "27744569", 5, 4, LocalDate.of(2015,2,15),0);
		assertNotEquals("No funciono el EqualsUsuarioImpl", prueba, prueba1);
	}

	@Test
	public void testCompareTo() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 4, LocalDate.of(2015,2,15),0);
		UsuarioImpl prueba1 = new UsuarioImpl("Luisito", "Grillo", "solo", "27744569", 5, 4, LocalDate.of(2015,2,15),0);
		assertEquals("No funciono el compareTo", 0, prueba1.compareTo(prueba1));
		assertEquals("No funciono el compareTo",-1,prueba.compareTo(prueba1));
		assertEquals("No funciono el compareTo",1,prueba1.compareTo(prueba));
	}

	@Test
	public void testToString() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 4, LocalDate.of(2015,2,15),0);
		assertEquals("No funciono el toString","(2,Pepito,Grillo,solo,27744569,4,5,"+LocalDate.of(2015,2,15)+",0)",prueba.toString());
	}

	@Test
	public void testMostrar() {
		//fail("Not yet implemented");
		UsuarioImpl prueba = new UsuarioImpl("Pepito", "Grillo", "solo", "27744569", 5, 4, LocalDate.of(2015,2,15),0);
		String test = "Codigo: "+prueba.getCodigo()+"\nNombre: "+prueba.getNombre()+"\nApellidos: "+prueba.getApellido1()+" "+prueba.getApellido2()+"\nDNI: "+prueba.getDni()+
				"\nNumero de documentos prestados: "+prueba.getNumeroPrestamos()+"\nNumero maximo de prestamos permitidos: "+prueba.getNumeroMaximoPrestamos()+
				"\nDia Inicio suspension: "+prueba.getInicioSuspension()+"\nPeriodo suspension: "+prueba.getPeriodoSuspension();
		assertEquals("No funciono el mostrar",test,prueba.mostrar());
		
	}

}
