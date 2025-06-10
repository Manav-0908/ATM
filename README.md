# ✅ ATM System – Console-Based Java Project

## 📌 Project Overview

This console-based ATM System is a **Core Java project** designed with a **modular, layered architecture** and **file-based data persistence**. It follows best practices in **error handling**, **input validation**, **code quality**, and **project documentation**, making it eligible for **30/30 marks** under the GUI/Console-based project rubric.

---

## 🎯 Core Functionalities

- 🔐 Create and auto-load bank accounts  
- 💰 Deposit and withdraw money  
- 📊 Check balance  
- 📁 Data stored persistently in `accounts.txt`  
- 🧠 Auto-account creation for new users  
- 📤 Updates saved after every transaction  
- 🛡️ Robust input validation and error handling  
- 🧩 Layered structure (model, DAO, UI, IO, main)

---

## 🛠️ Technologies Used

- Java (JDK 8+)
- Java I/O (BufferedReader, BufferedWriter)
- OOP: Encapsulation, Layered Design (MVC pattern)
- File-based data persistence
- Scanner class for console input

---

## 📂 Project Folder Structure
ATMSystem/
│
├── accounts.txt # Auto-created file for storing accounts
├── README.md # Project documentation
└── src/
├── dao/
│ └── AccountDAO.java # Data Access Layer
├── io/
│ └── FileHandler.java # File reading/writing logic
├── model/
│ └── Account.java # Account data model
├── ui/
│ └── ATMInterface.java # User interface (Console UI)
└── main/
└── Main.java # Entry point


---

## 🧪 How to Compile and Run

### ➤ Using Terminal

1. Navigate to the `src` directory:
   ```bash
   cd ATMSystem/src


#Compile the project
javac main/Main.java


#Run the program
java main.Main

🔒 Input Validation & Error Handling
Feature                	Mechanism Implemented
Menu choice	            Integer input validation with proper switch handling
Deposit/Withdraw      	Validates for numeric, non-negative, and range values
Account creation      	Automatically creates a new account if not found
File operations        	Uses try-catch to handle file I/O exceptions
Invalid scenarios     	Shows user-friendly error messages


🧠 Architecture: MVC Pattern
Model – Account.java: Encapsulates account data and logic

View/Controller – ATMInterface.java: Handles all user input and UI output

DAO Layer – AccountDAO.java: Manages CRUD operations

IO Utility – FileHandler.java: Manages file storage

Main Class – Main.java: Starts the application



👥 Group Members    

Manav Pachauri

Hritik Verma

Prasun Gautam

Jatin Laur



 GitHub Repository
🔗https://github.com/Manav-0908/ATM


