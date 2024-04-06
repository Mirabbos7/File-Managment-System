# File Management System

This task will help you understand how to manage CSV and JSON files using [Apache Maven](https://maven.apache.org/), [Open CSV](https://mvnrepository.com/artifact/com.opencsv/opencsv) and [Jackson Databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind).

## Preconditions

This tasks assumes that you've already created `file-management-system` project with proper structure using Maven. 
To find the latest version of the _opencsv_ and _jackson-databind_ dependencies follow the links provided above in the task overview.

The project should follow the below structure:

```tree
file-management-system
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── file
│   │   │           └── management
│   │   │               ├── utils
│   │   │               │   ├── CsvUtils.java
│   │   │               │   └── JsonUtils.java     
│   │   │               └── FileManagementApplication.java
│   │   └── resources
│   │       ├── cats (csv)
│   │       │   └── owners (csv)
│   │       └── dogs (json)
│   └── test
│       ├── java
│       └── resources
├── pom.xml
└── README.md  
```

It's advised to create some test files in csv and json folders for testing purposes.

## Description

This is a console file management app which gives you the opportunity to 
read, edit and remove data from csv (containing cat data) and json files (containing dog data). 
When started the app should give you a list of commands available:

| Command code | Short description                              |
|--------------|:-----------------------------------------------|
| csv-read     | reads row with specified id from csv file      |
| csv-write    | adds single row into csv file                  |
| csv-remove   | removes single row from csv file               |
| json-read    | reads object with specified key from json file |
| json-write   | adds single record into json file              |
| json-remove  | removes single record from json file           |

### Command descriptions

#### csv-read

This command reads a row with a specified id from a CSV file.
<br>
The id is the unique identifier for each row in the CSV file.
<br>
For example, to read the cat with id 1, you would use the command csv-read 1

#### csv-write

This command adds a single row into a CSV file.
<br>
You need to provide the data for each column in the row.
<br>
For example, to add a new cat, you would use the command csv-write 3,Fluffy,2,White,4.5,PERSIAN,1.

#### csv-remove

This command removes a single row from a CSV file. 
<br>
You need to provide the id of the row to remove. 
<br>
For example, to remove the cat with id 1, you would use the command csv-remove 1.

#### json-read

This command reads an object with a specified key from a JSON file. 
<br>
The key is the unique identifier for each object in the JSON file.
<br>
For example, to read the dog with key “1”, you would use the command json-read 1.

#### json-write

This command adds a single record into a JSON file. 
<br>
You need to provide the data for each field in the record.
<br>
For example, to add a new dog, you would use the command json-write 

```json
{
  "id": 3,
  "name": "Fido",
  "age": 3,
  "color": "Black",
  "weight": 30.0,
  "breed": "LABRADOR",
  "owner": {
    "id": 2,
    "name": "John",
    "age": 30
  }
}
```

#### json-remove

This command removes a single record from a JSON file. 
<br>
You need to provide the key of the record to remove. 
<br>
For example, to remove the dog with key “1”, you would use the command json-remove 1.

## Entity descriptions

For **cats**:
- `id` (required): A unique identifier for each cat. It should be an `int`.
- `name` (required): The name of the cat. It should be a `String`.
- `age` (optional): The age of the cat. It should be an `int`.
- `color` (optional): The color of the cat. It should be a `String`.
- `weight` (optional): The weight of the cat. It should be a `double`.
- `breed` (required): The breed of the cat. It should be an `enum` with possible values like `PERSIAN`, `SIAMESE`, `MAINE_COON`, `RAGDOLL`, `BENGAL`, `SPHYNX`, `BRITISH_SHORTHAIR`, `SCOTTISH_FOLD`, `ABYSSINIAN`, `RAGAMUFFIN`.
- `owner` (optional): The owner of the cat. It should be a `Person` object.

For **dogs**:
- `id` (required): A unique identifier for each dog. It should be an `int`.
- `name` (required): The name of the dog. It should be a `String`.
- `age` (optional): The age of the dog. It should be an `int`.
- `color` (optional): The color of the dog. It should be a `String`.
- `weight` (optional): The weight of the dog. It should be a `double`.
- `breed` (required): The breed of the dog. It should be an `enum` with possible values like `LABRADOR`, `GERMAN_SHEPHERD`, `BULLDOG`, `BEAGLE`, `POODLE`, `ROTTWEILER`, `YORKSHIRE_TERRIER`, `BOXER`, `DACHSHUND`, `SIBERIAN_HUSKY`.
- `owner` (optional): The owner of the dog. It should be a `Person` object.

The `Person` class should have the following fields:
- `id` (required): A unique identifier for each person. It should be an `int`.
- `name` (required): The name of the person. It should be a `String`.
- `age` (optional): The age of the person. It should be an `int`.
