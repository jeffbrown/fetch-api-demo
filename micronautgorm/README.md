# Micronaut GORM Implementation

## Overview

This project contains a Micronaut application which uses
GORM to communicate with the Postgres database.  This
implementation assumes that postgres is running locally on
port `5432`, a database named `survey` exists
and that the app may connect to that database with
user name `postgres` and an empty password.  All of the
database connection info is in `src/main/resources/application.yml`.

## Running With Gradle

From the command line the application may be run with Gradle:

    ./gradlew run
    
## Build An Executable Jar With Gradle

The `assemble` task will create an executable `.jar` file:

    ./gradlew assemble
    java -jar build/libs/micronautgorm-0.1-all.jar