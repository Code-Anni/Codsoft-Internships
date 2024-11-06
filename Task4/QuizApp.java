import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp{
    static String[] questions = {
        "Which one of the following is not a Java feature?", "Which component is used to compile, debug and execute the java programs?", "What is the extension of java code files?"
    };
    static String[][] options = {
        {"1. Object-oriented", "2. Use of pointers", "3. Portable", "4.Dynamic and Extensible "},
        {"1. JRE", "2. JIT", "3. JDK", "4.JVM"},
        {"1. .js", "2. .txt", "3. .class", "4. .java"}
    };
    static int[] correctAnswers = {2, 3, 4};
    static int score = 0;
    static int currentQuestion = 0;
    static boolean answerSubmitted = false;
    static Timer timer = new Timer();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (currentQuestion < questions.length) {
            displayQuestion();
            startTimer();

            int userAnswer = scanner.nextInt();
            answerSubmitted = true;

            if (userAnswer == correctAnswers[currentQuestion]) score++;

            currentQuestion++;
        }

        displayResults();
        scanner.close();
    }

    static void displayQuestion() {
        System.out.println("Q" + (currentQuestion + 1) + ": " + questions[currentQuestion]);
        for (String option : options[currentQuestion]) {
            System.out.println(option);
        }
        System.out.print("Answer (1-4): ");
    }

    static void startTimer() {
        timer.schedule(new TimerTask() {
            public void run() {
                if (!answerSubmitted) {
                    System.out.println("\nTime's up!");
                    currentQuestion++;
                    if (currentQuestion < questions.length) displayQuestion();
                }
                answerSubmitted = false;
            }
        }, 10000);
    }

    static void displayResults() {
        System.out.println("\nQuiz Over!");
        System.out.println("Score: " + score + "/" + questions.length);
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i] + " - " + options[i][correctAnswers[i] - 1]);
        }
    }
}
