# Unofficial Clash Royale Stats API

This project is an unofficial API for managing Clash Royale statistics, including information about players, cards, and upgrade costs.

## Technologies Used

- Java 17
- Spring Boot 3.2.2
- Spring Data JPA
- PostgreSQL
- Maven

## Features

- Retrieve information about Clash Royale players and their statistics.
- Get details about Clash Royale cards.
- Calculate total upgrade costs for players based on their card levels.

## Setup

1. **Clone the repository:**

2. **Database Setup:**
- Install PostgreSQL and create a database named `clashroyalestats`.
- Update `application.properties` with your PostgreSQL username and password.

3. **Run the Application:**
- Open the project in IntelliJ IDEA.
- Build and run the project.

4. **Access API Endpoints:**
- Once the application is running, you can access the API endpoints:
  - Cards: `http://localhost:8080/api/v1/cards`
  - Players: `http://localhost:8080/api/v1/players/{playerId}`

## API Endpoints

- `GET /api/v1/cards`: Get all Clash Royale cards.
- `GET /api/v1/players/{playerId}`: Get details of a specific player by player ID.
