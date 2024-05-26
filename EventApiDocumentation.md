# Event Ticketind And Management API

##Introduction
This API is designed to streamline the process of event creation, ticket sales, and attendee management. It's built with the needs of event organizers in mind, providing a comprehensive set of tools to handle all aspects of event management icluding informations for the event, the tickets, the venue as well as the attendees.

## Base URL
`http://localhost:8080/api`

## Endpoints

### 1. Create a New Attendee

**HTTP Method:** `POST`

**Endpoint:** `/attendee`

**Description:** Allows creation of a new attendee with name and email details.

**Request Headers:**

-   `Content-Type: application/json`

**Request Body:**
```json
{
"name": "Ana Maria",
"email": "anna_m@gmail"
}
```

**Responses:**

-   **201 Created:**

 ``` json
 {
"attendee_id": 1,
"name": "Ana Maria",
"email": "anna_m@gmail"
} 
 ```
----------

### 2. Retrieve Attendee Details

**HTTP Method:** `GET`

**Endpoint:** `/attendee/{attendee_id}`

**Description:** Retrieve details of a single attendee by their ID.

**Request Headers:**

-   `Accept: application/json`

**Path Parameters:**

-   `attendee_id` (integer): ID of the attendee

**Responses:**
-   **200 OK:**
    
    ```json
    {
    "attendee_id": 1,
     "name": "Ana Maria",
     "email": "anna_m@gmail"
    } 
    ```

----------

### 3. Create a New Event

**HTTP Method:** `POST`

**Endpoint:** `/event`

**Description:** Allows creation of a new event with name, venue, time, and date details.

**Request Headers:**

-   `Content-Type: application/json`

**Request Body:**

```json
{
  "name": "Tech Conference",
  "venue": "Convention Center",
  "time": 10.00,
  "date": "2024-06-15"
}
```

**Responses:**

-   **201 Created:**
    ```json
    {
      "event_id": 1,
      "name": "Tech Conference",
      "venue": "Convention Center",
      "time": 10.00,
      "date": "2024-06-15",
      "tickets": [],
      "venueObject": []
    }
    ```
    


----------

### 4. Retrieve Event Details

**HTTP Method:** `GET`

**Endpoint:** `/event/{event_id}`

**Description:** Retrieve details of a single event by its ID.

**Request Headers:**

-   `Accept: application/json`

**Path Parameters:**

-   `event_id` (integer): ID of the event

**Responses:**

-   **200 OK:**
    
 ```   json
{
"event_id": 1,
"name": "Tech Conference",
"venue": "Convention Center",
"time": 10.00,
"date": "2024-06-15",
"tickets": [
{
"ticket_id": 101,
"price": 50.00,
"seatNumber": "A1",
"purchaseDate": "2024-05-19T12:00:00",
"status": "Purchased"
}
],
"venueObject": [
{
"venue_id": 201,
"name": "Convention Center",
"location": "Downtown"
}
]
}
``` 
----------

### 5. Create a New Ticket

**HTTP Method:** `POST`

**Endpoint:** `/ticket`

**Description:** Allows creation of a new ticket with price, seat number, purchase date, and status details.

**Request Headers:**

-   `Content-Type: application/json`

**Request Body:**

```json

{
  "price": 50.00,
  "seatNumber": "A1",
  "purchaseDate": "2024-05-19T12:00:00",
  "status": "Purchased",
  "event_id": 1,
  "attendee_id": 1
}
```

**Responses:**

-   **201 Created:**
    
```    json
    {
      "ticket_id": 101,
      "price": 50.00,
      "seatNumber": "A1",
      "purchaseDate": "2024-05-19T12:00:00",
      "status": "Purchased",
      "event": {
        "event_id": 1,
        "name": "Tech Conference"
      },
      "attendee": {
        "attendee_id": 1,
        "name": "John Doe"
      }
    }
   ```


----------

### 6. Retrieve Ticket Details

**HTTP Method:** `GET`

**Endpoint:** `/ticket/{ticket_id}`

**Description:** Retrieve details of a single ticket by its ID.

**Request Headers:**

-   `Accept: application/json`

**Path Parameters:**

-   `ticket_id` (integer): ID of the ticket

**Responses:**

-   **200 OK:**
    
  ```  json    
    {
      "ticket_id": 101,
      "price": 50.00,
      "seatNumber": "A1",
      "purchaseDate": "2024-05-19T12:00:00",
      "status": "Purchased",
      "event": {
        "event_id": 1,
        "name": "Tech Conference"
      },
      "attendee": {
        "attendee_id": 1,
        "name": "John Doe"
      }
}
```
    

----------

### 7. Create a New Venue

**HTTP Method:** `POST`

**Endpoint:** `/venue`

**Description:** Allows creation of a new venue with name and location details.

**Request Headers:**

-   `Content-Type: application/json`

**Request Body:**

```json
{
  "name": "Convention Center",
  "location": "Downtown",
  "event_id": 1
}
```

**Responses:**

-   **201 Created:**
```  json
    {
      "venue_id": 201,
      "name": "Convention Center",
      "location": "Downtown",
      "event": {
        "event_id": 1,
        "name": "Tech Conference"
      }
      } 
  ```

----------

### 8. Retrieve Venue Details

**HTTP Method:** `GET`

**Endpoint:** `/venue/{venue_id}`

**Description:** Retrieve details of a single venue by its ID.

**Request Headers:**

-   `Accept: application/json`

**Path Parameters:**

-   `venue_id` (integer): ID of the venue

**Responses:**

-   **200 OK:**
 ```    json
    {
      "venue_id": 201,
      "name": "Convention Center",
      "location": "Downtown",
      "event": {
        "event_id": 1,
        "name": "Tech Conference"
      }
    }
```
