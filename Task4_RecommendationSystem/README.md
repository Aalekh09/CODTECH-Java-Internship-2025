# Task 4 - AI-Based Recommendation System

## Objective
Build a simple recommendation system in Java that suggests items to users based on their preferences.

## What was done
- Created a Java program (`RecommendationSystem.java`) that reads user-item ratings from a CSV file.
- The program recommends items to a user based on what similar users liked (collaborative filtering).
- Included a sample data file (`sample_data.csv`).

## How to run
1. Open a terminal in the `Task4_RecommendationSystem` folder.
2. Compile the program:
   ```sh
   javac RecommendationSystem.java
   ```
3. Run the program:
   ```sh
   java Task4_RecommendationSystem.RecommendationSystem
   ```
4. When asked, enter a user name (e.g., Alice, Bob, or Carol) to see recommendations.

## Status
Completed.

## Output
```
Enter user name for recommendations: Alice
Recommended items for Alice: [Eraser]
```
