API with Java, SpringBoot, Maven On POSTMAN: http://localhost:8080/animals
IntelliJ IDEA, MySQL Database (XAMPP), POSTMAN

Get list of all animals
Request
GET /animals
http://localhost:8080/animals
Response:
[
  {
    "animalId": 2,
    "name": "Blue Jay",
    "scientificName": "Cyanocitta cristata",
    "species": "Bird",
    "habitat": "Forest",
    "description": "A beautiful blue bird."
  },
  {
    "animalId": 4,
    "name": "Tiger",
    "scientificName": "Panthera tigris",
    "species": "mammal",
    "habitat": "forests",
    "description": "A large wild cat known for its stripes and strength, native to Asia."
  },
  {
    "animalId": 5,
    "name": "Monkey",
    "scientificName": "Macaca mulatta",
    "species": "mammal",
    "habitat": "tropical forests",
    "description": "An intelligent primate known for its dexterity, curiosity, and social behavior."
  },
  {
    "animalId": 6,
    "name": "Dog",
    "scientificName": "Canis lupus familiaris",
    "species": "mammal",
    "habitat": "domestic",
    "description": "A loyal domestic animal, often referred to as man's best friend."
  },
  {
    "animalId": 7,
    "name": "Cat",
    "scientificName": "Felis catus",
    "species": "mammal",
    "habitat": "domestic",
    "description": "A small domesticated carnivorous mammal known for its independence and agility."
  },
  {
    "animalId": 8,
    "name": "Dolphin",
    "scientificName": "Delphinus delphis",
    "species": "mammal",
    "habitat": "oceans",
    "description": "A highly intelligent aquatic mammal known for its playful behavior and friendly interaction with humans."
  },
  {
    "animalId": 9,
    "name": "Lion",
    "scientificName": "Panthera leo",
    "species": "mammal",
    "habitat": "savannas",
    "description": "The lion is a large wild cat native to Africa."
  }
]


Get a specific animal by ID
Request
GET /animals/{animalId}

http://localhost:8080/animals/2
Response: 
{
  "animalId": 2,
  "name": "Blue Jay",
  "scientificName": "Cyanocitta cristata",
  "species": "Bird",
  "habitat": "Forest",
  "description": "A beautiful blue bird."
}

Create a new animal
Request
POST /animals

http://localhost:8080/animals
Request Body: {
  "name": "Penguin",
  "scientificName": "Aptenodytes forsteri",
  "species": "Bird",
  "habitat": "Antarctic",
  "description": "A flightless bird known for its distinctive black and white coloring and waddling walk."
}

Response: {
  "animalId": 10,
  "name": "Penguin",
  "scientificName": "Aptenodytes forsteri",
  "species": "Bird",
  "habitat": "Antarctic",
  "description": "A flightless bird known for its distinctive black and white coloring and waddling walk."
}

Update an existing animal
Request
PUT /animals/{animalId}

http://localhost:8080/animals/2
Request Body: {
  "name": "Updated Blue Jay",
  "scientificName": "Cyanocitta cristata",
  "species": "Bird",
  "habitat": "Forest",
  "description": "A small bird with an updated name."
}
Response: {
  "animalId": 2,
  "name": "Updated Blue Jay",
  "scientificName": "Cyanocitta cristata",
  "species": "Bird",
  "habitat": "Forest",
  "description": "A small bird with an updated name."
}

Delete an existing animal
Request
DELETE /animals/{animalId}

http://localhost:8080/animals/2
Response: [
  {
    "animalId": 4,
    "name": "Tiger",
    "scientificName": "Panthera tigris",
    "species": "mammal",
    "habitat": "forests",
    "description": "A large wild cat known for its stripes and strength, native to Asia."
  },
  {
    "animalId": 5,
    "name": "Monkey",
    "scientificName": "Macaca mulatta",
    "species": "mammal",
    "habitat": "tropical forests",
    "description": "An intelligent primate known for its dexterity, curiosity, and social behavior."
  },
  {
    "animalId": 6,
    "name": "Dog",
    "scientificName": "Canis lupus familiaris",
    "species": "mammal",
    "habitat": "domestic",
    "description": "A loyal domestic animal, often referred to as man's best friend."
  }
]

Get animals by species
Request
GET /animals/species/{species}
http://localhost:8080/animals/species/mammal
Response: [
  {
    "animalId": 4,
    "name": "Tiger",
    "scientificName": "Panthera tigris",
    "species": "mammal",
    "habitat": "forests",
    "description": "A large wild cat known for its stripes and strength, native to Asia."
  },
  {
    "animalId": 5,
    "name": "Monkey",
    "scientificName": "Macaca mulatta",
    "species": "mammal",
    "habitat": "tropical forests",
    "description": "An intelligent primate known for its dexterity, curiosity, and social behavior."
  },
  {
    "animalId": 6,
    "name": "Dog",
    "scientificName": "Canis lupus familiaris",
    "species": "mammal",
    "habitat": "domestic",
    "description": "A loyal domestic animal, often referred to as man's best friend."
  }
]

Search animals by name
Request
GET /animals/search?name={name}
http://localhost:8080/animals/search?name=blue
Response: [
  {
    "animalId": 2,
    "name": "Blue Jay",
    "scientificName": "Cyanocitta cristata",
    "species": "Bird",
    "habitat": "Forest",
    "description": "A beautiful blue bird."
  }
]


