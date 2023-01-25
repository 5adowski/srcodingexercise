
# srcodingexercise
Sportradar Academy BE test

## Introduction

Application is designed to simplify sorting the probability of results. User can input a .json file containing
a list of sport events to parse the data and print the sorted result. User can specify how many most probable results the application should return. An additional feature is to list all competitor's names sorted alphabetically.


## Descriptions

Application is written with Java 17. Build on Apache Maven. Project Lombok and Jackson Core are external libraries.


## Build instructions

To build the application user needs two utilities - Java Runtime Environment (or Java Development Kit) and Apache Maven.

1.  JRE installation
1.1 You can download JRE free of charge from Oralce
1.2 Set the JAVA_HOME System Variable
1.3 Set the JAVA_HOME System Path

2.  Apache Maven installation
2.1 Download Apache Maven
2.2 Unzip file
2.3 Add the bin directory to the PATH environment variable

When utilities are installed it is time to clone this repository. After that, run command promt at project main directory and type command "mvn package". Maven will build JAR file.

## Run instructions

To run the application open command promt at project main directory and type Default run command (listed below). By default, the application will print the most probable results from the file contained in this project. There are few more options.

Default run command = <i>"java -jar target\srcodingexercise-1.0-SNAPSHOT-jar-with-dependencies.jar"</i>

Add one of following option at the end of the main command after space:
1. "<i>-c</i>" to print all competitors names sorted alphabetically
2. "<i>-url path/to/new/input/file.json</i>" to print ten most probable results from inputted file
3. "<i>-url path/to/new/input/file.json X</i>" to print X most probable results from inputted file

Example: <i>java -jar target\srcodingexercise-1.0-SNAPSHOT-jar-with-dependencies.jar -url "C:\Users\User\Desktop\BE_data.json" 30</i>
This will print 30 most probable results from inputted file
