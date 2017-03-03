package model;

import java.util.LinkedList;
import java.util.List;


public class ToDoItemPayload {
    private String title;
    private List<ToDoItemPayload> categories = new LinkedList<>();
    private String content;

    public boolean isValid() {
        return title != null && !title.isEmpty() && !categories.isEmpty();
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
}