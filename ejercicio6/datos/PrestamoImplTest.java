package datos;


import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class PrestamoImplTest {

	@Test
	public void testPrestamoImpl() {
		//fail("Not yet implemented");
		PrestamoImpl prueba = new PrestamoImpl();
		PrestamoImpl prueba1 = new PrestamoImpl(15, 16,"flipa");
		assertNotNull("Fallo el constructor por defecto",prueba);
		assertNotNull("Fallo el constructor por parametros",prueba1);
	}

	@Test
	public void testGetCodigoAlumno() {
		//fail("Not yet implemented");
		PrestamoImpl prueba = new PrestamoImpl(15, 16,"flipa");
		assertEquals("Fallo el getCodigoAlumno",15,prueba.getCodigoUsuario());
	}

	@Test
	public void testGetCodigoDocumento() {
		//fail("Not yet implemented");
		PrestamoImpl prueba = new PrestamoImpl(15, 16,"flipa");
		assertEquals("Fallo el getCodigoDocumento",16,prueba.getCodigoDocumento());
	}

	@Test
	public void testGetDiaDelPrestamo() {
		//fail("Not yet implemented");
		PrestamoImpl prueba = new PrestamoImpl(15, 16,"flipa");
		assertEquals("Fallo el getDiaDelPrestamo",LocalDate.now() ,prueba.getDiaDelPrestamo());
	}

	@Test//se testeara despues de setDiaDevolucion y setDiaDelPrestamo
	public void testGetDiasEnPrestamo() {
		//fail("Not yet implemented");
		PrestamoImpl prueba = new PrestamoImpl(15, 16,"flipa");
		prueba.setDiaDelPrestamo(LocalDate.now().minusDays(6));
		//System.out.println(prueba.getDiasEnPrestamo());
		prueba.setDiaDevolucion(LocalDate.now().minusDays(3));
		//System.out.println(prueba.getDiasEnPrestamo());
		//System.out.println(prueba.getDiaDelPrestamo()+"  "+prueba.getDiaDevolucion());
		assertEquals("Fallo el getDiasEnPrestamo",3,prueba.getDiasEnPrestamo());
	}

	@Test//se extendera el testeo despues de testear los setters
	public void testGetDiaDevolucion() {
		//fail("Not yet implemented");
		PrestamoImpl prueba = new PrestamoImpl(15, 16,"flipa");
		assertNull("Fallo el getDiaDevolucion",prueba.getDiaDevolucion());
		prueba.setDiaDelPrestamo(LocalDate.now().minusDays(22));
		prueba.setDiaDevolucion(LocalDate.now().minusDays(15));
		assertEquals("Fallo el getDiaDevolucion",LocalDate.now().minusDays(15),prueba.getDiaDevolucion());
	}

	@Test
	public void testSetCodigoAlumno() {
		//fail("Not yet implemented");
		PrestamoImpl prueba = new PrestamoImpl(15, 16,"flipa");
		prueba.setCodigoUsuario(22);
		assertEquals("Fallo el getCodigoAlumno",22 ,prueba.getCodigoUsuario());
	}

	@Test
	public void testSetCodigoDocumento() {
		//fail("Not yet implemented");
		PrestamoImpl prueba = new PrestamoImpl(15, 16,"flipa");
		prueba.setCodigoDocumento(22);
		assertEquals("Fallo el getCodigoDocumento",22 ,prueba.getCodigoDocumento());
	}

	@Test
	public void testSetDiaDelPrestamo() {
		//fail("Not yet implemented");
		PrestamoImpl prueba = new PrestamoImpl(15, 16,"flipa");
		prueba.setDiaDelPrestamo(LocalDate.now().minusDays(6));
		assertEquals("Fallo el getDiaDelPrestamo",LocalDate.now().minusDays(6),prueba.getDiaDelPrestamo());
	}

	@Test
	public void testSetDiaDevolucion() {
		//fail("Not yet implemented");
		PrestamoImpl prueba = new PrestamoImpl(15, 16,"flipa");
		prueba.setDiaDevolucion(LocalDate.now().plusDays(5));
		assertEquals("Fallo el getDiaDevolucion",LocalDate.now().plusDays(5),prueba.getDiaDevolucion());
	}

	@Test
	public void testEqualsObject() {
		//fail("Not yet implemented");
		PrestamoImpl prueba = new PrestamoImpl(15, 16,"flipa");
		prueba.setDiaDelPrestamo(LocalDate.now().minusDays(22));
		prueba.setDiaDevolucion(LocalDate.now().minusDays(15));
		PrestamoImpl prueba1 = new PrestamoImpl(12, 11,"flipa");
		prueba1.setDiaDelPrestamo(LocalDate.now().minusDays(23));
		prueba1.setDiaDevolucion(LocalDate.now().minusDays(15));
		assertEquals("Fallo el EqualsObject",true,prueba1.equals(prueba1));
		assertEquals("Fallo el EqualsObject",false,prueba.equals(prueba1));
	}

	@Test
	public void testCompareTo() {
		//fail("Not yet implemented");
		PrestamoImpl prueba = new PrestamoImpl(15, 16,"flipa");
		PrestamoImpl prueba1 = new PrestamoImpl(14, 16,"flipa");
		
		prueba.setDiaDelPrestamo(LocalDate.now().minusDays(22));
		//prueba.setDiaDevolucion(LocalDate.now().minusDays(15));
		prueba1.setDiaDelPrestamo(LocalDate.now().minusDays(22));
		//prueba1.setDiaDevolucion(LocalDate.now().minusDays(15));
		//compruebo diferencias en codigoAlumno
		assertEquals("Fallo el testCompareTo",0,prueba1.compareTo(prueba1));
		assertEquals("Fallo el testCompareTo",1,prueba.compareTo(prueba1));
		assertEquals("Fallo el testCompareTo",-1,prueba1.compareTo(prueba));
		prueba1.setCodigoUsuario(15);
		//Compruebo diferencias en codigoDocumento
		prueba1.setCodigoDocumento(11);
		assertEquals("Fallo el testCompareTo",0,prueba1.compareTo(prueba1));
		assertEquals("Fallo el testCompareTo",1,prueba.compareTo(prueba1));
		assertEquals("Fallo el testCompareTo",-1,prueba1.compareTo(prueba));
		prueba1.setCodigoDocumento(16);
		//Compruebo diferencias en diaDelPrestamo
		prueba1.setDiaDelPrestamo(LocalDate.now().minusDays(23));
		assertEquals("Fallo el testCompareTo",0,prueba1.compareTo(prueba1));
		assertEquals("Fallo el testCompareTo",1,prueba.compareTo(prueba1));
		assertEquals("Fallo el testCompareTo",-1,prueba1.compareTo(prueba));
		/*prueba1.setDiaDelPrestamo(LocalDate.now().minusDays(22));
		//Compruebo diferencias en diaDelPrestamo
		prueba1.setDiaDevolucion(LocalDate.now().minusDays(16));
		assertEquals("Fallo el testCompareTo",0,prueba1.compareTo(prueba1));
		assertEquals("Fallo el testCompareTo",1,prueba.compareTo(prueba1));
		assertEquals("Fallo el testCompareTo",-1,prueba1.compareTo(prueba));*/
	}

	@Test
	public void testToString() {
		//fail("Not yet implemented");
		PrestamoImpl prueba = new PrestamoImpl(15, 16,"flipa");
		prueba.setDiaDelPrestamo(LocalDate.now().minusDays(22));
		prueba.setDiaDevolucion(LocalDate.now().minusDays(15));
		String testeando = "("+prueba.getCodigoUsuario()+","+prueba.getCodigoDocumento()+","+prueba.getEspecialidad()+","+prueba.getDiaDelPrestamo()+","+prueba.getDiaDevolucion()+","+prueba.getDiasEnPrestamo()+")";
		assertEquals("No funciono el toString",testeando,prueba.toString());
	}

	@Test
	public void testMostrar() {
		//fail("Not yet implemented");
		PrestamoImpl prueba = new PrestamoImpl(15, 16,"flipa");
		prueba.setDiaDelPrestamo(LocalDate.now().minusDays(22));
		prueba.setDiaDevolucion(LocalDate.now().minusDays(15));
		String testeando = "Codigo del Alumno: "+prueba.getCodigoUsuario()+"\nCodigo del documento: "+prueba.getCodigoDocumento()+"\nEspecialidad Documento: "+prueba.getEspecialidad()+"\nDia inicio del prestamo: "
				 +prueba.getDiaDelPrestamo()+"\nDia de la devolucion: "+prueba.getDiaDevolucion()+"\nDias prestado: "+prueba.getDiasEnPrestamo();
		assertEquals("No funciono el mostrar",testeando,prueba.mostrar());
	}

}
