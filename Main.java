import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Survey { // parent class
    private String title;
    private List<Question> questions;

    public Survey(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public String getTitle() {
        return title;
    }
}

class Question { // child class
    private String text;
    private List<String> options;

    public Question(String text) {
        this.text = text;
        this.options = new ArrayList<>();
    }

    public void addOption(String option) {
        options.add(option);
    }

    public List<String> getOptions() {
        return options;
    }

    public String getText() {
        return text;
    }
}

class SurveySystem {
    private List<Survey> listOfSurveys;
    private Map<Survey, Map<String, List<String>>> surveyResponses;

    public SurveySystem() {
        this.listOfSurveys = new ArrayList<>();
        this.surveyResponses = new HashMap<>();
    }

    public void createSurvey(String title) {
        Survey survey = new Survey(title);
        listOfSurveys.add(survey);
        surveyResponses.put(survey, new HashMap<>());
    }

    public void addQuestionToSurvey(String surveyTitle, Question question) {
        for (Survey survey : listOfSurveys) {
            if (survey.getTitle().equals(surveyTitle)) {
                survey.addQuestion(question);
                surveyResponses.get(survey).put(question.getText(), new ArrayList<>());
                break;
            }
        }
    }

    public void answerSurvey(String surveyTitle, Scanner scanner) {
        for (Survey survey : listOfSurveys) {
            if (survey.getTitle().equals(surveyTitle)) {
                Map<String, List<String>> responses = surveyResponses.get(survey);

                for (Question question : survey.getQuestions()) {
                    System.out.println("Question: " + question.getText());
                    for (String option : question.getOptions()) {
                        System.out.println("- " + option);
                    }

                    System.out.print("Your answer: ");
                    String answer = scanner.nextLine();
                    responses.get(question.getText()).add(answer);
                }
                System.out.println("Survey completed. Thank you!");
                break;
            }
        }
    }

    public void displaySurveyResults(String surveyTitle) {
        for (Survey survey : listOfSurveys) {
            if (survey.getTitle().equals(surveyTitle)) {
                Map<String, List<String>> responses = surveyResponses.get(survey);

                System.out.println("Survey Title: " + survey.getTitle());
                for (Question question : survey.getQuestions()) {
                    System.out.println("Question: " + question.getText());
                    List<String> answers = responses.get(question.getText());

                    if (answers.isEmpty()) {
                        System.out.println("No responses yet.");
                    } else {
                        System.out.println("Responses:");
                        for (String answer : answers) {
                            System.out.println("- " + answer);
                        }
                    }
                }
                break;
            }
        }
    }

    public List<Survey> getSurveys() {
        return listOfSurveys;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            SurveySystem surveySystem = new SurveySystem();
            System.out.println("\n\n---ONLINE SURVEY SYSTEM---");
            System.out.println("Choose an option to proceed");
            int choice;
            while (true) {
                System.out.println("\n_Options_");
                System.out.println("1. Create a survey");
                System.out.println("2. Answer a survey");
                System.out.println("3. Display survey responses");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter the survey title: ");
                        String surveyTitle = scanner.nextLine();
                        surveySystem.createSurvey(surveyTitle);
                        while (true) {
                            System.out.print("\nEnter the question text (enter 'done' to finish): ");
                            String questionText = scanner.nextLine();
                            if (questionText.equalsIgnoreCase("done")) {
                                break;
                            }
                            Question question = new Question(questionText);
                            System.out.println("Enter options for the question (enter 'done' to finish):");
                            while (true) {
                                System.out.print("Option: ");
                                String option = scanner.nextLine();
                                if (option.equalsIgnoreCase("done")) {
                                    break;
                                }
                                question.addOption(option);
                            }
                            surveySystem.addQuestionToSurvey(surveyTitle, question);
                        }
                        break;
                    case 2:
                        System.out.print("\nEnter the survey title to answer: ");
                        surveyTitle = scanner.nextLine();
                        surveySystem.answerSurvey(surveyTitle, scanner);
                        break;
                    case 3:
                        System.out.print("\nEnter the survey title to display results: ");
                        surveyTitle = scanner.nextLine();
                        surveySystem.displaySurveyResults(surveyTitle);
                        break;
                    case 4:
                        System.out.println("\nExiting the program...");
                        return;
                    default:
                        System.out.println("\nInvalid choice. Please enter a valid option.");
                }
            }
        } finally {
            scanner.close();
        }
    }
}
