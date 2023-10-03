package KI301.Demchuk.lab3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Клас `Car` представляє об'єкт автомобіля з різними властивостями та методами
 * для управління його роботою.
 */
public abstract class Car {
    private String brand;
    private String model;
    private String color;
    private double mileage;
    private double tankCapacity = 0;
    private double fuelConsumption;
    private LocalDateTime startTime;
    private int averageSpeed;
    private boolean isDriving = false;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /**
     * Конструктор для створення нового об'єкта автомобіля з вказаною маркою, моделлю,
     * кольором, пробігом, об'ємом бака та споживанням пального.
     *
     * @param brand           Марка автомобіля.
     * @param model           Модель автомобіля.
     * @param color           Колір автомобіля.
     * @param mileage         Поточний пробіг автомобіля.
     * @param tankCapacity    Об'єм пального бака автомобіля.
     * @param fuelConsumption Рівень споживання пального автомобілем (в літрах на 100 км).
     */
    public Car(String brand, String model, String color, int mileage, double tankCapacity, double fuelConsumption) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.tankCapacity = 0;
        this.fuelConsumption = fuelConsumption;
    }
    /**
     * Конструктор для створення нового об'єкта вживаного автомобіля з вказаною маркою, моделлю
     * та кольором.
     *
     * @param brand Марка автомобіля.
     * @param model Модель автомобіля.
     * @param color Колір автомобіля.
     */
    public Car(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }
    /**
     * Конструктор за замовчуванням для класу Car.
     */
    public Car(){}
    /**
     * Починає нову подорож автомобілем з вказаною середньою швидкістю.
     *
     * @param averageSpeed Середня швидкість подорожі (в км/год).
     * @return True, якщо подорож була успішно розпочата, false - у протилежному випадку.
     */
    public boolean startDrive(int averageSpeed){
        if (!isDriving && tankCapacity != 0) {
            startTime = LocalDateTime.now();
            this.averageSpeed = averageSpeed;

            System.out.println("You are driving now");
            isDriving = true;

            log("The journey started at " + startTime + " with average speed " + averageSpeed);
            return true;
        }else if (tankCapacity == 0) {
            System.out.println("No fuel ¯\\_('')_/¯");
            log("The journey has not started. Reason: no fuel");
        }else {
            System.out.println("Seriously? You are still driving");
            log("The journey has not started. Reason: bad request");
        }

        return false;
    }
    /**
     * Завершує поточну подорож, обчислює пробіг та оновлює рівень пального в баку.
     *
     * @return True, якщо подорож була успішно завершена, false - у протилежному випадку.
     */
    public boolean endDrive(){
        if(isDriving){
            LocalDateTime endTime = LocalDateTime.now();
            double allTime = (double) Duration.between(startTime, endTime).toSeconds() / 3600;
            mileage = mileage + averageSpeed * allTime;
            tankCapacity = tankCapacity - (allTime * averageSpeed * fuelConsumption) / 100;
            if (tankCapacity < 0) {
                System.out.println("While you were driving your car ran out of " +
                        "fuel and you had to stop to refuel" + -tankCapacity + " liters");
                tankCapacity = 0;
            }
            System.out.println("The journey is over. Congrats! It has begun at " + dtf.format(startTime) +
                    "and was finished at " + dtf.format(endTime));

            log("The journey is over at " + dtf.format(endTime) + ". Refuel: " + -tankCapacity + " liters");
            return true;
        }
        System.out.println("But you don`t driving now");
        log("The journey has not over. Reason: bad request");
        return false;
    }
    /**
     * Заправляє бак автомобіля вказаною кількістю літрів пального.
     *
     * @param numberOfLiters Кількість літрів для заправки.
     * @return True, якщо заправка пройшла успішно, false - у протилежному випадку.
     */
    public boolean refuelCar(double numberOfLiters){
        if (numberOfLiters > 0){
            tankCapacity = tankCapacity + numberOfLiters;
            System.out.println("Your car is refueled. Your tank have " + tankCapacity + " liters");
            log("Car refueled on " + numberOfLiters + " liters");
            return true;
        }
        log("Car has not refueled. Reason: bad request");
        System.out.println("Bad request, try again");
        return false;
    }
    /**
     * Повертає опис автомобіля.
     *
     * @return Рядок, що містить інформацію про марку, модель, споживання пального та пробіг автомобіля.
     */
    public String getCarDescription(){
        log("Description received");
        return "Your car is " + brand + " " + model + ", fuel consumption: " + fuelConsumption + " mileage " + mileage;
    }
    /**
     * Перевіряє, чи автомобіль знаходиться у стані руху.
     *
     * @return True, якщо автомобіль рухається, false - у протилежному випадку.
     */
    public boolean checkDriving(){
        log("Check driving received");
        return isDriving;
    }
    /**
     * Повертає рівень споживання пального автомобілем.
     *
     * @return Рівень споживання пального (у літрах на 100 км).
     */

    public double getFuelConsumption() {
        log("Fuel consumption received");
        return fuelConsumption;
    }
    /**
     * Повертає поточний об'єм пального бака автомобіля.
     *
     * @return Поточний об'єм пального бака (у літрах).
     */
    public double getTankCapacity() {
        log("Tank capacity received");
        return tankCapacity;
    }
    /**
     * Повертає поточний пробіг автомобіля.
     *
     * @return Поточний пробіг (у кілометрах).
     */
    public double getMileage() {
        log("Mileage received");
        return mileage;
    }
    /**
     * Повертає марку автомобіля.
     *
     * @return Марка автомобіля.
     */
    public String getBrand() {
        log("Brand received");
        return brand;
    }
    /**
     * Встановлює марку автомобіля, якщо вона ще не визначена.
     *
     * @param brand Марка автомобіля.
     * @return True, якщо марка була успішно встановлена, false - якщо марка вже визначена.
     */
    public boolean setBrand(String brand) {
        if (this.brand == null) {
            this.brand = brand;
            log(brand + " inserted to brand");
            return true;
        }

        log("Fail. Brand already defined");
        return false;
    }
    /**
     * Повертає модель автомобіля.
     *
     * @return Модель автомобіля.
     */
    public String getModel() {
        return model;
    }
    /**
     * Встановлює модель автомобіля, якщо вона ще не визначена.
     *
     * @param model Модель автомобіля.
     * @return True, якщо модель була успішно встановлена, false - якщо модель вже визначена.
     */
    public boolean setModel(String model) {
        if (this.model == null){
            this.model = model;
            log(model + " inserted to model");
            return true;
        }
        log("Fail. Model already defined");
        return false;
    }
    /**
     * Повертає колір автомобіля.
     *
     * @return Колір автомобіля.
     */
    public String getColor() {
        return color;
    }
    /**
     * Встановлює колір автомобіля, якщо він ще не визначений.
     *
     * @param color Колір автомобіля.
     * @return True, якщо колір був успішно встановлений, false - якщо колір вже визначений.
     */
    public boolean setColor(String color) {
        if (this.color == null) {
            this.color = color;
            log(color + " inserted to color");
            return true;
        }
        log("Fail. Color already defined");
        return false;
    }
    /**
     * Записує повідомлення в журнал дій автомобіля.
     *
     * @param str Рядок для запису в журнал.
     */
    private void log(String str) {
        try {
            FileWriter logFile = new FileWriter("car_log.txt", true);
            logFile.write(str + "\n");
            logFile.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
