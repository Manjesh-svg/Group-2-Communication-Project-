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
	@Test
	void testConstructorFunctionalityNumChat() {
		User user = new User("username", "password", "John", "Smith");
		assertNotNull(user.getnumChat());
	}
	@Test
	void testConstructorFunctionalityChatArray() {
		User user = new User("username", "password", "John", "Smith");
		assertNotNull(user.getChatID());
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

// Testing Chat Array Functionality
	@Test
	void testingChatArraylength() {
		User user = new User("username", "password", "John", "Smith");
		assertEquals(1000,user.getChatID().length);
	}
	
	@Test
	void testingaddChatIDfunction() {
		User user = new User("username", "password", "John", "Smith");
		for(int i = 0; i < 70; i++) {
			user.addChatID("CR" + i);
		}
		assertEquals("CR69",user.getChatID()[69]);
	}
	
	@Test
	void testingremoveChatIDfunction() {
		User user = new User("username", "password", "John", "Smith");
		for(int i = 1; i < 6; i++) {
			user.addChatID("CR" + i);
		}
		user.removeChatID("CR1");
		assertEquals("CR2",user.getChatID()[0]);
	}
	
	@Test
	void testinggetnumChatFunction() {
		User user = new User("username", "password", "John", "Smith");
		for(int i = 0; i < 70; i++) {
			user.addChatID("CR" + i);
		}
		assertEquals(70,user.getnumChat());
	}
	
	@Test
	void testingChattoStringFunction(){
		User user = new User("username", "password", "John", "Smith");
		for(int i = 1; i < 5; i++) {
			user.addChatID("CR" + i);
		}
		System.out.println(user.chatToString());
		assertEquals("CR1, CR2, CR3, CR4",user.chatToString());
	}
		
// Testing toString()
	@Test
	void TesttoString() {
		User user = new User("username", "password", "John", "Smith");
		assertEquals("username/password/John/Smith", user.toString());
	}
	
	
	
	
	
	
	
	
}
