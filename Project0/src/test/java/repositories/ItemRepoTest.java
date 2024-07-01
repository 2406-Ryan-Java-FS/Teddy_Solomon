package repositories;

import models.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ItemRepoTest {

    ItemRepo ir = new ItemRepoImpl();

    @Test
    public void getItem() {

        int id = 1;
        Item actual = ir.getItem(id);
        Item expected = new Item(1, "Apple",1,  7.5, true, 0);

        assertEquals(expected, actual);

    }

    @Test
    public void getAllItems() {

        List<Item> expected = new ArrayList<>();
        expected.add(new Item(1, "Apple", 1, 7.5, true, 0));
        expected.add(new Item(2, "The Avengers", 3, 8, true, 0));
        expected.add(new Item(3, "Pants", 5, 9, true, 0));

        List<Item> actual = ir.getAllItems();
        assertEquals(expected, actual);
    }

}
