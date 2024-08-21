# Kitchen Sink Migration
This is the migration of Jboss quickstart project kitchensink(https://github.com/ghoelzer-aws/jboss-eap-kitchensink/tree/master/kitchensink) into modern tech stack Spring Boot as Backend and MongoDB 7 as Database.

## Requirements

* Java 21
* Maven 3.6+
* MongoDB 7 (local instance on default port)

## Instructions

1. Clone the repository:
git clone: https://github.com/abbas-ahmad/kitchen-sink-migration.git
2. Build the project:
   mvn clean install
3. Run the application:mvn spring-boot:run


## MongoDB Configuration

* Make sure MongoDB 7 is installed and running on your local machine.
* The application uses the default MongoDB port (27017).
* If you need to change the MongoDB port or credentials, update the `application.properties` file accordingly.

## Note

* This application requires Java 21 to run.
* Ensure you have Maven installed and configured correctly.