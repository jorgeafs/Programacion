package datos;


import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class LibroImplTest {

	@Test
	public void testLibroImpl() {
		//fail("Not yet implemented");
		LibroImpl prueba = new LibroImpl();
		LibroImpl prueba1 = new LibroImpl("Historia", "Culto Romano", "electronico", 1, 0, "La religión del poder.  El culto imperial en Atenas en época de Augusto y los emperadores Julio-Claudios", "Fernando", "una", LocalDate.now().minusYears(10), 15, 1841713198L);
		assertNotNull("El constructor por defecto no funciono",prueba);
		assertNotNull("El constructor por parametros no funciono",prueba1);
	}

	@Test
	public void testGetTitulo() {
		//fail("Not yet implemented");
		LibroImpl prueba2 = new LibroImpl("Historia", "Culto Romano", "electronico", 1, 0, "La religión del poder.  El culto imperial en Atenas en época de Augusto y los emperadores Julio-Claudios", "Fernando", "una", LocalDate.now().minusYears(10), 15, 1841713198L);
		assertEquals("No funciono getTitulo","La religión del poder.  El culto imperial en Atenas en época de Augusto y los emperadores Julio-Claudios",prueba2.getTitulo());
	}

	@Test
	public void testGetAutor() {
		//fail("Not yet implemented");
		LibroImpl prueba3 = new LibroImpl("Historia", "Culto Romano", "electronico", 1, 0, "La religión del poder.  El culto imperial en Atenas en época de Augusto y los emperadores Julio-Claudios", "Fernando", "una", LocalDate.now().minusYears(10), 15, 1841713198L);
		assertEquals("No funciono getAutor","Fernando",prueba3.getAutor());
	}

	@Test
	public void testGetEditorial() {
		//fail("Not yet implemented");
		LibroImpl prueba4 = new LibroImpl("Historia", "Culto Romano", "electronico", 1, 0, "La religión del poder.  El culto imperial en Atenas en época de Augusto y los emperadores Julio-Claudios", "Fernando", "una", LocalDate.now().minusYears(10), 15, 1841713198L);
		assertEquals("No funciono getEditorial","una",prueba4.getEditorial());
	}

	@Test
	public void testGetEdicion() {
		//fail("Not yet implemented");
		LocalDate testeando = LocalDate.now().minusYears(10);
		LibroImpl prueba5 = new LibroImpl("Historia", "Culto Romano", "electronico", 1, 0, "La religión del poder.  El culto imperial en Atenas en época de Augusto y los emperadores Julio-Claudios", "Fernando", "una", testeando, 15, 1841713198L);
		assertEquals("No funciono getEdicion",testeando,prueba5.getEdicion());
	}

	@Test
	public void testGetReimpresion() {
		//fail("Not yet implemented");
		LibroImpl prueba6 = new LibroImpl("Historia", "Culto Romano", "electronico", 1, 0, "La religión del poder.  El culto imperial en Atenas en época de Augusto y los emperadores Julio-Claudios", "Fernando", "una", LocalDate.now().minusYears(10), 15, 1841713198L);
		assertEquals("No funciono getReimpresion",15,prueba6.getReimpresion());
	}

	@Test
	public void testGetIsbn() {
		//fail("Not yet implemented");
		LibroImpl prueba7 = new LibroImpl("Historia", "Culto Romano", "electronico", 1, 0, "La religión del poder.  El culto imperial en Atenas en época de Augusto y los emperadores Julio-Claudios", "Fernando", "una", LocalDate.now().minusYears(10), 15, 1841713198L);
		assertEquals("No funciono getIsbn",1841713198L,prueba7.getIsbn());
	}

	@Test
	public void testSetTitulo() {
		//fail("Not yet implemented");
		LibroImpl prueba8 = new LibroImpl("Historia", "Culto Romano", "electronico", 1, 0, "La religión del poder.  El culto imperial en Atenas en época de Augusto y los emperadores Julio-Claudios", "Fernando", "una", LocalDate.now().minusYears(10), 15, 1841713198L);
		prueba8.setTitulo("La religion del poder");
		assertEquals("No funciono setTitulo","La religion del poder",prueba8.getTitulo());
	}

	@Test
	public void testSetAutor() {
		//fail("Not yet implemented");
		LibroImpl prueba = new LibroImpl("Historia", "Culto Romano", "electronico", 1, 0, "La religión del poder.  El culto imperial en Atenas en época de Augusto y los emperadores Julio-Claudios", "Fernando", "una", LocalDate.now().minusYears(10), 15, 1841713198L);
		prueba.setAutor("Desconocido");
		assertEquals("No funciono setAutor","Desconocido",prueba.getAutor());
	}

	@Test
	public void testSetEditorial() {
		//fail("Not yet implemented");
		LibroImpl prueba = new LibroImpl("Historia", "Culto Romano", "electronico", 1, 0, "La religión del poder.  El culto imperial en Atenas en época de Augusto y los emperadores Julio-Claudios", "Fernando", "una", LocalDate.now().minusYears(10), 15, 1841713198L);
		prueba.setEditorial("Desconocida");
		assertEquals("No funciono setEditorial","Desconocida",prueba.getEditorial());
	}

	@Test
	public void testSetEdicion() {
		//fail("Not yet implemented");
		LibroImpl prueba = new LibroImpl("Historia", "Culto Romano", "electronico", 1, 0, "La religión del poder.  El culto imperial en Atenas en época de Augusto y los emperadores Julio-Claudios", "Fernando", "una", LocalDate.now().minusYears(10), 15, 1841713198L);
		prueba.setEdicion(LocalDate.now().minusYears(5));
		assertEquals("No funciono setEdicion",LocalDate.now().minusYears(5),prueba.getEdicion());
	}

	@Test
	public void testSetReimpresion() {
		//fail("Not yet implemented");
		LibroImpl prueba = new LibroImpl("Historia", "Culto Romano", "electronico", 1, 0, "La religión del poder.  El culto imperial en Atenas en época de Augusto y los emperadores Julio-Claudios", "Fernando", "una", LocalDate.now().minusYears(10), 15, 1841713198L);
		prueba.setReimpresion(3);
		assertEquals("No funciono setReimpresion",3,prueba.getReimpresion());
	}

	@Test
	public void testSetIsbn() {
		//fail("Not yet implemented");
		LibroImpl prueba = new LibroImpl("Historia", "Culto Romano", "electronico", 1, 0, "La religión del poder.  El culto imperial en Atenas en época de Augusto y los emperadores Julio-Claudios", "Fernando", "una", LocalDate.now().minusYears(10), 15, 1841713198L);
		prueba.setIsbn(33333333333L);
		assertEquals("No funciono setIsbn",33333333333L,prueba.getIsbn());
	}
	
	@Test
	public void testToString() {
		//fail("Not yet implemented");
		LibroImpl prueba = new LibroImpl("Historia", "Culto Romano", "electronico", 1, 0, "La religión del poder.  El culto imperial en Atenas en época de Augusto y los emperadores Julio-Claudios", "Fernando", "una", LocalDate.now().minusYears(10), 15, 1841713198L);
		String testeando ="("+prueba.getCodigo()+","+prueba.getArea()+","+prueba.getEspecialidad()+","+prueba.getFormato()+","+prueba.getTipoPrestamo()+","+prueba.getNumeroEjemplares()+";"+prueba.getTitulo()+";"+prueba.getAutor()+";"+prueba.getEditorial()+";"+prueba.getEdicion()+
		";"+prueba.getReimpresion()+";"+prueba.getIsbn()+")";
		assertEquals("No funciono el toString",testeando,prueba.toString());
	}

	@Test
	public void testMostrar() {
	LibroImpl prueba = new LibroImpl("Historia", "Culto Romano", "electronico", 1, 0, "La religión del poder.  El culto imperial en Atenas en época de Augusto y los emperadores Julio-Claudios", "Fernando", "una", LocalDate.now().minusYears(10), 15, 1841713198L);
	String testeando ="Codigo documento: "+prueba.getCodigo()+"\nArea: "+prueba.getArea()+"\nEpecialidad: "+prueba.getEspecialidad()+"\nFormato: "+prueba.getFormato()
			+"\nTipo prestamo: "+prueba.getTipoPrestamo()+"\nNumero Ejemplares: "+prueba.getNumeroEjemplares()+"\nTitulo: "+prueba.getTitulo()+"\nAutor: "+prueba.getAutor()
			+"\nEditorial: "+prueba.getEditorial()+"\nEdicion: "+prueba.getEdicion()+
			"; Reimpresion: "+prueba.getReimpresion()+"\nISBN: "+prueba.getIsbn();
	assertEquals("No funciono el toString",testeando,prueba.mostrar());
	}

	@Test
	public void testMostrarObjeto() {
		LibroImpl prueba = new LibroImpl("Historia", "Culto Romano", "electronico", 1, 0, "La religión del poder.  El culto imperial en Atenas en época de Augusto y los emperadores Julio-Claudios", "Fernando", "una", LocalDate.now().minusYears(10), 15, 1841713198L);
		String testeando ="\nTitulo: "+prueba.getTitulo()+"\nAutor: "+prueba.getAutor()+"\nEditorial: "+prueba.getEditorial()+"\nEdicion: "+prueba.getEdicion()+
				"; Reimpresion: "+prueba.getReimpresion()+"\nISBN: "+prueba.getIsbn();
		assertEquals("No funciono el toString",testeando,prueba.mostrarObjeto());
	}

}
