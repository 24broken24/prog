import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class MyPanel extends JPanel {
    JLabel l1, l2, l3, l4; // Добавлен новый JLabel для года выпуска
    JTextField f1, f2, f3, f4; // Добавлен новый JTextField для года выпуска
    JButton addButton, infoButton, removeButton, sortButton; // Добавлены кнопки
    Autopark autopark;

    MyPanel(Autopark autopark) {
        this.autopark = autopark;
        l1 = new JLabel("Гос. номер");
        add(l1);
        f1 = new JTextField();
        f1.setColumns(10);
        add(f1);
        l2 = new JLabel("Марка"); // Изменено на "Марка"
        f2 = new JTextField();
        f2.setColumns(10);
        add(f2);
        l3 = new JLabel("Модель"); // Изменено на "Модель"
        f3 = new JTextField();
        f3.setColumns(10);
        add(f3);
        l4 = new JLabel("Год выпуска"); // Новый JLabel для года выпуска
        add(l4);
        f4 = new JTextField(); // Новый JTextField для года выпуска
        f4.setColumns(10);
        add(f4);

        addButton = new JButton("Добавить автомобиль");
        MyListener addListener = new MyListener(f1, f2, f3, f4, autopark);
        addButton.addActionListener(addListener);
        add(addButton);

        infoButton = new JButton("Информация по гос. номеру");
        MyInfoListener infoListener = new MyInfoListener(f1, autopark);
        infoButton.addActionListener(infoListener);
        add(infoButton);

        removeButton = new JButton("Удалить автомобиль");
        MyRemoveListener removeListener = new MyRemoveListener(f1, autopark);
        removeButton.addActionListener(removeListener);
        add(removeButton);

        sortButton = new JButton("Сортировать машины");
        MySortListener sortListener = new MySortListener(autopark);
        sortButton.addActionListener(sortListener);
        add(sortButton);
    }
}