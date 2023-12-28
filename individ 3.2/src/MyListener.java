import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyListener implements ActionListener {
        private JTextField f1, f2, f3, f4; // Обновленные переменные экземпляра для года выпуска
        private Autopark autopark;

        MyListener(JTextField f1, JTextField f2, JTextField f3, JTextField f4, Autopark autopark) {
                this.f1 = f1;
                this.f2 = f2;
                this.f3 = f3;
                this.f4 = f4;
                this.autopark = autopark;
        }

        public void actionPerformed(ActionEvent e) {
                String licensePlate = f1.getText();
                String brand = f2.getText();
                String model = f3.getText();
                int year = Integer.parseInt(f4.getText()); // Получение года выпуска из JTextField
                Car car = new Car(licensePlate, brand, model, year); // Добавление года выпуска
                autopark.addCar(car);
                f1.setText("");
                f2.setText("");
                f3.setText("");
                f4.setText(""); // Очистка поля для года выпуска
        }
}