class Car:
    def __init__(self, brand, model, color, mileage=0, tank_capacity=0, fuel_consumption=0):
        # Initialize the car's properties
        self.brand = brand
        self.model = model
        self.color = color
        self.mileage = mileage
        self.tank_capacity = tank_capacity
        self.fuel_consumption = fuel_consumption
        self.start_time = None
        self.average_speed = 0
        self.is_driving = False  # Track if the car is currently driving

    def refuel_car(self, number_of_liters):
        """
        Refuel the car with a specified number of liters.

        Args:
            number_of_liters (float): The number of liters to refuel.

        Returns:
            bool: True if refueling is successful, False if it's a bad request.
        """
        if number_of_liters > 0:
            self.tank_capacity += number_of_liters
            print(f"Your car is refueled. Your tank has {self.tank_capacity} liters")
            return True
        print("Bad request, try again")
        return False

    def get_car_description(self):
        """
        Get a description of the car.

        Returns:
            str: A string describing the car's brand, model, fuel consumption, and mileage.
        """
        return (f"Your car is {self.brand} {self.model}, "
                f"fuel consumption: {self.fuel_consumption} mileage {self.mileage}")

    def check_driving(self):
        """
        Check if the car is currently driving.

        Returns:
            bool: True if the car is driving, False otherwise.
        """
        return self.is_driving

    def get_fuel_consumption(self):
        """
        Get the fuel consumption of the car.

        Returns:
            float: The fuel consumption in liters per 100 km.
        """
        return self.fuel_consumption

    def get_tank_capacity(self):
        """
        Get the current tank capacity of the car.

        Returns:
            float: The tank capacity in liters.
        """
        return self.tank_capacity

    def get_mileage(self):
        """
        Get the current mileage of the car.

        Returns:
            float: The mileage in kilometers.
        """
        return self.mileage

    def get_brand(self):
        """
        Get the brand of the car.

        Returns:
            str: The brand of the car.
        """
        return self.brand

    def set_brand(self, brand):
        """
        Set the brand of the car if it's not already defined.

        Args:
            brand (str): The brand to set.

        Returns:
            bool: True if the brand is successfully set, False if it's already defined.
        """
        if self.brand is None:
            self.brand = brand
            return True
        return False

    def get_model(self):
        """
        Get the model of the car.

        Returns:
            str: The model of the car.
        """
        return self.model

    def set_model(self, model):
        """
        Set the model of the car if it's not already defined.

        Args:
            model (str): The model to set.

        Returns:
            bool: True if the model is successfully set, False if it's already defined.
        """
        if self.model is None:
            self.model = model
            return True
        return False

    def get_color(self):
        """
        Get the color of the car.

        Returns:
            str: The color of the car.
        """
        return self.color

    def set_color(self, color):
        """
        Set the color of the car if it's not already defined.

        Args:
            color (str): The color to set.

        Returns:
            bool: True if the color is successfully set, False if it's already defined.
        """
        if self.color is None:
            self.color = color
            return True
        return False
