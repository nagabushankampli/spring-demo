# spring-demo
Demo spring boot application

Server port 8081 configured in application.properties 

Actuator end points for monitoring

Controller/Service

GET request to /api/contact/ returns a list of contacts
GET request to /api/contact/1 returns the contact with ID 1
POST request to /api/contact/ with a contact object as JSON creates a new contact
PUT request to /api/contact/3 with a contact object as JSON updates the contact with ID 3
DELETE request to /api/contat/4 deletes the contact with ID 4
DELETE request to /api/contact/ deletes all the contact