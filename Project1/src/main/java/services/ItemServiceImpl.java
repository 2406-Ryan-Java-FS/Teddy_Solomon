package services;

import models.Item;
import repositories.ItemRepo;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    private ItemRepo ir;

    public ItemServiceImpl(ItemRepo ir) { this.ir = ir; };

    @Override
    public Item getItem(int id) {
        return ir.getItem(id);
    }

    @Override
    public List<Item> getAllItems() { return ir.getAllItems(); }

    @Override
    public Item addItem(Item i) {
        return ir.addItem(i);
    }

    @Override
    public Item updateItem(Item change) {
        return ir.updateItem(change);
    }

    @Override
    public Item deleteItem(int id) {
        return ir.deleteItem(id);
    }

    @Override
    public List<Item> getAccountItems(int id) { return ir.getAccountItems(id); }
}
