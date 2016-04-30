## PyJ∀r - A basic dynamically typed programming language
A rudimentary language created for the SER 502 class project which borrows from Python and Java.<br>
Developed with [AntlrV4.5.3](http://www.antlr.org/).<br>
Video tutorial on [this youtube link](https://youtu.be/hPxGfpWTmIg).<br>
Documentation [here](BabyJava/PyJar - Documentation.pdf).<br>

### Basic characterstics:
* Bytecode generated as per a stack machine model.
* Compiler written in Java, Runtime in Python.
* Scripting supported
* Has an in built stack
* Functions, recursion, nested loops in the form of if-else and while loops supported.

### Installation
* Download the PyJar Language.zip file from this git repository
* Create a new .txt file and write a program in PyJar (lets call it pgm.txt).
* Extract the file and go to the command line interface
* Run: _java -jar PyJar.jar pgm.txt_
* You’ll notice that there are 2 new files in the folder: 
  * intermediate.pyj - The intermediate code generated
  * parseTree.pt - The parse tree for reference
* Run: _python Interpreter.py_
* You’ll be prompted to enter a file name: Type _intermediate.pyj_<br>
The output of your program should be on the screen right about now.

