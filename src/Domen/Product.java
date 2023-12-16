package Domen;

public class Product {
    // Поля
    private String name;        // Наименование продукта
    private int price;          // Цена
    private int place;          // Место в торговом автомате


    /**
     * Конструктор
     * @param name
     * @param price
     * @param place
     */
    public Product(String name, int price, int place) {
        this.name = name;
        setPrice(price);
        this.place = place;
    }

    // Методы
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int value) {
        if (value <= 0) {
            this.price = 50;
        } else {
            this.price = value;
        }
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return  "Name = " + this.name+"\n"+
                "Price = " + this.price+"\n"+
                "Place = " + this.place+"\n";
    }
}
