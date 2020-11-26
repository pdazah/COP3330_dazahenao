import java.time.LocalDate;

public class TaskItem {

    private String title;
    private String description;
    private LocalDate dueDate;
    boolean completed = false;

    public TaskItem(String title, String description, String dueDate){
        if (title.isBlank()){
            throw new IllegalArgumentException("Invalid title");
        }
        LocalDate date;
        try {
            date = LocalDate.parse(dueDate);
        }catch (java.time.DateTimeException e){
            throw new IllegalArgumentException("Invalid due date");
        }
        this.title = title;
        this.description = description;
        this.dueDate = date;
        this.completed = false;
    }


    public boolean isComplete() {
        return completed;
    }


    public void update(String title, String description, String dueDate){
        if(title.isBlank()){
            throw new IllegalArgumentException("Invalid title");
        }
        LocalDate date;
        try {
            date = LocalDate.parse(dueDate);
        }catch (java.time.DateTimeException e){
            throw new IllegalArgumentException("Invalid due date");
        }
        this.title = title;
        this.description = description;
        this.dueDate = date;
        this.completed = false;
    }
}
