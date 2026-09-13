# Quantity Problem Statement

## Objective
Design and implement an extensible **Quantity** system to model measurable values with units. The system must support conversion, arithmetic, validation, and equality while maintaining type safety and clean object-oriented design.

## Context
A quantity is represented by:
- a numeric value
- a unit

You need to model at least two dimensions:
- **Length** (`cm`, `m`, `km`)
- **Mass** (`g`, `kg`)

Operations should only be allowed between quantities of the same dimension.

## Requirements

### 1) Quantity Creation
- Create quantities using value + unit (for example, `KILOMETER.of(1.5)`).
- Reject invalid numeric values:
  - `NaN`
  - `+Infinity`
  - `-Infinity`

### 2) Unit Conversion
- Convert a quantity to another unit in the same dimension.
- Examples:
  - `100 cm -> 1 m`
  - `1 kg -> 1000 g`

### 3) Arithmetic Operations
Implement immutable operations:
- `plus(other)`
- `minus(other)`
- `multiplyBy(scalar)`
- `divideBy(divisor)`

Rules:
- For `plus` and `minus`, convert the right operand into the left operand's unit before computing.
- Preserve the left operand's unit in the result.
- Reject invalid scalar/divisor values (`NaN`, infinities).
- Reject division by zero.

### 4) Equality and Hashing
- Quantities with equivalent base values must be equal across units.
- Examples:
  - `1 km == 1000 m`
  - `1 kg == 1000 g`
- `hashCode` must remain consistent with `equals`.

### 5) String Representation
- Return a readable format such as:
  - `1.5 km`
  - `500 g`

### 6) Null Safety
Reject null values for required parameters:
- unit
- target conversion unit
- other quantity in arithmetic operations

## Design Expectations (OOP/SOLID)
- Keep shared behavior in abstractions.
- Avoid duplication in unit conversion logic.
- Keep value objects immutable.
- Ensure the design is open for extension (easy to add new dimensions later).

## Sample Scenarios
- `KILOMETER.of(1).plus(METER.of(1)) = 1.001 km`
- `KILOGRAM.of(1).minus(GRAM.of(500)) = 0.5 kg`
- `GRAM.of(2500).multiplyBy(2) = 5000 g`
- `GRAM.of(5000).divideBy(2) = 2500 g`
- `KILOGRAM.of(1).equals(GRAM.of(1000)) = true`

## Acceptance Criteria
- All required operations and conversions behave correctly.
- Validation errors are thrown for invalid inputs.
- Equality/hashCode work for same-unit and cross-unit comparisons.
- Unit tests cover happy path, edge cases, and failure cases.

