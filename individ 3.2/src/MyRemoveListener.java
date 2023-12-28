import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class MyRemoveListener implements ActionListener {
    private JTextField f1;
    private Autopark autopark;

    MyRemoveListener(JTextField f1, Autopark autopark) {
        this.f1 = f1;
        this.autopark = autopark;
    }

    public void actionPerformed(ActionEvent e) {
        String licensePlate = f1.getText();
        try {
            autopark.removeCar(licensePlate);
            JOptionPane.showMessageDialog(null, "Автомобиль успешно удален", "Успех", JOptionPane.INFORMATION_MESSAGE);
        } catch (Autopark.CarNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}
