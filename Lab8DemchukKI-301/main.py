import random
import struct

from Lab2DemchukKI301.Calculator import (read_text_data, write_text_data,
                                         write_binary_data, read_binary_data)


def main():
    num_values = 10
    text_input_file = "input.txt"
    binary_input_file = "input.bin"

    text_output_file = "output.txt"
    binary_output_file = "output.bin"

    data = [(random.uniform(1, 25),) for _ in range(num_values)]

    try:
        with open(binary_input_file, 'wb') as file:
            for x in data:
                x_bytes = struct.pack('d', x[0])
                file.write(x_bytes)
    except Exception as e:
        print(f"Error writing to {binary_input_file}: {e}")

    text_data = read_text_data(text_input_file)

    print("Text data result, that writing in file: ")
    print(text_data)
    binary_data = read_binary_data(binary_input_file)
    print("Binary data result, that writing in file: ")
    print(binary_data)

    write_text_data(text_data, text_output_file)
    write_binary_data(binary_data, binary_output_file)

    data = []

    try:
        with open(text_output_file, 'r') as file:
            for line in file:
                parts = line.strip().split('\t')
                if len(parts) >= 2:
                    x = float(parts[0])
                    y = float(parts[1])
                    data.append((x, y))
    except FileNotFoundError:
        print(f"File {text_output_file} not found.")
    except Exception as e:
        print(f"Error reading from {text_output_file}: {e}")

    print("Text data result, that reade from file: ")
    print(data)

    print("Binary data result, that reade from file: ")
    binary_data = read_binary_data(binary_output_file)
    print(binary_data)


if __name__ == "__main__":
    main()
