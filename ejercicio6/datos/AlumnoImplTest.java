package datos;


import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class AlumnoImplTest {
	@Test
	public void testAlumnoImpl() {
		//fail("Not yet implemented");
		AlumnoImpl prueba = new AlumnoImpl();
		assertNotNull("No funciona el constructor pordefecto",prueba);
		AlumnoImpl prueba1 = new AlumnoImpl("Pepito", "Grillo", "solo", "27744569", 5, 0, LocalDate.now(),0, "medicina");
		assertNotNull("No funciona el constructor pordefecto",prueba1);
	}

	@Test
	public void testGetCarrera() {
		//fail("Not yet implemented");
		AlumnoImpl prueba1 = new AlumnoImpl("Pepito", "Grillo", "solo", "27744569", 5, 0, LocalDate.now(),0, "medicina");
		assertEquals("No funciona el getCarrera","medicina",prueba1.getCarrera());
	}

	@Test
	public void testSetCarrera() {
		//fail("Not yet implemented");
		AlumnoImpl prueba1 = new AlumnoImpl("Pepito", "Grillo", "solo", "27744569", 5, 0, LocalDate.now(),0, "medicina");
		prueba1.setCarrera("historia");
		assertEquals("No funciona el setCarrera","historia",prueba1.getCarrera());
	}
	
	@Test
	public void testToString() {
		//fail("Not yet implemented");
		AlumnoImpl prueba1 = new AlumnoImpl("Pepito", "Grillo", "solo", "27744569", 5, 0, LocalDate.now(),0, "medicina");
		assertEquals("No funciona el toString","(4,Pepito,Grillo,solo,27744569,0,5,"+LocalDate.now()+",0,medicina)",prueba1.toString());
	}

	@Test
	public void testMostrar() {
		//fail("Not yet implemented");
		AlumnoImpl prueba = new AlumnoImpl("Pepito", "Grillo", "solo", "27744569", 5, 0, LocalDate.now(),0, "medicina");
		String test = "Codigo: "+prueba.getCodigo()+"\nNombre: "+prueba.getNombre()+"\nApellidos: "+prueba.getApellido1()+" "+prueba.getApellido2()+"\nDNI: "+prueba.getDni()+
				"\nNumero de documentos prestados: "+prueba.getNumeroPrestamos()+"\nNumero maximo de prestamos permitidos: "+prueba.getNumeroMaximoPrestamos()+
				"\nDia Inicio suspension: "+prueba.getInicioSuspension()+"\nPeriodo suspension: "+prueba.getPeriodoSuspension()+"\nCarrera: "+prueba.getCarrera();
		assertEquals("No funciono el mostrar",test,prueba.mostrar());
	}

}
