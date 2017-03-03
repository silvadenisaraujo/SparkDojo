package repo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ToDoRepoTest {

    private ToDoRepo repo = ToDoRepo.getInstance();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        repo.cleanUpRepo();
    }

    @Test
    public void createItem() throws Exception {
        String author = "John Snow";
        String content = "Wait JUnit ?";
        int id = repo.createItem(author, content);

        assertEquals(id, -1);
    }


    @Test
    public void getToDoList() throws Exception {
        //How to test it ?
    }
}