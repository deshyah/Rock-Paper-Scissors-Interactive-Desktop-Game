# Rock Paper Scissors: Interactive Game Engine and GUI

## 💡 Overview
This project is a Java-based desktop application that implements a fully interactive version of the classic Rock Paper Scissors game. The primary focus is on **Event-Driven Programming** and creating a responsive **Java Swing GUI**. The core challenge involves managing real-time game state updates and synchronizing user interactions with an automated computer opponent.

## 🎯 Design and Implementation Goals
This project demonstrates proficiency in:
1.  **GUI Architecture:** Implementing a modular "Runner and Frame" design to separate application initialization from UI rendering.
2.  **State Management:** Maintaining persistent counters for Player Wins, Computer Wins, and Ties across a single execution session.
3.  **Algorithmic Randomization:** Utilizing `java.util.Random` to ensure a fair and unpredictable computer opponent.
4.  **UX/UI Design:** Integrating visual assets (`ImageIcons`) and a scrollable transaction log to provide high-quality user feedback.

## 🛠️ Design Component Summary

The application is built on the following core classes:

| Class Name | Primary Responsibility | Key Logic Focus |
| :--- | :--- | :--- |
| **RockPaperScissorsRunner** | Application entry point. | Instantiates the `RockPaperScissorsFrame` and configures window parameters. |
| **RockPaperScissorsFrame** | UI Engine and Game Logic. | Manages `ActionListeners`, handles game rules, and updates the display panels. |

## ⚙️ Game Logic and Rules Implementation

### 1. **Automated Opponent (AI)**
* The computer’s move is generated dynamically at the moment the player makes a selection.
* Logic validates the winner based on standard rules: Rock beats Scissors, Paper beats Rock, and Scissors beats Paper.

### 2. **Session Persistence & Stats**
The game tracks progress using three real-time counters:
* **Player Win Counter:** Increments when the user logic defeats the computer.
* **Computer Win Counter:** Increments when the AI logic defeats the user.
* **Tie Counter:** Increments when both parties select the same gesture.

### 3. **GUI and Event Handling**
* The interface features four command buttons: **Rock, Paper, Scissors, and Quit**.
* Each selection triggers an event that updates a **JTextArea** inside a
