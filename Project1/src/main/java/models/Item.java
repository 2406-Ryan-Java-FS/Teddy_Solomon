package models;

import java.util.Objects;

public class Item {

    private int id;
    private String name;
    private int categoryId;
    private double price;
    private boolean available;
    private long returnDate;

    public Item() {

    }

    public Item(int id, String name, int categoryId, double price, boolean available, long returnDate) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.available = available;
        this.returnDate = returnDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public long getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(long returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getId() == item.getId() && getCategoryId() == item.getCategoryId() && Double.compare(item.getPrice(), getPrice()) == 0 && isAvailable() == item.isAvailable() && getReturnDate() == item.getReturnDate() && getName().equals(item.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCategoryId(), getPrice(), isAvailable(), getReturnDate());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", price=" + price +
                ", available=" + available +
                ", returnDate=" + returnDate +
                '}';
    }
}
