import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class MySortListener implements ActionListener {
    private Autopark autopark;

    MySortListener(Autopark autopark) {
        this.autopark = autopark;
    }

    public void actionPerformed(ActionEvent e) {
        autopark.sortCars(Comparator.comparingInt(Car::getYear));
        List<Car> cars = autopark.getCars();
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Отсортированные машины", JOptionPane.INFORMATION_MESSAGE);
    }
}