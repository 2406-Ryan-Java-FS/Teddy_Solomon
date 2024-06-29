package app;

import controllers.ItemController;
import io.javalin.Javalin;
import repositories.ItemRepo;
import repositories.ItemRepoImpl;
import services.ItemService;
import services.ItemServiceImpl;

import static io.javalin.apibuilder.ApiBuilder.*;

public class App {

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> config.enableCorsForAllOrigins());
        establishRoutes(app);
        app.start();
    }

    private static void establishRoutes(Javalin app) {

        ItemRepo ir = new ItemRepoImpl();
        ItemService is = new ItemServiceImpl(ir);
        ItemController ic = new ItemController(is);

        app.get("/hello", (context) -> context.result("Hello World!"));

        app.get("/items", ic.getAllItems);
        app.get("/items/:id", ic.getItemById);
        app.post("/items", ic.createItem);
        app.put("/items", ic.updateItem);
        app.delete("/items/:id", ic.deleteItemById);
    }
}
