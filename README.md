# Car-Rental-System-by-Java-Eclipse
Java-based Car Rental Management System built using MVC architecture. Includes classes for User, Staff, Customer, Car, Booking, CarManager, and DataVector.

Powerpoint slides showcase entire project

🚗 Java Car Rental System (MVC)

This project is a Car Rental Management System developed in Java, following the Model–View–Controller (MVC) design pattern.
It allows customers to book and manage car rentals while enabling staff to handle vehicle data and booking records efficiently.

🧩 Features

User Management — Supports both Staff and Customer roles (inheritance from the User superclass).

Car Management — Add, edit, delete, and view available cars using CarManager.

Booking System — Create, modify, and cancel bookings with proper validation.

Data Persistence — Uses DataStorage to save and retrieve user, car, and booking data.

Error Handling & Input Validation — Ensures smooth user interaction and consistent data integrity.

🏗️ Class Diagram Overview

User (Superclass)
↳ Customer
↳ Staff

CarManager

Car

Booking

DataStorage

Each class encapsulates specific responsibilities, maintaining clean separation of concerns.
The associations and multiplicities between classes are properly defined to reflect real-world car rental relationships.

💻 Technologies Used

Language: Java

Paradigm: Object-Oriented Programming (OOP)

Architecture: MVC (Model–View–Controller)

IDE: Eclipse

🎯 Purpose

This project was created to demonstrate object-oriented design principles, MVC architecture, and practical Java programming.
It can be extended further with features like GUI (JavaFX/Swing), database integration (MySQL), or RESTful APIs.

🧠 Learning Outcomes

Applied inheritance, encapsulation, and polymorphism.

Implemented real-world class relationships.

Practiced modular programming and maintainable code structure.
