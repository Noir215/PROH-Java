package MissingStudio.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import MissingStudio.modelo.AccesoBD;

class AccesoBDJUnitTest {

	@Test
	void testGetInstance() {
		AccesoBD modelo = AccesoBD.getInstance();
		assertNotNull(modelo);
	}

	@Test
	void testComprobarAcceso() {
		AccesoBD modelo = AccesoBD.getInstance();
		assertNotNull(modelo);
		
		boolean res = modelo.comprobarAcceso();
		assertTrue(res);
	}
	
	
}
