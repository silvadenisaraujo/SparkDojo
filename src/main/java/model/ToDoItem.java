package model;


import lombok.Data;

@Data
public class ToDoItem {
    private int id;
    private String author;
    private String content;
}