package app;

import controllers.ItemController;
import controllers.AccountController;
import io.javalin.Javalin;
import org.jetbrains.annotations.NotNull;
import repositories.ItemRepo;
import repositories.ItemRepoImpl;
import repositories.AccountRepo;
import repositories.AccountRepoImpl;
import services.ItemService;
import services.ItemServiceImpl;
import services.AccountService;
import services.AccountServiceImpl;

import static io.javalin.apibuilder.ApiBuilder.*;

public class App {

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> config.enableCorsForAllOrigins());
        establishRoutes(app);
        app.start();
    }

    private static void establishRoutes(@NotNull Javalin app) {

        ItemRepo ir = new ItemRepoImpl();
        ItemService is = new ItemServiceImpl(ir);
        ItemController ic = new ItemController(is);

        AccountRepo ar = new AccountRepoImpl();
        AccountService as = new AccountServiceImpl(ar);
        AccountController ac = new AccountController(as);

        app.get("/hello", (context) -> context.result("Hello World!"));

        app.get("/items", ic.getAllItems);
        app.get("/items/:id", ic.getItemById);
        app.post("/items", ic.createItem);
        app.put("/items", ic.updateItem);
        app.delete("/items/:id", ic.deleteItemById);

        app.get("/accounts", ac.getAllAccounts);
        app.get("/accounts/:id", ac.getAccountById);
        app.post("/accounts", ac.createAccount);
        app.put("/accounts", ac.updateAccount);
        app.delete("/accounts/:id", ac.deleteAccountById);
        app.get("/accounts/:id/items", ic.getItemsByAccountId);
    }
}
