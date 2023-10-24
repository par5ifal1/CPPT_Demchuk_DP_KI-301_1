import math
import struct


# Function to calculate the expression 2 * x / math.sin(x) for given x
def calculate_expression(x):
    try:
        return 2 * x / math.sin(x)
    except ZeroDivisionError:
        print("Division by zero is not allowed.")
        return 0


# Function to read data from a text file and calculate y for each x
def read_text_data(filename):
    data = []
    try:
        with open(filename, 'r') as file:
            for line in file:
                x = float(line)
                y = calculate_expression(x)
                data.append((x, y))
    except FileNotFoundError:
        print(f"File {filename} not found.")
    except ValueError:
        print(f"Invalid data in {filename}.")

    return data


# Function to write data to a text file
def write_text_data(data, filename):
    try:
        with open(filename, 'w') as file:
            for x, y in data:
                file.write(f"{x}\t{y}\n")
    except:
        print(f"Error writing data to {filename}.")


# Function to read binary data from a file and calculate y for each x
def read_binary_data(filename):
    data = []
    try:
        with open(filename, 'rb') as file:
            x = file.read(8)
            while x:
                x = struct.unpack('d', x)[0]
                y = calculate_expression(x)
                data.append((x, y))
                x = file.read(8)
    except FileNotFoundError:
        print(f"File {filename} not found.")
    except struct.error:
        print(f"Invalid binary data in {filename}.")

    return data


# Function to write data to a binary file
def write_binary_data(data, filename):
    try:
        with open(filename, 'wb') as file:
            for x, y in data:
                x_bytes = struct.pack('d', x)
                file.write(x_bytes)
    except:
        print(f"Error writing data to {filename}.")
