![Build Status](https://github.com/your-username/Library-Management-System/actions/workflows/ant.yml/badge.svg)

📚 Library Management System

This is a Java desktop application built to simplify and automate common library operations. Instead of maintaining manual registers, the system provides a digital interface that makes managing books, users, and transactions easier and more reliable.

🚀 Key Features

Role-based access: separate logins for administrators and librarians
Book management: add, edit, delete, and search books
User records: maintain details of students and librarians
Issue & return system: track due dates and calculate fines automatically
Reports and alerts: generate issued/overdue book reports in real time
Authentication: secure login and database protection

🛠️ Tech Stack

Java (Swing, AWT) for the application interface
MySQL for database storage (via JDBC)
Apache NetBeans as the development environment
Ant (build.xml) for build automation
Runs on Windows 10+

⚙️ Setup Instructions:

Clone the repository
git clone https://github.com/your-username/Library-Management-System.git
cd Library-Management-System
Set up the database
Create a MySQL database (example: lms_db)
Import the provided SQL file:
mysql -u root -p lms_db < db.sql
Configure in NetBeans
Open the project in NetBeans
Add the MySQL JDBC driver (lib/mysql-connector.jar) if required
Update database username and password in the code
Run the application
Launch directly from NetBeans
Or execute the batch file:
run_library_management_system.bat

📦 Download

A packaged version (JAR + SQL file) is available under the Releases section.

🔮 Roadmap

Student mobile app
Barcode/QR integration for faster transactions
Cloud-hosted database for remote access

👨‍💻 Author

Developed by Vrinda Modi as part of an academic project.
