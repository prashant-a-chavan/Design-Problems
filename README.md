# Design-Problems

This repository contains object-oriented design practice problems and implementations in Java.

## Tech Stack

- Java 17
- Gradle
- JUnit 5

## Project Structure

- `src/main/java` - production code
- `src/test/java` - unit tests
- `src/main/java/practicedp/designproblems/quantity` - quantity design problem implementation

## Solved Design Problems

Under `src/main/java/practicedp/designproblems`, the following problems are implemented:

- `biblioteca` - Library management system (book inventory, issue/return flows)
- `quantity` - Quantity and unit conversion system with arithmetic and validation
- `coffeemachine` - Coffee vending machine (recipes, ingredients, refill handling)
- `bgmi` - BGMI match management (players, lobbies, match/game-mode flows)
- `atm` - ATM workflow (authentication, balance, withdraw/deposit operations)

Also present:

- `techprime` - scaffold/stub module

### Quantity Module Notes

The quantity module supports:

- unit conversion
- arithmetic on compatible quantities (`plus`, `minus`, `multiplyBy`, `divideBy`)
- equality across units using base-unit normalization
- input validation and null-safety

Problem statement:

- `src/main/java/practicedp/designproblems/quantity/ProblemStatement.md`

## Build and Test

Run from repository root:

```bash
gradle clean test
```

Use local Gradle (wrapper directory is not included in this project layout).

## Run Demo Entry Point

The sample entry point for quantity usage is:

- `src/main/java/practicedp/designproblems/quantity/Main.java`

You can run it from your IDE, or via Gradle if an application task is configured in your setup.
