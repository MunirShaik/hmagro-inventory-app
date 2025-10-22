HM Agro Inventory - Sample Project
=================================

This is a minimal Spring Boot + Thymeleaf project for managing inventory categories and materials.
It is intended as a starting point for HM Agro.

Quick start:
1. Ensure Java 17 and Maven are installed.
2. Create a PostgreSQL database: hm_agro_inventory
3. Update src/main/resources/application.properties with your DB username/password.
4. From the project root run: mvn spring-boot:run
5. Open http://localhost:8080/inventory/categories

Project structure:
- src/main/java/com/hm/agro/inventory/...
- src/main/resources/templates - Thymeleaf templates
- src/main/resources/static/css - styles

Notes:
- This is a simple starter. For production, add security, validations, and better error handling.
