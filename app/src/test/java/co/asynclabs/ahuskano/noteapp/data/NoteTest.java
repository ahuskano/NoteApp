package co.asynclabs.ahuskano.noteapp.data;

import org.junit.Test;

import static org.junit.Assert.*;

public class NoteTest {

    private String name = "Name";
    private String description = "Description";

    @Test
    public void testConstructor() {
        Note note = new Note(name, description);
        assertTrue(note.name.equals(name));
        assertTrue(note.description.equals(description));

    }

    @Test
    public void testDefaultParams() {
        Note note = new Note();
        assertTrue(note.name == null);
        assertTrue(note.description == null);
    }

}