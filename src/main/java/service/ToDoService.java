package service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.ToDoItem;
import model.ToDoItemPayload;

import static spark.Spark.get;
import static spark.Spark.post;
import static util.ToDoUtil.dataToJson;

public class ToDoService {

    private static final int HTTP_BAD_REQUEST = 400;

    public static void main( String[] args) {
        ToDoItem model = new ToDoItem();

        // insert a post (using HTTP post method)
        post("/todo", (request, response) -> {
            try {
                ObjectMapper mapper = new ObjectMapper();
                ToDoItemPayload creation = mapper.readValue(request.body(), ToDoItemPayload.class);
                if (!creation.isValid()) {
                    response.status(HTTP_BAD_REQUEST);
                    return "";
                }
                int id = model.createItem(creation.getTitle(), creation.getContent(), creation.getCategories());
                response.status(200);
                response.type("application/json");
                return id;
            } catch (JsonParseException jpe) {
                response.status(HTTP_BAD_REQUEST);
                return "";
            }
        });

        // get all post (using HTTP get method)
        get("/list", (request, response) -> {
            response.status(200);
            response.type("application/json");
            return dataToJson(model.getToDoList());
        });
    }
}