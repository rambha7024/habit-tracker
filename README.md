# 🌿 Habit Tracker Web Application  

![Java](https://img.shields.io/badge/Java-21-orange?logo=java)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.5.6-brightgreen?logo=springboot)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-Template%20Engine-green?logo=thymeleaf)
![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)
![Status](https://img.shields.io/badge/Status-Completed-success)

---

## 🧠 Overview

A **Habit Tracker Web Application** built using **Spring Boot**, **Thymeleaf**, and **H2 Database**.  
It helps users **add, track, and visualize daily habits** with progress charts and a modern vibrant UI.  

✨ Simple. Smart. Stylish.

---

## 🌟 Features

✅ Add new habits with description and start date  
✅ Mark habits as completed with a checkbox  
✅ Real-time progress visualization using **Chart.js**  
✅ Responsive and colorful UI  
✅ Reset or delete habits easily  
✅ Stores data in **H2 in-memory database**

---

## 🛠️ Tech Stack

| Layer | Technologies |
|-------|---------------|
| **Frontend** | HTML, CSS, Thymeleaf, Chart.js |
| **Backend** | Java, Spring Boot, Spring MVC, Spring Data JPA |
| **Database** | H2 Database (in-memory) |
| **Build Tool** | Maven |
| **IDE** | IntelliJ IDEA / VS Code |
| **Version Control** | Git & GitHub |

---

## 🏗️ Project Structure

habit_tracker/
├── src/
│ ├── main/
│ │ ├── java/com/example/habit_tracker/
│ │ │ ├── controller/HabitController.java
│ │ │ ├── model/Habit.java
│ │ │ ├── repository/HabitRepository.java
│ │ │ ├── service/HabitService.java
│ │ │ └── HabitTrackerApplication.java
│ │ └── resources/
│ │ ├── templates/
│ │ │ ├── habits.html
│ │ │ └── habit_form.html
│ │ ├── static/css/style.css
│ │ └── application.properties
│ └── test/
├── pom.xml
└── README.md

yaml
Copy code

---

## 🚀 How to Run the Project

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/your-username/habit-tracker.git
cd habit-tracker
### 2️⃣ Build and Run the Application
mvn spring-boot:run
### 3️⃣ Access the Application
👉 Open your browser and go to:
http://localhost:8080/habits

🧩 Example Data
Name	Description	Start Date	Completed
Exercise	Workout 30 mins daily	2025-10-04	✅
Meditation	Meditate 15 mins daily	2025-10-04	☐
Reading	Read 10 pages daily	2025-10-04	☐

📊 Progress Chart
Your progress is automatically displayed in a visual chart using Chart.js!
The percentage updates dynamically whenever you mark a habit as complete.

Progress: 2 / 3 habits completed ✅

🎨 UI Preview
Dashboard View


Add Habit Form


💡 Future Enhancements
🚀 Add user authentication (Spring Security)
🔔 Daily reminders for pending habits
🔥 Streak tracking and achievement badges
🗃️ Migrate from H2 to MySQL or PostgreSQL

👩‍💻 Author
👤 Rambha Rasmitha
💼 Developer of the Habit Tracker Web App
💬 Built using Java, Spring Boot, and Thymeleaf
🌐 GitHub: https://github.com/rambha7024

📜 License
This project is licensed under the MIT License — free to use, share, and modify.

🌈 Quote
“Small daily improvements lead to stunning long-term results.” 🌟

