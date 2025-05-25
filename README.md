# ATM System – Console-Based Java Project

## Description

This project is a simple console-based ATM system developed using core Java. It demonstrates the use of encapsulation, modular structure with packages, file-based data persistence, and clean code architecture following the MVC concept.

Users can:

- Create a new bank account
- Check balance
- Deposit funds
- Withdraw money
- View account information

All data is stored in a text file and automatically loaded on each run.

---

## Technologies Used

- Java (Core)
- Java IO (BufferedReader, BufferedWriter)
- File handling for account storage
- Packages for code separation (model, dao)
- Console-based UI (Scanner)

---

## How to Run

1. Unzip the project folder.
2. Compile the files using a terminal or import into your favorite IDE (e.g., Eclipse, IntelliJ).
3. Run the ATMSystem.java file.
4. Follow on-screen instructions to interact with the ATM system.

Example terminal commands:

```
javac ATMSystem.java model/BankAccount.java dao/AccountDAO.java
java ATMSystem
```

---

## Project Structure

```
ATMSystem/
│
├── ATMSystem.java         # Main entry point
├── model/
│   └── BankAccount.java   # Encapsulates account details
├── dao/
│   └── AccountDAO.java    # Handles file-based data storage
```

---

## Group Members

- Manav Pachauri
- Hritik Verma
- Prasun Gautam
- Jatin Laur


## GitHub Link
https://github.com/Manav-0908/ATM
---
