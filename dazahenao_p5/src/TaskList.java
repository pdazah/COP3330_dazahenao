import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;


public class TaskList {
    List<TaskItem> taskItems;


    public TaskList(){
        this.taskItems = new ArrayList<>();
    }

    public void add(TaskItem item){
        taskItems.add(item);
    }

    public void remove(int index) {
        taskItems.remove(index);
    }

    public TaskItem getItem(int index) {
        return taskItems.get(index);
    }


    public int getSize() {
        return taskItems.size();
    }


    public void taskComplete (int index, boolean completed){
        this.getItem(index).complete(completed);
    }


    public void update(int index, String title, String description, String dueDate) {
        this.getItem(index).update(title, description, dueDate);
    }


    public String printList() {
        StringBuilder stringBuilder = new StringBuilder();
        TaskItem temp;
        for(int i=0;i<getSize();i++) {
            temp = this.getItem(i);
            if (temp.isComplete()) {
                stringBuilder.append(String.format("%d) *** %s%n", i, temp));
            } else {
                stringBuilder.append(String.format("%d) %s%n", i, temp));
            }
        }
        return stringBuilder.toString();
    }


    public void load(String fileName) {
        List<TaskItem> tempList = taskItems;
        taskItems = new ArrayList<>();
        try (Scanner input = new Scanner(Paths.get(fileName))) {
            String defaultName = input.nextLine();
            if (defaultName.equalsIgnoreCase("tasks")) {
                while (input.hasNext()) {
                    String title = input.nextLine();
                    String description = input.nextLine();
                    String dueDate = input.nextLine();
                    String completedStatusString = input.nextLine();
                    TaskItem item = new TaskItem(title, description, dueDate);
                    item.complete(completedStatusString.equalsIgnoreCase("complete"));
                    this.add(item);
                }
            }else {
                taskItems = tempList;
                throw new InputMismatchException("filename is not a TaskList, loading failed.");
            }
        } catch (FileNotFoundException ex) {
            taskItems = tempList;
            throw new IllegalArgumentException("file not found, loading failed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void save(String fileName){
        try (Formatter output = new Formatter(fileName)) {
            output.format("tasks%n");
            for (TaskItem taskItem : taskItems) {
                output.format("%s%n",taskItem.getDueDate());
                output.format("%s%n", taskItem.getTitle());
                output.format("%s%n", taskItem.getDescription());
                if (taskItem.isComplete()) {
                    output.format("complete%n");
                } else {
                    output.format("incomplete%n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String viewCompletedTasks() {
        StringBuilder stringBuilder = new StringBuilder();
        TaskItem taskItems;
        for (int i = 0; i < this.getSize(); i++) {
            taskItems = this.getItem(i);
            if (taskItems.isComplete()) {
                stringBuilder.append(String.format("%d) %s%n", i, taskItems));
            }
        }
        return stringBuilder.toString();
    }


    public String viewUncompletedTasks() {
        StringBuilder sb = new StringBuilder();
        TaskItem taskItems;
        for (int i = 0; i < this.getSize(); i++) {
            taskItems = this.getItem(i);
            if (!taskItems.isComplete()) {
                sb.append(String.format("%d) %s%n", i, taskItems));
            }
        }
        return sb.toString();
    }
}