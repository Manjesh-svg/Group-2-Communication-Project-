package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Source.User;

class UserTestCases {
// Testing Constructor functionality
	@Test
	void testConstructorFunctionalityUsername() {
		User user = new User("username", "password", "John", "Smith");
		assertNotNull(user.GetUser());
	}
	@Test
	void testConstructorFunctionalityPassword() {
		User user = new User("username", "password", "John", "Smith");
		assertNotNull(user.GetPass());
	}
	@Test
	void testConstructorFunctionalityfName() {
		User user = new User("username", "password", "John", "Smith");
		assertNotNull(user.GetfName());
	}
	@Test
	void testConstructorFunctionalitylName() {
		User user = new User("username", "password", "John", "Smith");
		assertNotNull(user.GetlName());
	}
	
// Testing User Object Types
	@Test
	void TestUsernameType() {
		User user = new User("username", "password", "John", "Smith");
		boolean username = (user.GetUser() instanceof String);
		assertTrue(username);
	}
	@Test
	void TestPasswordType() {
		User user = new User("username", "password", "John", "Smith");
		boolean Password = (user.GetPass() instanceof String);
		assertTrue(Password);
	}
	@Test
	void TestfNameType() {
		User user = new User("username", "password", "John", "Smith");
		boolean FirstName = (user.GetfName() instanceof String);
		assertTrue(FirstName);
	}
	@Test
	void TestlNameType() {
		User user = new User("username", "password", "John", "Smith");
		boolean LastName = (user.GetlName() instanceof String);
		assertTrue(LastName);
	}
	
// Testing User Object Setter and Getter Functions
	@Test
	void TestUsernameGetter(){
		User user = new User("username", "password", "John", "Smith");
		assertEquals("username", user.GetUser());
	}
	@Test
	void TestPasswordGetter(){
		User user = new User("username", "password", "John", "Smith");
		assertEquals("password", user.GetPass());
	}
	@Test
	void TestfNameGetter() {
		User user = new User("username", "password", "John", "Smith");
		assertEquals("John", user.GetfName());
	}
	@Test
	void TestlNameGetter() {
		User user = new User("username", "password", "John", "Smith");
		assertEquals("Smith", user.GetlName());
	}
	
	@Test
	void TestUserSetter() {
		User user = new User("username", "password", "John", "Smith");
		user.SetUser("NewUsername");
		assertEquals("NewUsername",user.GetUser());
	}
	@Test
	void TestPassSetter() {
		User user = new User("username", "password", "John", "Smith");
		user.SetPass("NewPassword");
		assertEquals("NewPassword", user.GetPass());
	}
	@Test
	void TestfNameSetter() {
		User user = new User("username", "password", "John", "Smith");
		user.SetFirstName("notJohn");
		assertEquals("notJohn", user.GetfName());
	}
	@Test
	void TestlNameSetter() {
		User user = new User("username", "password", "John", "Smith");
		user.SetLastName("notSmith");
		assertEquals("notSmith", user.GetlName());
	}
		
// Testing toString()
	@Test
	void TesttoString() {
		User user = new User("username", "password", "John", "Smith");
		assertEquals("username/password/John/Smith", user.toString());
	}
	
	
	
	
	
	
	
	
}
