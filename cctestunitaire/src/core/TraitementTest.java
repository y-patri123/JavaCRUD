package core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import beans.Traitement;
import beans.User;

class TraitementTest {
	static Traitement traite = null;
	String email = null;
	String matricule = null;
	User use = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		 matricule ="iuc01";
		 email = "youfangpatricia@gmail.com";
		 use = new User (matricule, email);

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void isUserExistTest() {
		assertTrue(traite.isUserExistTest(use));
		
	}

}
