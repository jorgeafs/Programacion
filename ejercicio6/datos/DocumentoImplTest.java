package datos;


import static org.junit.Assert.*;

import org.junit.Test;

public class DocumentoImplTest {

	@Test
	public void testDocumentoImpl() {
		//fail("Not yet implemented");
		DocumentoImpl prueba = new DocumentoImpl();
		assertNotNull("No funciono el constructor por defecto",prueba);
		//System.out.println(prueba.getCodigo());
		DocumentoImpl prueba1 = new DocumentoImpl("Humanidades", "Historia Antigua", "libro", 15, 5);
		assertNotNull("No funciono el constructor por parametros",prueba1);
	}

	@Test
	public void testGetCodigoDocumento() {
		//fail("Not yet implemented");
		DocumentoImpl prueba = new DocumentoImpl("Humanidades", "Historia Antigua", "libro", 15, 5);
		assertEquals("No funciono el getCodigoDocumento", 13, prueba.getCodigoDocumento());
	}

	@Test
	public void testGetArea() {
		//fail("Not yet implemented");
		DocumentoImpl prueba = new DocumentoImpl("Humanidades", "Historia Antigua", "libro", 15, 5);
		assertEquals("No funciono el getArea", "Humanidades", prueba.getArea());
	}

	@Test
	public void testGetCodigo() {
		//fail("Not yet implemented");
		DocumentoImpl prueba5 = new DocumentoImpl("Humanidades", "Historia Antigua", "libro", 15, 5);
		assertEquals("No funciono el getCodigo", 3, prueba5.getCodigo());
		//System.out.println(prueba5);
	}

	@Test
	public void testGetEspecialidad() {
		//fail("Not yet implemented");
		DocumentoImpl prueba = new DocumentoImpl("Humanidades", "Historia Antigua", "libro", 15, 5);
		assertEquals("No funciono el getEspecialidad", "Historia Antigua", prueba.getEspecialidad());
	}

	@Test
	public void testGetFormato() {
		//fail("Not yet implemented");
		DocumentoImpl prueba = new DocumentoImpl("Humanidades", "Historia Antigua", "libro", 15, 5);
		assertEquals("No funciono el getFormato", "libro", prueba.getFormato());
	}

	@Test
	public void testGetNumeroEjemplares() {
		//fail("Not yet implemented");
		DocumentoImpl prueba = new DocumentoImpl("Humanidades", "Historia Antigua", "libro", 15, 5);
		assertEquals("No funciono el getNumeroEjemplares", 15, prueba.getNumeroEjemplares());
	}

	@Test
	public void testGetTipoPrestamo() {
		//fail("Not yet implemented");
		DocumentoImpl prueba = new DocumentoImpl("Humanidades", "Historia Antigua", "libro", 15, 5);
		assertEquals("No funciono el getTipoPrestamo", 5, prueba.getTipoPrestamo());
	}

	@Test
	public void testSetArea() {
		//fail("Not yet implemented");
		DocumentoImpl prueba = new DocumentoImpl("Humanidades", "Historia Antigua", "libro", 15, 5);
		prueba.setArea("Bellas Artes");
		assertEquals("No funciono el setArea", "Bellas Artes", prueba.getArea());
	}
 
	@Test
	public void testSetCodigo() {
		//fail("Not yet implemented");
		DocumentoImpl prueba = new DocumentoImpl();
		prueba.setCodigoDocumento(0);
		prueba = new DocumentoImpl();
		assertEquals("No funciono el setCodigoDocumento", 1, prueba.getCodigo());
	}

	@Test
	public void testSetEspecialidad() {
		//fail("Not yet implemented");
		DocumentoImpl prueba6 = new DocumentoImpl("Humanidades", "Historia Antigua", "libro", 15, 5);
		prueba6.setEspecialidad("nada");
		assertEquals("No funciono el setEspecialidad", "nada", prueba6.getEspecialidad());
	}

	@Test
	public void testSetFormato() {
		//fail("Not yet implemented");
		DocumentoImpl prueba6 = new DocumentoImpl("Humanidades", "Historia Antigua", "libro", 15, 5);
		prueba6.setFormato("nada");
		assertEquals("No funciono el setFormato", "nada", prueba6.getFormato());
	}

	@Test
	public void testSetNumeroEjemplares() {
		//fail("Not yet implemented");
		DocumentoImpl prueba6 = new DocumentoImpl("Humanidades", "Historia Antigua", "libro", 15, 5);
		prueba6.setNumeroEjemplares(0);
		assertEquals("No funciono el setNumeroEjemplares", 0, prueba6.getNumeroEjemplares());
	}

	@Test
	public void testSetTipoPrestamo() {
		//fail("Not yet implemented");
		DocumentoImpl prueba6 = new DocumentoImpl("Humanidades", "Historia Antigua", "libro", 15, 5);
		prueba6.setTipoPrestamo(0);
		assertEquals("No funciono el setTipoPrestamo", 0, prueba6.getTipoPrestamo());
	}

	@Test
	public void testToString() {
		//fail("Not yet implemented");
		DocumentoImpl prueba = new DocumentoImpl("Humanidades", "Historia Antigua", "libro", 15, 5);
		String testeando = "("+prueba.getCodigo()+","+prueba.getArea()+","+prueba.getEspecialidad()+","+prueba.getFormato()+","+prueba.getTipoPrestamo()+","+prueba.getNumeroEjemplares()+")";
		assertEquals("No funciono el toString", testeando, prueba.toString());
	}

	@Test
	public void testEqualsObject() {
		//fail("Not yet implemented");
		DocumentoImpl prueba = new DocumentoImpl("Humanidades", "Historia Antigua", "libro", 15, 5);
		DocumentoImpl prueba7 = new DocumentoImpl("Ciencias Politicas", "Historia Antigua", "libro", 15, 5);
		assertEquals("No funciono el equals",true,prueba.equals(prueba));
		assertEquals("No funciono el equals",false,prueba.equals(prueba7));
	}

	@Test
	public void testCompareTo() {
		//fail("Not yet implemented");
		DocumentoImpl prueba = new DocumentoImpl("Humanidades", "Historia Antigua", "libro", 15, 5);
		DocumentoImpl prueba7 = new DocumentoImpl("Ciencias Politicas", "Historia Antigua", "libro", 15, 5);
		assertEquals("No funciono el compareTo",0,prueba.compareTo(prueba));
		assertEquals("No funciono el compareTo",-1,prueba.compareTo(prueba7));
		assertEquals("No funciono el compareTo",1,prueba7.compareTo(prueba));
	}

	@Test
	public void testMostrar() {
		//fail("Not yet implemented");
		DocumentoImpl prueba = new DocumentoImpl("Humanidades", "Historia Antigua", "libro", 15, 5);
		String testeando = "Codigo documento: "+prueba.getCodigo()+"\nArea: "+prueba.getArea()+"\nEpecialidad: "+prueba.getEspecialidad()+"\nFormato: "+prueba.getFormato()
		+"\nTipo prestamo: "+prueba.getTipoPrestamo()+"\nNumero Ejemplares: "+prueba.getNumeroEjemplares();
		assertEquals("No funciono el mostrar",testeando,prueba.mostrar());
	}

}
