import Domen.HotDrink;
import Domen.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VendingMachineGUI extends JFrame {
    // Поля
    private JTextField amountField;     // Поле для ввода текста с клавиатуры
    private JTextArea outputArea;       // Поле для отображения многострочного текста
    private JTextField changeField;     // Поле для отображения и редактирования текста
    private List<Product> assortment;   // Перечень продукции


    /**
     * Конструктор
     * @param drinks
     */
    public VendingMachineGUI(List<Product> drinks) {
        this.assortment = drinks;
        setTitle("Vending Machine");
        setSize(400, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(15, 1));

        JLabel amountLabel = new JLabel("Введите сумму:");
        amountField = new JTextField();
        add(amountLabel);
        add(amountField);

        for (Product drink : drinks) {
            addButton((HotDrink) drink);
        }

        outputArea = new JTextArea();
        add(new JLabel("Информация:"));
        add(new JScrollPane(outputArea));

        JButton cancelButton = new JButton("Отмена");
        add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelOrder();
            }
        });

        add(new JLabel("Сдача:"));
        changeField = new JTextField();
        changeField.setEditable(false);
        add(changeField);

        JButton finishButton = new JButton("Завершить");
        add(finishButton);
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
    }

    private void addButton(HotDrink drink) {
        JButton button = new JButton(
                "<html><center>" +
                        "<b>Место:</b> " + drink.getPlace() + "<br>" +
                        "<b>Наименование:</b> " + drink.getName() + "<br>" +
                        "<b>Цена:</b> " + drink.getPrice() + " рублей<br>" +
                        "<b>Температура:</b> " + drink.getTemperature() + " ℃" +
                        "</center></html>"
        );
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSelection(drink);
            }
        });
    }

    private void handleSelection(HotDrink drink) {
        int enteredAmount = 0;
        try {
            enteredAmount = Integer.parseInt(amountField.getText());
        } catch (NumberFormatException e) {
            outputArea.setText("Сначала внесите денежные средства, затем выберите напиток.");
            return;
        }

        if (enteredAmount == drink.getPrice()) {
            outputArea.setText("Вы выбрали " + drink.getName() + ", спасибо за заказ.");
            changeField.setText("Заберите сдачу - 0");
        } else if (enteredAmount > drink.getPrice()) {
            int change = enteredAmount - drink.getPrice();
            outputArea.setText("Вы выбрали " + drink.getName() + ", спасибо за заказ.");
            changeField.setText("Заберите сдачу - " + change);
        } else {
            outputArea.setText("Внесенных средств не достаточно для выбранного напитка. " +
                    "Введите сумму достаточную или нажмите на кнопку \"Отмена\" для возврата денег.");
        }
    }

    private void cancelOrder() {
        int enteredAmount = 0;
        try {
            enteredAmount = Integer.parseInt(amountField.getText());
        } catch (NumberFormatException e) {
            changeField.setText("Заберите сдачу - 0");
            return;
        }

        changeField.setText("Заберите сдачу - " + enteredAmount);
    }

    private void clearFields() {
        amountField.setText("");
        outputArea.setText("");
        changeField.setText("");
    }
}

