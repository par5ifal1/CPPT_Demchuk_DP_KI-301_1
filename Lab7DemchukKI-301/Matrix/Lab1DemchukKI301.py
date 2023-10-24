import sys


def create_matrix(row, column, char):
    """
    Create a matrix with a specified number of rows and columns, filled with the given character in a diagonal pattern.

    Args:
        row (int): The number of rows in the matrix.
        column (int): The number of columns in the matrix.
        char (str): The character to fill the matrix with.

    Returns:
        list of list: A 2D matrix filled with the specified character in a diagonal pattern.
    """
    # Check if the 'char' string contains exactly one character
    if len(char) != 1:
        print("The 'char' string should contain exactly one character.")
        sys.exit(0)  # Exit the program with a status code of 0

    # Initialize the matrix with spaces
    matrix = [[" " for _ in range(column)] for _ in range(row)]

    c = column

    # Fill the matrix with the specified character in a diagonal pattern
    for i in range(row):
        for j in range(i, c):
            matrix[i][j] = char
            matrix[row - i - 1][column - j - 1] = char

        c -= 1
        i += 1

    return matrix


def draw_matrix(matrix):
    """
    Draw (print) the given matrix to the screen.

    Args:
        matrix (list of list): The 2D matrix to be displayed.
    """
    # Output the matrix to the screen
    for row in matrix:
        for el in row:
            print(el, end="")
        print()
