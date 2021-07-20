package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Source.User;

class UserTestCases {
// Testing Constructor functionality
	@Test
	void testConstructorFunctionalityUsername() {
		User user = new User("username", "password", "John", "Smith");
		assertNotNull(user.getUser());
	}
	@Test
	void testConstructorFunctionalityPassword() {
		User user = new User("username", "password", "John", "Smith");
		assertNotNull(user.getPass());
	}
	@Test
	void testConstructorFunctionalityfName() {
		User user = new User("username", "password", "John", "Smith");
		assertNotNull(user.getfName());
	}
	@Test
	void testConstructorFunctionalitylName() {
		User user = new User("username", "password", "John", "Smith");
		assertNotNull(user.getlName());
	}
	
// Testing User Object Types
	@Test
	void TestUsernameType() {
		User user = new User("username", "password", "John", "Smith");
		boolean username = (user.getUser() instanceof String);
		assertTrue(username);
	}
	@Test
	void TestPasswordType() {
		User user = new User("username", "password", "John", "Smith");
		boolean Password = (user.getPass() instanceof String);
		assertTrue(Password);
	}
	@Test
	void TestfNameType() {
		User user = new User("username", "password", "John", "Smith");
		boolean FirstName = (user.getfName() instanceof String);
		assertTrue(FirstName);
	}
	@Test
	void TestlNameType() {
		User user = new User("username", "password", "John", "Smith");
		boolean LastName = (user.getlName() instanceof String);
		assertTrue(LastName);
	}
	
// Testing User Object Setter and Getter Functions
	@Test
	void TestUsernameGetter(){
		User user = new User("username", "password", "John", "Smith");
		assertEquals("username", user.getUser());
	}
	@Test
	void TestPasswordGetter(){
		User user = new User("username", "password", "John", "Smith");
		assertEquals("password", user.getPass());
	}
	@Test
	void TestfNameGetter() {
		User user = new User("username", "password", "John", "Smith");
		assertEquals("John", user.getfName());
	}
	@Test
	void TestlNameGetter() {
		User user = new User("username", "password", "John", "Smith");
		assertEquals("Smith", user.getlName());
	}
	
	@Test
	void TestUserSetter() {
		User user = new User("username", "password", "John", "Smith");
		user.setUser("NewUsername");
		assertEquals("NewUsername",user.getUser());
	}
	@Test
	void TestPassSetter() {
		User user = new User("username", "password", "John", "Smith");
		user.setPass("NewPassword");
		assertEquals("NewPassword", user.getPass());
	}
	@Test
	void TestfNameSetter() {
		User user = new User("username", "password", "John", "Smith");
		user.setFirstName("notJohn");
		assertEquals("notJohn", user.getfName());
	}
	@Test
	void TestlNameSetter() {
		User user = new User("username", "password", "John", "Smith");
		user.setLastName("notSmith");
		assertEquals("notSmith", user.getlName());
	}
		
// Testing toString()
	@Test
	void TesttoString() {
		User user = new User("username", "password", "John", "Smith");
		assertEquals("username/password/John/Smith", user.toString());
	}
	
	
	
	
	
	
	
	
}
