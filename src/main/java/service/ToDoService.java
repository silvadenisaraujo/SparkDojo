package service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.ToDoItemPayload;
import repo.ToDoRepo;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.port;
import static util.ToDoUtil.dataToJson;

public class ToDoService {

    private static final int HTTP_BAD_REQUEST = 400;

    public static void main( String[] args) {

        ToDoRepo repo = ToDoRepo.getInstance();

        //Port configuration
        port(8080);

        // insert a post (using HTTP post method)
        post("/todo", (request, response) -> {
            try {
                ObjectMapper mapper = new ObjectMapper();
                ToDoItemPayload creation = mapper.readValue(request.body(), ToDoItemPayload.class);
                if (!creation.isValid()) {
                    response.status(HTTP_BAD_REQUEST);
                    return "";
                }
                int id = repo.createItem(creation.getAuthor(), creation.getContent());
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
            return dataToJson(repo.getToDoList());
        });
    }
}