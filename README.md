# LAB 1 : JAVA MAVEN STARTER PROJECT 
## About the Project
This is a Java JDBC project that connects a Java application to a MySQL database to manage student records.

## Technologies Used
- Java
- JDBC (Java Database Connectivity)
- MySQL
- Maven
- Eclipse IDE

## Database Information
**Database name:** `StudentsDB`

**Table name:** `students`

The table contains:
- `id` — Student ID
- `firstname` — Student's first name
- `lastname` — Student's last name
- `grade` — Student's grade

## Features
- Connect Java to a MySQL database
- Insert student records
- Retrieve student information
- Update student grades
- Delete student records
- Calculate the average student grade

## How to Run the Project
1. Install Java JDK, Eclipse IDE, and MySQL.
2. Create a MySQL database named `StudentsDB`.
3. Create the `students` table.
4. Open the project in Eclipse as a Maven project.
5. Configure your MySQL username and password in the Java code.
6. Ensure the MySQL Connector/J dependency is included in `pom.xml`.
7. Run the Java
