import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Autopark autopark = new Autopark();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество машин:");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Введите информацию об автомобилях (гос. номер, марка, модель, год выпуска):");
            System.out.print("Автомобиль " + (i + 1) + ": ");
            String licensePlate = sc.next();
            String brand = sc.next();
            String model = sc.next();
            int year = sc.nextInt();
            Car car = new Car(licensePlate, brand, model, year);
            autopark.addCar(car);
        }

        try {
            // Удаление автомобиля
            System.out.print("Введите государственный номер автомобиля для удаления: ");
            String licensePlateToRemove = sc.next();
            autopark.removeCar(licensePlateToRemove);
            // Сортировка по году выпуска
            autopark.sortCars(Comparator.comparingInt(Car::getYear));
            // Вывод всех машин после сортировки
            System.out.println("Все машины после сортировки:");
            List<Car> sortedCars = autopark.getCars();
            for (Car car : sortedCars) {
                System.out.println(car);
            }
            // Поиск автомобиля
            System.out.print("Введите государственный номер автомобиля для поиска: ");
            String licensePlateToFind = sc.next();
            Car foundCar = autopark.findCar(licensePlateToFind);
            System.out.println("Найденный автомобиль: " + foundCar);

        } catch (Autopark.CarNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
