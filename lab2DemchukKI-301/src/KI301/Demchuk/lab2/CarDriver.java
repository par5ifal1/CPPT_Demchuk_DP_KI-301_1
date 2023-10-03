package KI301.Demchuk.lab2;

public class CarDriver {
    public static void main(String[] args) {
        // Створіть об'єкт класу Car
        Car myCar = new Car("Toyota", "Camry", "Silver", 50000, 60, 8.5);

        // Виведіть опис автомобіля
        System.out.println(myCar.getCarDescription());

        // Почніть поїздку
        myCar.startDrive(60);

        // Поповніть бак автомобіля
        myCar.refuelCar(0.0001);

        // Почніть поїздку
        myCar.startDrive(60);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        myCar.endDrive();

        // Поповніть бак автомобіля
        myCar.refuelCar(10);

        // Почніть поїздку
        myCar.startDrive(60);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Завершіть поїздку
        myCar.endDrive();

        // Поповніть бак автомобіля
        myCar.refuelCar(20);

        // Виведіть інформацію про вміст пального
        System.out.println("Fuel level: " + myCar.getTankCapacity() + " liters");

        // Виведіть інформацію про пройдений шлях
        System.out.println("Mileage: " + myCar.getMileage() + " km");

        // Перевірте, чи автомобіль в русі
        if (myCar.checkDriving()) {
            System.out.println("The car is currently in motion.");
        } else {
            System.out.println("The car is not in motion.");
        }

        // Спробуйте змінити марку автомобіля
        myCar.setBrand("Honda");

        // Змініть модель автомобіля
        myCar.setModel("Civic");

        // Змініть колір автомобіля
        myCar.setColor("Blue");

        // Виведіть оновлений опис автомобіля
        System.out.println(myCar.getCarDescription());

        // Створіть об'єкт класу Car
        Car myInventedCar = new Car();

        //Введіть бренд
        myInventedCar.setBrand("Gopel");

        //Введіть модель
        myInventedCar.setModel("DoAstra");

        //Колір
        myInventedCar.setColor("Pink");

        // Виведіть оновлений опис автомобіля
        System.out.println(myInventedCar.getCarDescription());
    }
}
