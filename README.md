# Design-Problems

This repository contains object-oriented design practice problems and implementations in Java.

## Tech Stack

- Java 17
- Plain Java for application code
- Minimal Gradle setup for test execution only

## Project Structure

- `src/main/java` - production code
- `src/test/java` - JUnit tests
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

## Compile and Run (Plain Java)

Compile all production sources:

```bash
mkdir -p out
javac -d out $(find src/main/java -name "*.java")
```

Run an entry point (example: quantity module):

```bash
java -cp out practicedp.designproblems.quantity.Main
```

## Run Tests (Minimal Gradle)

Run tests only:

```bash
gradle test
```

This project does not use framework dependencies (for example, Spring/Lombok). Gradle is kept only to make JUnit test execution simple and repeatable.

## Run Demo Entry Point

The sample entry point for quantity usage is:

- `src/main/java/practicedp/designproblems/quantity/Main.java`

You can run it from your IDE, or directly via `java -cp out ...` after compilation.
