# Spring Core Lab 3

## Description
This lab demonstrates the basic concepts of the Spring Core Framework using XML-based configuration and Dependency Injection (DI).

## Technologies Used
- Java
- Spring Framework
- Maven
- IntelliJ IDEA
- Lombok

## Project Structure
text
src/
 └── main/
     ├── java/
     │   └── com/
     │       └── craft/
     │           ├── Address.java
     │           ├── Student.java
     │           └── App.java
     └── resources/
         └── beansConfig.xml


## Implementation
- Created an Address class with city and country properties.
- Created a Student class with id, name, age, and Address properties.
- Configured the Address and Student beans in beansConfig.xml.
- Used constructor injection to inject the Address bean into the Student bean.
- Loaded the Spring application context using ClassPathXmlApplicationContext.

## Output
text
Student(id=101, name=John Doe, age=20, address=Address(city=Addis, country=Ethiopia))


## How to Run
1. Open the project in IntelliJ IDEA.
2. Allow Maven to load the dependencies.
3. Run the App.java file.
4. Check the console for the output.
