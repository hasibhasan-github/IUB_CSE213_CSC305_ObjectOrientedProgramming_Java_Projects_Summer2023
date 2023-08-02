# IUB_CSE213_CSC305_ObjectOrientedProgramming_Java_Projects_Summer2023
Welcome to the Java OOP Projects Collection repository! This repository serves as a comprehensive showcase of all the projects completed during the Object-Oriented Programming (OOP) course at Independent University Bangladesh.

## Login Verification and Validation Project
This project is a JavaFX application that implements a simple login verification and validation system. It allows users to enter their email address and password to log in to the application. The application validates the input data to ensure that the email address follows a specific pattern and the password meets certain criteria for security.</br>

#### *Features
##### Login Form:
The application presents a login form with two fields: "Email Address" and "Password."

#####  Email Validation:
The "Email Address" field is validated to ensure that the input follows the correct email pattern: "^(.+)@dohs\.bd$". If the entered email address does not match the pattern, an error message is displayed to the user.

##### Password Validation:
The "Password" field is validated to ensure that it meets specific criteria for security. The password must contain at least one lowercase letter, one uppercase letter, one digit, and one special character (e.g., @, #, $, %, ^, &, +, =, !). Additionally, the password must be at least 8 characters long. If the entered password does not meet these criteria, an error message is shown to the user.

##### Error Alert:
Whenever there is a validation error in the login form, an error alert is displayed to inform the user about the issue.

##### How to Use
Launch the application.

Enter your email address in the "Email Address" field.

Enter your password in the "Password" field.

Click the "Login" button to submit the login form.

If the email address and password meet the validation and verification criteria, you will be logged in to the application. Otherwise, an error message will be shown, indicating the specific validation error.

##### Technologies Used
JavaFX: Used for creating the graphical user interface (GUI) of the application.

Regular Expressions: Utilized to validate the email address pattern and password criteria.

##### Dependencies
Java 8 or higher is required to run the application.
Credits
##### This project was developed by @Md Hasib Hasan. You can find the complete source code on GitHub at [[GitHub Repository URL]](https://github.com/hasibhasan-github/IUB_CSE213_CSC305_ObjectOrientedProgramming_Java_Projects_Summer2023/tree/LoginValidationVerifications).

#### Copyright @Md Hasib Hasan
