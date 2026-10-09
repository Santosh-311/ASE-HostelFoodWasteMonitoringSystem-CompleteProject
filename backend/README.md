# Backend — Spring Boot + MySQL
Import this folder in STS: File → Import → Maven → Existing Maven Projects.
Create database `hostel_food_waste`, set DB credentials in application.properties, then run `HostelFoodWasteApplication`.
Register user in UI, then use MySQL:
`UPDATE users SET role='ADMIN' WHERE email='admin@example.com';`
Use role `KITCHEN` for kitchen staff.
