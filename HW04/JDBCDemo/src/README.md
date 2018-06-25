# Assignment 4

## Instructions to execute
  - compile with:
  ````
    javac LoadData.java
  ````
  - Execute with:
  ````
    java -cp mysql-connector-java-8.0.11.jar LoadData
  ````
  - -cp links explicitly links the driver to the java file.

## Before Running the File.

  - There is some conflict with the data I have provided with the database as part of the third Assignment and the data that we are supposed to load as a part of this assignment.
    Basically the entry for the user "Bob" with twitter handle "@bob" is redundant and since the handle field is unique, this would throw an SQL exception.
  - I have provided the required exception handling so that the loading of the rest of the users with continue, without any errors, to ensure a smooth data load, however all the tweets, that we mean to be attributed to new user "Bob" be attributed to the old "Bob".
  - Additionally, I have provided an SQL script that deletes user "Bob" from the database, to avoid the confusion, or this assignment is run on a blank database, this situation won't arise in the first place.
  -Either Ways, I have provided with all the necessary steps to ensure that this confusion doesn't affect the usability of my code.
