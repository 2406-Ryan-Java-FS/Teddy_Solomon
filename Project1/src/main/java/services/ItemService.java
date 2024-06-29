package services;

import models.Item;

import java.util.List;

public interface ItemService {

    public Item getItem(int id);

    public List<Item> getAllItems();

    public Item addItem(Item i);

    public Item updateItem(Item change);

    public Item deleteItem(int id);
}
