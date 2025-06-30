# Task 3 - Multithreaded Chat Application

## Objective
Build a chat application in Java where multiple clients can chat with each other in real time using sockets and multithreading.

## What was done
- Created a server program (`ChatServer.java`) that handles multiple clients at once.
- Created a client program (`ChatClient.java`) that connects to the server and lets users chat.

## How to run
**Important:** Always run the commands from the project root folder (`E:\PROJECT\CODTECH-Java-Internship-2025`), NOT from inside the `Task3_ChatApplication` folder.

1. Open two or more terminals in the project root folder.
2. **Compile both files:**
   ```sh
   javac Task3_ChatApplication/ChatServer.java Task3_ChatApplication/ChatClient.java
   ```
3. **Start the server in one terminal:**
   ```sh
   java Task3_ChatApplication.ChatServer
   ```
4. **Start a client in another terminal:**
   ```sh
   java Task3_ChatApplication.ChatClient
   ```
5. You can start more clients by opening more terminals and running the client command again.
6. Each client will be asked for a name. Type messages and see them appear for all connected users.

**Note:** If you run the commands from inside the `Task3_ChatApplication` folder, you will get an error like `Could not find or load main class`. Always run from the project root.

## Status
Completed.
