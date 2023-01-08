# Simple S-expression calculator
### Demo project, provides user opportunity to do simple calculations such as "+" and "*"


## How to use
  1. Make sure you have Java properly installed on your machine (to make sure it works just type 'java' in terminal/console)
  2. Download *.jar file by using next link [DOWNLOAD JAR](simple_s-expression_calculator/out/artifacts/s_expression_calculator_jar/s_expression_calculator.jar)
  3. Open terminal/console, open directory with s_expression_calculator.jar file (cd path/to/dir)
  4. Use the next command 'java -jar s_expression_calculator.jar "ARG"' (replace ARG with proper argument)
  5. For more details use the next command 'java -jar s_expression_calculator.jar --h'
  
  
## Commands
```
--help, --h     display help info

--author, --a   display author details
```

## Examples
### You can use these commands
```
java -jar s_expression_calculator.jar 123

java -jar s_expression_calculator.jar "(add 0 (add 3 4))"

java -jar s_expression_calculator.jar "(add 3 (multiply (add 34 5) (add 5 5 5)))"
```
### OR
[Open file with example commands](simple_s-expression_calculator/src/Test/TestList)
