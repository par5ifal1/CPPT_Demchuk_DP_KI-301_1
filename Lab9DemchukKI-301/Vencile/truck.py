from Vencile.car import Car

class Truck(Car):
    def __init__(self, brand, model, color, mileage=0, tank_capacity=0, fuel_consumption=0):
        """
        Initialize a Truck object, inheriting from the Car class.

        Args:
            brand (str): The brand of the truck.
            model (str): The model of the truck.
            color (str): The color of the truck.
            mileage (float): The current mileage of the truck (default is 0).
            tank_capacity (float): The tank capacity of the truck (default is 0).
            fuel_consumption (float): The fuel consumption of the truck (default is 0).
        """
        super().__init__(brand, model, color, mileage, tank_capacity, fuel_consumption)
        self.cargo_weight = 0
        self.has_trailer = False

    def load_cargo(self, weight):
        """
        Load cargo onto the truck.

        Args:
            weight (float): The weight of the cargo in kilograms.
        """
        self.cargo_weight += weight

    def unload_cargo(self):
        """
        Unload cargo from the truck.
        """
        self.cargo_weight = 0

    def get_cargo_weight(self):
        """
        Get the weight of the loaded cargo on the truck.

        Returns:
            float: The weight of the loaded cargo in kilograms.
        """
        return self.cargo_weight

    def attach_trailer(self):
        """
        Attach a trailer to the truck.
        """
        self.has_trailer = True

    def detach_trailer(self):
        """
        Detach the trailer from the truck.
        """
        self.has_trailer = False

    def truck_has_trailer(self):
        """
        Check if the truck has a trailer attached.

        Returns:
            bool: True if the truck has a trailer, False otherwise.
        """
        return self.has_trailer
