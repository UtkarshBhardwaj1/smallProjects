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
}

