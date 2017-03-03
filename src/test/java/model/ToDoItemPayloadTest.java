package model;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;


public class ToDoItemPayloadTest {

    @Test
    public void testValidPayload() throws Exception {

        ToDoItemPayload payload = new ToDoItemPayload();
        payload.setAuthor("Hodor");
        payload.setContent("Hold the door!");
        assertTrue(payload.isValid());

    }

    @Test
    public void testInvalidPayloadEmptyAuthor() throws Exception {

        ToDoItemPayload payload = new ToDoItemPayload();
        payload.setAuthor("");
        payload.setContent("Hold the door!");
        assertFalse(payload.isValid());

    }

    @Test
    public void testInvalidPayloadNullAuthor() throws Exception {

    }

    //Add more one test!
    //testInvalidPayloadNullContent

}