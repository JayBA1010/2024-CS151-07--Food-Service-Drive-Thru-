1. Compile the Java Files

[Run in cmd on src folder]
for /r %f in (*.java) do javac -d "../bin" "%f"

Now the source code should be compiled as class files in a bin folder contained in the parent folder of src

2. Run the Program from .class Files

[Run in cmd on bin folder]
java -cp ../bin core.Main

You should see
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

CS 151 Project 1: Drive-through Simulation Program

By Aung Aung, Aung Khant "Junior" Kyaw, Jay Barrios Abarquez, and Kenneth
Estrada

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Customer Count (Integer):

2a. Run the JAR File

java -jar MyProgram.jar
