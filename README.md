Food Service Drive-Through Order System

Project Overview

Welcome to the Food Service Drive-Through Order System, a Java-based application designed to streamline the process of ordering food at a drive-through. This system allows customers to place orders, and employees to manage the order workflow efficiently, including updating prices, tracking the preparation time for food items, and viewing the status of orders in real time.

Authors

Aung Aung
Aung Khant "Junior" Kyaw
Jay Barrios Abarquez
Kenneth Estrada

Features

Customer Interface: Customers can browse the menu, select items, and place orders through a user-friendly interface.
Employee Management: Employees have access to manage orders, update prices, modify the preparation time for specific menu items, and track ongoing orders.
Order Tracking: Real-time tracking of food preparation time and order status for both customers and employees.
Admin Panel: Employees with administrative privileges can add, remove, or modify menu items, prices, and food preparation times.

System Requirements

Java: JDK 11 or higher
IDE: Any Java-compatible IDE (e.g., IntelliJ IDEA, Eclipse)


How to run the code

1. Compile the Java Files

[Run in cmd on src folder]
for /r %f in (*.java) do javac -d "../bin" "%f"

Now the source code should be compiled as class files in a bin folder contained in the parent folder of src


2. Run the Program from .class Files

[Run in cmd on bin folder]
java -cp ../bin core.Main

Usage

Customer View
Launch the program and select the Customer mode.
Browse the available food items, choose the quantity, and place your order.
After placing an order, the system will display the estimated preparation time and order status.

Employee View
Launch the program and select the Employee mode.
View all current orders, update prices of menu items, and adjust the food preparation times.
Mark orders as "In Progress" or "Completed" to keep customers informed of their order status.
Use the admin panel to manage the menu by adding or removing items, updating prices, or setting preparation durations.
Contributing

We welcome contributions to this project! If you would like to contribute:

Fork the repository.
Create a feature branch: git checkout -b my-new-feature.
Commit your changes: git commit -m 'Add some feature'.
Push to the branch: git push origin my-new-feature.
Submit a pull request.

License

This project is licensed under the MIT License - see the LICENSE file for details.

Acknowledgments

Special thanks to our team members: Aung Aung, Aung Khant "Junior" Kyaw, Jay Barrios Abarquez, and Kenneth Estrada for their hard work and dedication.
Additional thanks to anyone who contributes to the project and helps make it better!
Feel free to reach out to us with any questions or suggestions!
