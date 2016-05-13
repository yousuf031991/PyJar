## PyJ∀r - A basic dynamically typed programming language
A rudimentary language created for the SER 502 class project which borrows from Python and Java.<br>
Developed with [AntlrV4.5.3](http://www.antlr.org/).<br>
Video tutorial on [this youtube link](https://youtu.be/hPxGfpWTmIg).<br>
Documentation [here](BabyJava/PyJar - Documentation.pdf).<br>
Grammar [here](BabyJava/Hello.g4).

### Basic characterstics:
* Bytecode generated as per a stack machine model.
* Compiler written in Java, Runtime in Python.
* Scripting supported
* Has an in built stack
* Functions, recursion, nested loops in the form of if-else and while loops supported.

### Installation
* Download the [PyJar Language.zip](BabyJava/PyJar language.zip) file.
* Create a new .txt file and write a program in PyJar (lets call it pgm.txt).
* Extract the file and go to the command line interface
* Run: _java -jar PyJar.jar pgm.txt_
* You’ll notice that there are 2 new files in the folder: 
  * intermediate.pyj - The intermediate code generated
  * parseTree.pt - The parse tree for reference
* Run: _python Interpreter.py_
* You’ll be prompted to enter a file name: Type _intermediate.pyj_<br>
The output of your program should be on the screen right about now.

### Example program for nth fibonacci number
```python
func fibo(n){
 if(n == 1){
  return 0
 } else if(n == 2){
  return 1
 }
 f1 = fibo(n - 1)
 f2 = fibo(n - 2)
 fsum = f1 + f2
 return fsum
}
x = read
print fibo(x)
```
#### Note:
* Functions need to be defined before they are called
* Only one arithmetic expression/function call allowed per statement eg. `return fibo(n - 1) + fibo(n - 2)` not permitted
* No indentation required like in Python
