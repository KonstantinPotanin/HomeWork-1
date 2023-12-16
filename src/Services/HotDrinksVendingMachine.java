package Services;

import Domen.Product;

import java.util.List;

public class HotDrinksVendingMachine {
    // Поля
    BillAcceptor billAcceptor;          // Купюроприемник
    CoffeeContainer coffeeContainer;    // Емкость для кофе
    CoinDispenser dispenser;            // Монетоприёмник
    MilkContainer milkContainer;        // Емкость для молока
    PointOfSale pointOfSale;            // Терминал для банковских карт
    TeaContainer teaContainer;          // Емкость для чая
    WaterContainer waterContainer;      // Емкость для воды
    List<Product> assortment;           // Перечень продукции

    /**
     * Конструктор
     * @param billAcceptor
     * @param coffeeContainer
     * @param dispenser
     * @param milkContainer
     * @param pointOfSale
     * @param teaContainer
     * @param waterContainer
     * @param assortment
     */
    public HotDrinksVendingMachine(BillAcceptor billAcceptor, CoffeeContainer coffeeContainer,
                                   CoinDispenser dispenser, MilkContainer milkContainer,
                                   PointOfSale pointOfSale, TeaContainer teaContainer,
                                   WaterContainer waterContainer, List<Product> assortment) {
        this.billAcceptor = billAcceptor;
        this.coffeeContainer = coffeeContainer;
        this.dispenser = dispenser;
        this.milkContainer = milkContainer;
        this.pointOfSale = pointOfSale;
        this.teaContainer = teaContainer;
        this.waterContainer = waterContainer;
        this.assortment = assortment;
    }

    // Методы
    public BillAcceptor getBillAcceptor() {
        return billAcceptor;
    }

    public void setBillAcceptor(BillAcceptor billAcceptor) {
        this.billAcceptor = billAcceptor;
    }

    public CoffeeContainer getCoffeeContainer() {
        return coffeeContainer;
    }

    public void setCoffeeContainer(CoffeeContainer coffeeContainer) {
        this.coffeeContainer = coffeeContainer;
    }

    public CoinDispenser getDispenser() {
        return dispenser;
    }

    public void setDispenser(CoinDispenser dispenser) {
        this.dispenser = dispenser;
    }

    public MilkContainer getMilkContainer() {
        return milkContainer;
    }

    public void setMilkContainer(MilkContainer milkContainer) {
        this.milkContainer = milkContainer;
    }

    public PointOfSale getPointOfSale() {
        return pointOfSale;
    }

    public void setPointOfSale(PointOfSale pointOfSale) {
        this.pointOfSale = pointOfSale;
    }

    public TeaContainer getTeaContainer() {
        return teaContainer;
    }

    public void setTeaContainer(TeaContainer teaContainer) {
        this.teaContainer = teaContainer;
    }

    public WaterContainer getWaterContainer() {
        return waterContainer;
    }

    public void setWaterContainer(WaterContainer waterContainer) {
        this.waterContainer = waterContainer;
    }

    public List<Product> getProduct() {
        return assortment;
    }

    public void setProduct(List<Product> assortment) {
        this.assortment = assortment;
    }
}
