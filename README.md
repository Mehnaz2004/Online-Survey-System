#Terminal-Based Survey System Using Java

## Overview

The Survey System is a simple Java-based console application that allows users to create surveys, add questions with multiple-choice options, answer surveys, and display the results. The system consists of three main classes: `Survey`, `Question`, and `SurveySystem`, along with a `Main` class to handle user interaction.

## Features

- **Create Surveys**: Users can create new surveys with a title and add multiple-choice questions to them.
- **Answer Surveys**: Users can respond to surveys by providing answers to each question.
- **Display Survey Results**: Users can view the responses for a specific survey.

## Classes

### Survey

- **Attributes**:
  - `title`: The title of the survey.
  - `questions`: A list of `Question` objects associated with the survey.
- **Methods**:
  - `addQuestion(Question question)`: Adds a question to the survey.
  - `getQuestions()`: Returns the list of questions in the survey.
  - `getTitle()`: Returns the title of the survey.

### Question

- **Attributes**:
  - `text`: The text of the question.
  - `options`: A list of options for the question.
- **Methods**:
  - `addOption(String option)`: Adds an option to the question.
  - `getOptions()`: Returns the list of options for the question.
  - `getText()`: Returns the text of the question.

### SurveySystem

- **Attributes**:
  - `listOfSurveys`: A list of all surveys created.
  - `surveyResponses`: A map that tracks responses for each survey.
- **Methods**:
  - `createSurvey(String title)`: Creates a new survey with the given title.
  - `addQuestionToSurvey(String surveyTitle, Question question)`: Adds a question to a specific survey.
  - `answerSurvey(String surveyTitle, Scanner scanner)`: Allows a user to answer questions in a specific survey.
  - `displaySurveyResults(String surveyTitle)`: Displays the responses for a specific survey.
  - `getSurveys()`: Returns the list of surveys.

### Main

- **Description**: The entry point of the application that interacts with the user.
- **Functionality**:
  - Provides a menu with options to create surveys, answer surveys, display survey results, or exit the program.
  - Handles user input and manages the survey system operations.

## How to Run

1. **Compile**: Use the following command to compile the program:
   ```bash
   javac Main.java
## Example Usage

### Create a Survey

1. Choose option 1 from the menu.
2. Enter the survey title.
3. Add questions to the survey:
   - Enter the question text.
   - Add options for the question.
   - Repeat until all questions are added.
   - Enter 'done' when finished adding questions.

### Answer a Survey

1. Choose option 2 from the menu.
2. Enter the survey title you wish to answer.
3. Provide answers to each question:
   - Read the question and available options.
   - Enter your response.
   - Repeat until all questions are answered.
   - The survey will be completed and your answers saved.

### Display Survey Results

1. Choose option 3 from the menu.
2. Enter the survey title for which you want to see the results.
3. View the collected responses for each question:
   - The results will display questions and corresponding responses.

### Exit

1. Choose option 4 from the menu to exit the program.
