# Design-Problems

This repository contains object-oriented design practice problems and implementations in Java.

## Tech Stack

- Java 17
- Plain Java for application code
- Minimal Gradle setup for test execution only

## Repository Structure

- `src/main/java/practicedp/designproblems` - problem implementations
- `src/main/java/practicedp/oop` - OOP learning exercises (chapters)

## Problem Modules

### 1) Quantity (`src/main/java/practicedp/designproblems/quantity`)
- Type-safe quantity model with conversion and arithmetic (`plus`, `minus`, `multiplyBy`, `divideBy`)
- Generic base abstraction via `core/Quantity` + `core/Unit`
- Implemented dimensions:
  - Length: `CENTIMETER`, `METER`, `KILOMETER`
  - Mass: `GRAM`, `KILOGRAM`
  - Color: `RgbColor` with blend operation
- Entry point: `practicedp.designproblems.quantity.Main`
- Problem statement: `src/main/java/practicedp/designproblems/quantity/ProblemStatement.md`

### 2) Biblioteca (`src/main/java/practicedp/designproblems/biblioteca`)
- Library inventory with list/checkout/return workflow
- Uses action-based menu handlers (`actions/*`) implementing `MenuAction`
- Entry point: `practicedp.designproblems.biblioteca.Main`

### 3) Coffee Machine (`src/main/java/practicedp/designproblems/coffeemachine`)
- Two implementations:
  - `naive` - simple flow
  - `better` - cleaner design with `CoffeeFactory`, `Recipe`, and `Inventory`
- Entry points:
  - `practicedp.designproblems.coffeemachine.naive.Main`
  - `practicedp.designproblems.coffeemachine.better.Main`

### 4) BGMI (`src/main/java/practicedp/designproblems/bgmi`)
- Player/lobby model for match setup
- Supports lobby modes (`SOLO`, `DUO`, `SQUAD`) and mode validations
- Entry point: `practicedp.designproblems.bgmi.Main`

## OOP Practice Area

- `src/main/java/practicedp/oop/chapter1` - initial guitar inventory design
- `src/main/java/practicedp/oop/chapter5` and `chapter5b` - refactored instrument search design
- `src/main/java/practicedp/oop/chapter9` - unit/property modeling
- `src/main/java/practicedp/oop/chapter10` - subway/network examples

## Tests

- Test framework: JUnit 5
- Scope: currently focused on the quantity module (`LengthQuantityTest`, `MassQuantityTest`, `RgbColorTest`)
- Run tests:

```bash
gradle test
```

This project does not use framework dependencies (for example, Spring/Lombok). Gradle is kept only to make JUnit test execution simple and repeatable.