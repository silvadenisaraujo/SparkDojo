package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ToDoItem {
    private int nextId = 1;
    private Map<Integer,ToDoItem> toDoList = new HashMap<>();
    private int id;
    private String title;
    private List categories;
    private String content;

    public int createItem(String title, String content, List categories){
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setId(id);
        toDoItem.setTitle(title);
        toDoItem.setContent(content);
        toDoItem.setCategories(categories);
        toDoList.put(getNextId(), toDoItem);
        return id;
    }

    public List getToDoList(){
        return toDoList.keySet().stream().sorted().map((id) -> toDoList.get(id)).collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List getCategories() {
        return categories;
    }

    public void setCategories(List categories) {
        this.categories = categories;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNextId() {
        return ++nextId;
    }
}