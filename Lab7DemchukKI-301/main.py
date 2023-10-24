from Matrix.Lab1DemchukKI301 import create_matrix, draw_matrix


"""
Main function to create and display a diagonal matrix based on user input.

This function prompts the user to enter a filling character and the size of the array (number of rows and columns). It then creates a diagonal matrix using the provided character and dimensions and displays the matrix on the screen.

"""
# Prompt the user for input
print("Enter the filling character and the size of the array")
string = input()  # Read a character from the user
row = int(input())  # Read the number of rows from the user
column = int(input())  # Read the number of columns from the user

# Create a matrix using the provided character and dimensions
matrix = create_matrix(row, column, string)

# Draw (print) the created matrix to the screen
draw_matrix(matrix)

"""
Main function to create and display a diagonal matrix based on user input.

This function prompts the user to enter a filling character and the size of the array (number of rows and columns). It then creates a diagonal matrix using the provided character and dimensions and displays the matrix on the screen.

"""
