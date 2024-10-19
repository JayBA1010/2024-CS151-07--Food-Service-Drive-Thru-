# Overview
The DriveThrough class simulates the operations of a drive-through restaurant.
 * It manages customers, employees, and kitchen stations, tracking the number of customers served and the earnings.

# Design 
(Major Class summaries) <br/>
Customers: Represents a customer who places an order at the drive-through <br/>
Employees: Represents an employee that handles customers and moves between different kitchen stations. <br/>
Kitchen Stations: Represents a station where employees work, including the name, precedence, and a specific duration of use <br/>

# Installation Instructions
How to run the code:
Compile the Java Files (In Windows)

[Run in cmd on src folder]
for /r %f in (*.java) do javac -d "../bin" "%f"

Now the source code should be compiled as class files in a bin folder contained in the parent folder of src

# Usage
Run the Program from .class Files

[Run in cmd on bin folder]
java -cp ../bin core.Main

You should see
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

CS 151 Project 1: Drive-through Simulation Program

By Aung Aung, Aung Khant "Junior" Kyaw, Jay Barrios Abarquez, and Kenneth
Estrada

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Customer Count (Integer):

# Contributions
Aung Aung - Documentation and Main Debugger <br/>
Jay Barrios Abarquez - Code Polisher and Debugger <br/>
Kenneth Estrada - Designed our UML and Debugger <br/>
Junior Kyaw - Coded our Prototype
