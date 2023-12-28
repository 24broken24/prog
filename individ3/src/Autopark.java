import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class Autopark {
    private List<Car> cars;

    public Autopark() {
        cars = new ArrayList<>();
    }
    public void addCar(Car car) {
        cars.add(car);
    }

    // Метод для удаления автомобиля по гос.номеру
    public void removeCar(String licensePlate) throws CarNotFoundException {
        boolean removed = false;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getLicensePlate().equals(licensePlate)) {
                cars.remove(i);
                removed = true;
                break;
            }
        }
        if (!removed) {
            throw new CarNotFoundException("Автомобиль с государственным номером " + licensePlate + " не найден.");
        }
    }

    public void sortCars(Comparator<Car> comparator) {
        Collections.sort(cars, comparator);
    }
    public List<Car> getCars() {
        return cars;
    }

    // Метод для поиска данных автомобиля по гос.номеру
    public Car findCar(String licensePlate) throws CarNotFoundException {
        for (Car car : cars) {
            if (car.getLicensePlate().equals(licensePlate)) {
                return car;
            }
        }
        throw new CarNotFoundException("Автомобиль с государственным номером " + licensePlate + " не найден.");
    }

    // Вспомогательный класс исключения для обработки ошибок
    public static class CarNotFoundException extends Exception {
        public CarNotFoundException(String message) {
            super(message);
        }
    }
}