package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Source.UserDataBase;

class UserDataBaseTestCases {

	@Test
	void testUserDataBaseconstruction() {
		UserDataBase udb = new UserDataBase();
		udb.addOrModifyUser("username", "password02", "firstName", "lastName");
		assertEquals(7,udb.getUserInfo().length);
	}
	
	@Test
	void testUserDatanumUser() {
		UserDataBase udb = new UserDataBase();
		udb.addOrModifyUser("username", "password02", "firstName", "lastName");
		assertEquals(1,udb.getnumUsers());
	}
	
	@Test
	void testAddorModifyexistingUser() {
		UserDataBase udb = new UserDataBase();
		udb.addOrModifyUser("username", "password02", "firstName", "lastName");
		udb.addOrModifyUser("username", "password01", "Best", "Worst");
		assertEquals()
	}
	
}
