# CRUD API

The REST API performs CRUD operations on Animal objects as described below.

## Installation
- Get the project
    - clone
  
        `git clone https://github.com/nhildret/animal-api-assignment-4.git`
    - download zip.
- Open the project in IntelliJ.
- [`/src/main/resources/application.properties`](https://github.com/nhildret/animal-api-assignment-4/blob/master/assignment_4/src/main/resources/application.properties) file is the configuration for the MySQL database on your localhost.
  - the database name is on the `datasource.url` property between the last `/` and the `?`. In this case the database name is `animal-api-assignment-4`.
  - You MUST have the database up and running before running the project! 
    - Open your XAMPP Control Panel.
    - Start the Apache server.
    - Start MySQL.
    - Click on MySQL "Admin" to open up the DBMS.
    - Ensure the database that you need is available.
- Build and run the main class. You should see 2 new tables created in the aforementioned database.

## API Endpoints
Use POSTMAN to try the following endpoints:

## Get list of Animals

### Request

    `GET /animals/all`

    `http://localhost:8080/animals/all`

   
### Response

     [
   
      {
         "animalId": 1,
         "name": "sample1",
         "scientificName": "sampleScientific1",
         "animalClass": "sampleClass1",
         "habitat": "sampleHabitat1",
         "description": "sampleDescription1"
     },
     {
         "animalId": 2,
         "name": "sample2",
         "scientificName": "sampleScientific2",
         "animalClass": "sampleClass2",
         "habitat": "sampleHabitat2",
         "description": "sampleDescription2"
     }
    
     ]

## Get a specific Animal

### Request

    `GET /animals/{animalId}`

    `http://localhost:8080/animals/1`

### Response

      {
         "animalId": 1,
         "name": "sample1",
         "scientificName": "sampleScientific1",
         "animalClass": "sampleClass1",
         "habitat": "sampleHabitat1",
         "description": "sampleDescription1"
     }
     
## Create a new Animal

### Request

    `POST /animals/new`
    
    `http://localhost:8080/animals/new` --data '{ "name": "sample4", "scientificName": "sampleScientific", "animalClass": "sampleClass", "habitat": "sampleHabitat", "description": "sampleDescription" }'

   ### Response

   [

     {
         "animalId": 1,
         "name": "sample1",
         "scientificName": "sampleScientific1",
         "animalClass": "sampleClass1",
         "habitat": "sampleHabitat1",
         "description": "sampleDescription1"
     },
     {
         "animalId": 2,
         "name": "sample2",
         "scientificName": "sampleScientific2",
         "animalClass": "sampleClass2",
         "habitat": "sampleHabitat2",
         "description": "sampleDescription2"
     }
     
  ]

## Update an existing Animal

### Request

    `PUT /animals/update/{animalId}`
    
    `http://localhost:8080/animals/update/1` --data '{ "name": "sampleUpdated", "scientificName": "updatedScientific", "animalClass": "updatedClass", "habitat": "updatedHabitat", "description": "updatedDescription" }'

### Response

    {
        "animalId": 1,
        "name": "sampleUpdated",
        "scientificName": "updatedScientific",
        "animalClass": "updatedClass",
        "habitat": "updatedHabitat",
        "description": "updatedDescription"
    }

## Delete an existing Animal

### Request

    `DELETE /animals/delete/{animalId}`
    
    `http://localhost:8080/animals/delete/1`

### Response

   [
     
     {
         "animalId": 2,
         "name": "sample2",
         "scientificName": "sampleScientific2",
         "animalClass": "sampleClass2",
         "habitat": "sampleHabitat2",
         "description": "sampleDescription2"
     },
     {
         "animalId": 3,
         "name": "sample3",
         "scientificName": "sampleScientific3",
         "animalClass": "sampleClass3",
         "habitat": "sampleHabitat3",
         "description": "sampleDescription3"
     },
     {
         "animalId": 4,
         "name": "sample4",
         "scientificName": "sampleScientific",
         "animalClass": "sampleClass",
         "habitat": "sampleHabitat",
         "description": "sampleDescription"
     }
     
   ]
