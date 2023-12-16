package Domen;

public class HotDrink extends Product {
    // Поля
    private int temperature;        // Температура напитка

    /**
     * Конструктор
     * @param name
     * @param price
     * @param place
     * @param temperature
     */
    public HotDrink(String name, int price, int place, int temperature) {
        super(name, price, place);
        setTemperature(temperature);
    }
    // Методы

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int value) {
        if (value < 70 || value > 100) {
            this.temperature = 70;
        } else this.temperature = value;
    }
    @Override
    public String toString() {
        return super.toString() + "Temperature of the drink = " + temperature + "\n";
    }
}
