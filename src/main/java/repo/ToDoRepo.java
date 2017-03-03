package repo;

import model.ToDoItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ToDoRepo {
    private static ToDoRepo ourInstance = new ToDoRepo();
    private Map<Integer,ToDoItem> toDoList = new HashMap<>();
    private int id = 0;

    private ToDoRepo() {
    }

    public static ToDoRepo getInstance() {
        return ourInstance;
    }

    public int createItem(String author, String content){
        ToDoItem toDoItem = new ToDoItem();
        return id;
    }

    public List getToDoList(){
        return toDoList.keySet().stream().sorted().map((id) -> toDoList.get(id)).collect(Collectors.toList());
    }

    void cleanUpRepo(){
        toDoList = new HashMap<>();
    }

    private int getNextId() {
        return 0;
    }

}
