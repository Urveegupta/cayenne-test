_Authors- Urvee Gupta, Aarushi_
# This Java Project uses cayenne framework to read Database entities and generate corresponding Java Classes

## The Project uses `Maven` as the build Tool

Steps to run-
a. change `your-username-here` and `your-password-here` columns in `pom.xml` file to your credentials.
b. commands -
   1. mvn compile
   2. mvn cayenne:cdbimport (Load Database)
   3. mvn cayenne-modeler:run (opens the modeler to refer to any changes)
   4. mvn cayenne:cgen (generates Java Classes for domain entities)

the Datamap once the database loads is generated at src/main/resources/cayenne folder in the project.
the Java classes are generated in src/main/java/org/apache/cayenne/tutorial/persistent/auto folder in the project.
