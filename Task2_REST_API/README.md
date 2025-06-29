
## Objective
Create a Java program that fetches data from a public REST API and shows it in a simple format.

## What was done
- Made a Java program (`RestApiClient.java`) that gets random user data from the internet and prints the details.

## How to run
1. Download `json-20210307.jar` from: https://repo1.maven.org/maven2/org/json/json/20210307/json-20210307.jar
2. Put the JAR file in this folder.
3. Open terminal in this folder and run:
   ```sh
   javac -cp ".;json-20210307.jar" RestApiClient.java
   java -cp ".;json-20210307.jar" Task2_REST_API.RestApiClient
   ```
   *(Use `:` instead of `;` if you are on Mac/Linux)*

## Status
Completed.
