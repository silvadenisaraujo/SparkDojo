package model;

import lombok.Data;

@Data
public class ToDoItemPayload {
    private String author;
    private String content;

    public boolean isValid(){
        return true;
    }
}