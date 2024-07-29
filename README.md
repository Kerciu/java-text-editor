# Java Text Editor

## Description
A simple text editor built in Java that provides basic text editing functionalities through a graphical user interface.

## Requirements
- Java 22

## Installation
1. Clone the repository:
    ```sh
    git clone https://github.com/your_username/java-text-editor.git
    ```

2. Navigate to the project directory:
    ```sh
    cd java-text-editor
    ```

3. Compile the project:
    ```sh
    javac -d out/production/java-text-editor src/**/*.java
    ```

4. Run the application:
    ```sh
    java -cp out/production/java-text-editor com.kacperpackage.MainClass.MainClass
    ```

## Notes
- Ensure that you have Java 22 installed and properly configured on your system.
- The `javac` and `java` commands assume that you have a Java Development Kit (JDK) installed.
- If you encounter any issues with missing dependencies, ensure all required libraries are included in the project.

## Usage
### Toolbar Features:
- **File**
  - *New*: Create a new file
  - *Open*: Open an existing file
  - *Save*: Save the current file; performs "Save As" if not already saved
  - *Save As*: Save the current file as a new .txt file
  - *Exit*: Exit the application

- **Edit**
  - *Undo*: Revert the last change
  - *Redo*: Reapply the last undone change
  - *Find*: Search for text
  - *Replace*: Replace text

- **Format**
  - *Text Wrap*: Toggle text wrapping
  - *Text Align*: Align text *Left* or *Right*
  - *Font*: Choose font, style, size, and color

- **View**
  - *Zoom*: Adjust zoom level (*Zoom In*, *Zoom Out*, *Restore Default*)
  - *Style*: Switch between *Dark Mode* and *Light Mode*

## Project Structure
- `src/` - Source code directory
  - `main/`
    - `java/` - Java source files
    - `resources/` - Resource files

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For questions, feedback, or support:
- **Author**: Kacper Górski
- **LinkedIn**: [Kacper Górski](https://www.linkedin.com/in/kacper-gorski)
- **Instagram**: [@kxcper.gorski](https://www.instagram.com/kxcper.gorski)
- **X**: [@Kerciuu](https://x.com/Kerciuu)
- **GitHub**: [Kerciu](https://github.com/Kerciu)
- **Support**: Email [kerciuuu@gmail.com](mailto:kacper.gorski.contact@gmail.com)

For issues, please open a GitHub Issue.
