# Overview
This project simulates the operations of a drive-through restaurant using a tick system. Employees work at various kitchen stations, and the system tracks the workflow as orders are processed through the drive-through.

# Design 
(Major Class summaries) <br/>
## Main
Serves as the entry point for the drive-through simulation program <br/>
## DriveThrough
Simulates the operations of a drive-through restaurant <br/>
## UI 
Handles user input and output for the drive-through simulation <br/>
## Employees 
Represents an employee that handles customers and moves between different kitchen stations <br/>
## Manager
Represents a manager in a drive-through system that can update the prices of various menu items <br/>
## KitchenStation
Represents a station where employees work, including the name, precedence, and a specific duration of use <br/>

# Installation Instructions
How to run the code:

The source code should already have compiled class files in the out/production/Project folder.

Compile the Java Files (In Windows):

[Run in cmd on src folder]
for /r %f in (*.java) do javac -d "../project" "%f"

# Usage
Run the Program from .class Files:

[Run in cmd on project folder]
java -cp ../project core.Main

You should see
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

CS 151 Project 1: Drive-through Simulation Program

By Aung Aung, Aung Khant "Junior" Kyaw, Jay Barrios Abarquez, and Kenneth
Estrada

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

# Contributions
Aung Aung - Documentation and Main Debugger <br/>
Jay Barrios Abarquez - Code Polisher and Debugger <br/>
Kenneth Estrada - Designed our UML and Debugger <br/>
Junior Kyaw - Coded our Prototype 
