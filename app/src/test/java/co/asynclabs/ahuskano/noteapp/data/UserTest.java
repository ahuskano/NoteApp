package co.asynclabs.ahuskano.noteapp.data;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private String name = "Name";
    private String email = "Description";
    private String password = "Password";

    @Test
    public void testConstructor() {
        User user = new User(name, email, password);
        assertTrue(user.name.equals(name));
        assertTrue(user.email.equals(email));
        assertTrue(user.password.equals(password));
    }

    @Test
    public void testDefaultParams() {
        User user = new User();
        assertTrue(user.name == null);
        assertTrue(user.email == null);
        assertTrue(user.password == null);

    }

}