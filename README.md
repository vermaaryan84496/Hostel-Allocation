Smart Hostel Room Allocation System

A Spring Boot based web application that manages hostel rooms and automatically allocates rooms to students based on capacity and facility requirements.

Objective

To design and deploy a working system that manages hostel rooms and allocates rooms to students by selecting the smallest suitable room that satisfies all given conditions such as capacity, AC requirement and attached washroom requirement.

Features

Add new hostel rooms

View all available rooms

Search rooms based on:

minimum required capacity

AC requirement

attached washroom requirement

Automatically allocate the smallest suitable room

Delete rooms

Web based user interface using Thymeleaf

Technology Stack

Java

Spring Boot

Spring Data JPA

PostgreSQL

Thymeleaf

HTML and CSS

Allocation Logic

The system searches all rooms that satisfy:

available capacity ≥ required students

AC requirement

attached washroom requirement

Among the matched rooms, the room with the smallest capacity is selected for allocation.

Project Structure
src/main/java/com/example/hostel
 ├── controller
 ├── service
 ├── repository
 └── entity

How to Run Locally

Create a PostgreSQL database

CREATE DATABASE hostel_db;


Update database credentials in:

src/main/resources/application.properties


Run the application

mvn spring-boot:run


Open in browser

http://localhost:8080

Screens

All Rooms page

Add Room page

Search and Allocate page

Deployment

The application is deployed on Render and is accessible through a public live URL.

(Replace this line with your actual Render URL after deployment.)

GitHub Commits

This project contains multiple meaningful commits covering:

backend implementation

UI development

styling and feature improvements
