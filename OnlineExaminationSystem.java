import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
//creating class for users
class User
{
    private String username;
    private String password;
    private String fullName;

    public User(String username, String password, String fullName) //initializing user
    {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getFullName()
    {
        return fullName;
    }
}

//question class for creating ques
class Question
{
    private String questionText;
    private List<String> options; //list to store questions
    private int correctOptionIndex;

    public Question(String questionText, List<String> options, int correctOptionIndex) //initializing question
    {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionText()
    {
        return questionText;
    }

    public List<String> getOptions()
    {
        return options;
    }

    public int getCorrectOptionIndex()
    {
        return correctOptionIndex;
        
    }
    public class OnlineExaminationSystem
{
    private static User currentUser;
    private static List<Question> questions;
    private static List<Integer> selectedAnswers;
    private static Timer timer;
    private static int remainingTimeInSeconds = 1800; // 30 minutes

    public static void main(String[] args)
    {
        initializeQuestions();
        login();
    }

    private static void initializeQuestions() //storing question with options and answers in a list
    {
        questions = new ArrayList<>();
        questions.add(new Question("What is 5^2?", List.of("10", "7", "3", "25"), 3));
        questions.add(new Question("What is the capital of India?", List.of("Chennai", "Bengaluru", "Delhi", "Mumbai"), 2));
        // here we can add more questions
    }


}
    private static void login() //function for user login
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        currentUser = new User(username, password, "Pradhaan S");

        if (currentUser != null)
        {
            showMainMenu(scanner);
        }
        else
        {
            System.out.println("Login failed. Please try again.");
            login();
        }
    }



