import java.text.ParseException;
import java.text.SimpleDateFormat;


public class TaskItem {

    private String title;
    private String description;
    private String dueDate;
    private boolean completed;

    public TaskItem(String title, String description, String dueDate){
        String date = null;
        if (title.isBlank()){
            throw new IllegalArgumentException("Invalid title");
        }
        if(isValidDate(dueDate)){
            date = dueDate;
        }   else {
            System.out.println("Invalid date, please enter data again");
        }
        this.title = title;
        this.description = description;
        this.dueDate = date;
        this.completed = false;
    }

    public void complete(boolean completed) {
        this.completed = completed;
    }

    public boolean isComplete() {
        return completed;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }


    public void update(String title, String description, String dueDate){
        String date = null;
        if (title.isBlank()){
            throw new IllegalArgumentException("Invalid title");
        }
        if(isValidDate(dueDate)){
            date = dueDate;
        }   else {
            System.out.println("Invalid date, please enter data again");
        }
        this.title = title;
        this.description = description;
        this.dueDate = date;
        this.completed = false;
    }


    @Override
    public String toString() {
        return String.format("[%s] %s: %s", dueDate, title, description);
    }
}




