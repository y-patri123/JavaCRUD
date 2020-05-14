package db;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import beans.User;

class DataBaseTest {
	static DataBase bd = null;
	String query = null;
	User use = null;
	List<User> resultat = null;
	String flag = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		 bd = new DataBase();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		query = "SELECT * FROM user";
		resultat = new ArrayList<User>();
		
		use = new User();
		String email = "youfangpatricia@gmail.com";
		String matricule = "iuc01";
		use = new User(email, matricule);
		resultat.add(use);
		
		use = new User();
		email = "patriciayoufang@gmail.com";
		matricule = "iuc02";
		use = new User(email, matricule);
		resultat.add(use);
		
		use = new User();
		 email = "ympc@gmail.com";
		 matricule = "iuc03";
		use = new User(email, matricule);
		resultat.add(use);
		
		use = new User();
		 email = "paty@gmail.com";
		 matricule = "iuc04";
		use = new User(email, matricule);
		resultat.add(use);
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void readDbTest() {
		assertNotEquals(resultat, bd.getDataInDb(query));
	}
	@Test
	void writeDbTest() {
		flag = "INSERT";
		assertNotEquals(use, bd.setDataInDb(flag,use));
	}
	
	@Test
	void updateDbTest() {
		flag = "UPDATE";
		assertNotEquals(use, bd.setDataInDb(flag,use));
	}
	
	@Test
	void deleteDbTest() {
		
	}
	
	

}