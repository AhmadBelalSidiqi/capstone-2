
# 🥪 DELI-cious Sandwich Shop Application

## OverView
The DELI-cious Sandwich Shop Application is a command-line interface (CLI) Java application that allows users to place and customize sandwich orders.  
Users can build sandwiches, add drinks and chips, review their order, and generate a receipt saved as a file.

The application demonstrates Object-Oriented Programming (OOP) concepts such as abstraction, encapsulation, and polymorphism, along with file handling for data persistence.

---

## Features

- Create a new order
- Add sandwiches with full customization:
    - Choose size (4", 8", 12")
    - Select bread type
    - Add meats and cheeses (with extra options)
    - Add toppings and sauces
    - Add sides
    - Option to toast the sandwich
- Add drinks (small, medium, large)
- Add chips
- View complete order details
- Calculate total price including tax
- Generate and save receipt as a `.txt` file

---

## How to Run the Application

1. Open the repository URL on GitHub
2. Clone or download the repository
3. Open the project in IntelliJ
4. Run the `Main` class
5. Follow the on-screen menu prompts

---

## Project Structure

    //TODO : ADD PROJECT Structure
---

## Receipt File Format

Receipts are saved in the following format inside the resources' folder:
   

    "yyyyMMdd-HHmmss.txt"

Example:
20260526-153045.txt

Receipt content includes:
- List of ordered items
- Individual product details
- Total price 

---

## Limitations

- Command-line based user interface
- Fixed file path for receipts
- Limited input validation for invalid user input

---

## Future Improvements

- Improve input validation and error handling
- Add graphical user interface (GUI)
- Add signature sandwich templates and customization options
- Enhance receipt formatting for better readability

---

## Author

This project was created as part of a Java capstone assignment to demonstrate Object-Oriented Programming, clean code practices, and file handling.

I approached this project by first designing the overall structure using OOP principles and separating responsibilities across different classes such as UI, order management, and product handling.  
During development, I focused on keeping the code organized by using clear method names, and consistent formatting.

One of the main improvements in this project was applying a cleaner architecture by separating user interaction from business logic, which made the code easier to read, maintain, and extend.

Working on this project helped strengthen my understanding of Java concepts such as interfaces, class relationships, control flow, and file input/output operations.

---
