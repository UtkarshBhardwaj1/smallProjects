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

    private static void showMainMenu(Scanner scanner) //function for main menu with multiple options
    {
        System.out.println("Welcome, " + currentUser.getFullName() + "!");
        System.out.println("1. Start Exam");
        System.out.println("2. Update Profile");
        System.out.println("3. Change Password");
        System.out.println("4. Logout");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice)
        {
            case 1:
                startExam(scanner);
                break;
            case 2:
                updateProfile(scanner);
                break;
            case 3:
                changePassword(scanner);
                break;
            case 4:
                logout(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                showMainMenu(scanner);
                break;
        }
    }

    private static void startExam(Scanner scanner) //function to start exam
    {
        selectedAnswers = new ArrayList<>();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                remainingTimeInSeconds--;
                if (remainingTimeInSeconds <= 0) //if timer is completed exam gets auto submitted
                {
                    autoSubmit();
                }
            }
        }, 1000, 1000);

        System.out.println("You have 30 minutes to complete the exam."); //timer is set for 30 minutes
        for (int i = 0; i < questions.size(); i++) //exam operation
        {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.getQuestionText());
            List<String> options = question.getOptions();
            for (int j = 0; j < options.size(); j++)
            {
                System.out.println((j + 1) + ". " + options.get(j));
            }
            System.out.print("Select an answer (1-" + options.size() + "): ");
            int answer = scanner.nextInt();
            selectedAnswers.add(answer - 1);
        }
        autoSubmit();
    }




