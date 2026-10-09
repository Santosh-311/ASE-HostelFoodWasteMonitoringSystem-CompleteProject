# Hostel Food Waste Monitoring System
A full-stack student project with React frontend (VS Code), Spring Boot backend (Spring Tool Suite / STS), and MySQL.

## Features
- Student, kitchen staff and admin roles
- Registration and login with BCrypt password hashing and JWT tokens
- Meal/menu management
- Daily prepared, consumed and leftover quantity records
- Automatic waste percentage calculation
- Student meal ratings and feedback
- Dashboard statistics and waste records
- Daily/weekly/monthly report endpoints
- Responsive dashboard UI and charts
- Input validation and role-based authorization

## Requirements
- Java 21
- Maven 3.9+
- MySQL 8+
- Spring Tool Suite (STS) or Eclipse
- Node.js 20+ and npm
- VS Code

## 1. MySQL setup
In MySQL Workbench:
```sql
CREATE DATABASE hostel_food_waste;
```
Backend defaults: username `root`, blank password. Update `backend/src/main/resources/application.properties` or set `DB_USERNAME`, `DB_PASSWORD`, `DB_URL`, `JWT_SECRET`.

## 2. Import backend into STS
1. Extract the ZIP.
2. Open STS.
3. Select **File → Import → Maven → Existing Maven Projects**.
4. Choose the extracted `backend` folder.
5. Finish and wait for Maven dependencies to download.
6. Open `HostelFoodWasteApplication.java` and choose **Run As → Spring Boot App**.
7. Backend runs at `http://localhost:8080`.

## 3. Run frontend in VS Code
Open the `frontend` folder in VS Code. In terminal:
```bash
npm install
npm run dev
```
Open the URL shown, normally `http://localhost:5173`.

## 4. Create an admin account
1. Register using the UI.
2. In MySQL Workbench:
```sql
USE hostel_food_waste;
UPDATE users SET role='ADMIN' WHERE email='your-email@example.com';
```
3. Log out and log back in.

You can create kitchen staff by updating a registered account's role to `KITCHEN`.

## API overview
- `POST /api/auth/register`
- `POST /api/auth/login`
- `GET /api/dashboard`
- `GET/POST/PUT/DELETE /api/meals`
- `GET/POST /api/waste-records`
- `GET /api/waste-records?period=week`
- `GET/POST /api/feedback`
- `GET /api/reports/summary?period=month`

## Notes
This is a complete educational starter project. Run and test it in your own environment before submission. For production, add email verification, password reset, migrations, audit logging, rate limiting, backups and HTTPS.
"# ASE-HostelFoodWasteMonitoringSystem-CompleteProject" 
