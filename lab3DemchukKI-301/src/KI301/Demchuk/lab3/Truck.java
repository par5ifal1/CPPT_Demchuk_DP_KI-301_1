package KI301.Demchuk.lab3;

/**
 * Клас `Truck` представляє об'єкт вантажної машини, яка є підкласом класу `Car`.
 * Реалізує інтерфейси `CargoTransport` та `Trailer`.
 */
public class Truck extends KI301.Demchuk.lab3.Car implements CargoTransport, Trailer {
    private double cargoWeight;
    private boolean hasTrailer;

    /**
     * Завантажує вантаж на вантажну машину.
     *
     * @param weight Вага завантаженого вантажу (у кілограмах).
     */
    @Override
    public void loadCargo(double weight) {
        cargoWeight += weight;
    }

    /**
     * Розвантажує вантаж з вантажної машини.
     */
    @Override
    public void unloadCargo() {
        cargoWeight = 0;
    }

    /**
     * Повертає вагу завантаженого вантажу на вантажній машині.
     *
     * @return Вага завантаженого вантажу (у кілограмах).
     */
    @Override
    public double getCargoWeight() {
        return cargoWeight;
    }

    /**
     * Приєднує причіп до вантажної машини.
     */
    @Override
    public void attachTrailer() {
        hasTrailer = true;
    }

    /**
     * Від'єднує причіп від вантажної машини.
     */
    @Override
    public void detachTrailer() {
        hasTrailer = false;
    }

    /**
     * Перевіряє, чи причіп приєднаний до вантажної машини.
     *
     * @return True, якщо причіп приєднаний, false - у протилежному випадку.
     */
    @Override
    public boolean hasTrailer() {
        return hasTrailer;
    }
}
