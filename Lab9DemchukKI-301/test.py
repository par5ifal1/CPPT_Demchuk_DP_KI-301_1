from Vencile.car import Car
from Vencile.truck import Truck

def test_car():
    """
    Test function for the Car class.

    This function creates a Car object and performs various test cases on its methods.
    """
    car = Car("Toyota", "Camry", "Red", 50000, 60, 8.5)

    # Test setting brand, which is already defined
    assert car.set_brand("Toyota") == False

    # Test getting car description
    assert car.get_car_description() == "Your car is Toyota Camry, fuel consumption: 8.5 mileage 50000"

    # Test getting fuel consumption
    assert car.get_fuel_consumption() == 8.5

    # Test getting tank capacity
    assert car.get_tank_capacity() == 60

    # Test getting mileage
    assert car.get_mileage() == 50000

def test_truck():
    """
    Test function for the Truck class.

    This function creates a Truck object and performs various test cases on its methods.
    """
    truck = Truck("Mercedes-Benz", "Atego", "Brown", 45000, 300, 30)

    # Test loading cargo
    truck.load_cargo(1000)
    assert truck.get_cargo_weight() == 1000

    # Test attaching a trailer
    truck.attach_trailer()
    assert truck.truck_has_trailer() == True

    # Test detaching the trailer
    truck.detach_trailer()
    assert truck.truck_has_trailer() == False

    # Test unloading cargo
    truck.unload_cargo()
    assert truck.get_cargo_weight() == 0

if __name__ == "__main__":
    test_car()
    test_truck()
