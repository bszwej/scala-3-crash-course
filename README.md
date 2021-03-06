# Scala 3 crash course

Scala 3 RC1 is already here and we can expect the final release soon! That's why it's a good timing for playing around and seeing what's there. In this workshop we'll see the most interesting and important features like enums, contextual abstractions (givens, extension methods, type classes, context functions), new types (opaque, unions and intersections). We'll also see what's dropped and what changed. During the exercises, you'll be refactoring Scala 2 to Scala 3 yourself using the new shiny constructs.

This workshop is dedicated to Scala 2 developers and assumes prior knowledge about implicits, ADTs and type classes.

## Before the workshop
1. Checkout this repository
```sh
git clone git@github.com:bszwej/scala-3-crash-course.git
```

2. Compile with sbt
```sh
sbt compile
```

3. Import it in your favorite IDE
- VSCode + metals (recommended)
- Intellij

## Table of contents
1. Braceless syntax
2. Enums
3. Contextual language features:
    - given/using
    - extension methods
    - type classes
    - implicit conversion
    - scoping of given/using
    - contextual functions
4. Opaque types
5. Union/Intersection types
6. All the small bits
7. Type class derivation (not ready yet)
8. Macros (not ready yet)
