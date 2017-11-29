# Isomorphic Validator

JSR-303 compatibile validator that allows to create JavaScript based validators with the same logic for backend and frontend.

## Usage examples

### Creating simple validator

Create js validation file and put in resource directory. File should contain methods returning true or false and one parameter for value of field to be tested.
Create js files with validation logic

testValidator.js
```
function validateLengthMin(test) {
     if(test == null) {
        return true;
     }
     return test.length>5;
}

function validateLengthMax(test) {
     if(test == null) {
        return true;
     }
     return test.length<10;
}
```


Annotate your entity properties with @IsomorphicConstraint and disable default validation rules by adding @Constraint(validatedBy = {}):

```
@Constraint(validatedBy = {})
@IsomorphicConstraint(jsFilePath = "testValidator.js", jsMethods = {"validateLengthMin", "validateLengthMax"})
private String fieldToTest;
```

It's also possible to use multiple @IsomorphicConstraint annotations on sinsgle field. For examples please check project unit tests.

## Prerequisites

```
Java 1.8 or higher
Gradle
Any JSR-303 validation implemmentation (for instance Hibernate Validator)
```

## Built With

* [Gradle] - Dependency Management

## Author

* **Tomasz Tokarczyk** (https://github.com/tomek39856)
