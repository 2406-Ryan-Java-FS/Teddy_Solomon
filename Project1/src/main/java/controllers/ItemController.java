package controllers;

import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
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
        context.result(gson.toJson(i));
    };

    public Handler createItem = (context) -> {

        Item i = gson.fromJson(context.body(), Item.class);
        i = is.addItem(i);
        context.result(gson.toJson(i));
    };

    public Handler updateItem = (context) -> {

        Item change = gson.fromJson(context.body(), Item.class);
        change = is.updateItem(change);
        context.result(gson.toJson(change));
    };

    public Handler deleteItemById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        Item i = is.deleteItem(id);
        context.result(gson.toJson(i));
    };

    public Handler getItemsByAccountId = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        List<Item> items = is.getAccountItems(id);
        String itemsJSON = gson.toJson(items);
        context.result(itemsJSON);
    };
}
