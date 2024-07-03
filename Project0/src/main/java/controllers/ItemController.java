package controllers;

import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.NotFoundResponse;
import models.Item;
import services.ItemService;

import java.util.List;

public class ItemController {

    private ItemService is;
    private Gson gson = new Gson();

    public ItemController(ItemService is) { this.is = is; }

    public Handler getAllItems = (context) -> {

        List<Item> items = is.getAllItems();
        String itemsJSON = gson.toJson(items);
        context.result(itemsJSON);
    };

    public Handler getItemById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        Item i = is.getItem(id);
        if (i == null) {
            throw new NotFoundResponse();
        }
        context.result(gson.toJson(i));
    };

    public Handler createItem = (context) -> {

        Item i = gson.fromJson(context.body(), Item.class);
        i = is.addItem(i);
        context.result(gson.toJson(i));
    };

    public Handler updateItem = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        Item change = gson.fromJson(context.body(), Item.class);
        change.setId(id);
        change = is.updateItem(change);
        if (change == null) {
            throw new NotFoundResponse();
        }
        context.result(gson.toJson(change));
    };

    public Handler deleteItemById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        Item i = is.deleteItem(id);
        if (i == null) {
            throw new NotFoundResponse();
        }
        context.result(gson.toJson(i));
    };

    public Handler getItemsByAccountId = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        List<Item> items = is.getAccountItems(id);
        String itemsJSON = gson.toJson(items);
        context.result(itemsJSON);
    };
}
