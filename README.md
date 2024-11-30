## Overview

Cryptography is a Java-based project that utilizes JavaFX for the graphical user interface. The project is built using
Maven.

## Prerequisites

- JDK 21 or later
- Maven 3.6.0 or later

### Setup

1. **Clone the repository:**
   ```sh
   git clone https://github.com/wissemgrari/java-fx-cryptography.git
   cd java-fx-cryptography
   ```
2. **Build the project:**
   ```sh
   mvn clean install
   ```
3. **Run the application:**
   ```sh
   mvn javafx:run
   ```

### Project Structure

* ```src/main/java```: Contains the main application source code.
* ```src/main/resources```: Contains the application resources.
* ```src/test/java```: Contains the unit tests.

### Dependencies

* JavaFX Controls
* JavaFX FXML
* JUnit 5

### Configuration

The project uses the `javafx-maven-plugin` to handle JavaFX dependencies and execution. Ensure the `pom.xml` is
correctly configured with the necessary dependencies and plugins.

### License

This project is licensed under the MIT License. See the `LICENSE` file for details.
