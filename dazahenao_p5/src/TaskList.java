import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskList {
    private static Scanner input = new Scanner(System.in);
    List<TaskItem> taskItems;

    public TaskList(){
        this.taskItems = new ArrayList<TaskItem>();
    }

    public void add(TaskItem item) {
        taskItems.add(item);
    }

    public void remove(int index){
        taskItems.remove(index);
    }

    public TaskItem getItem(int index){
        return taskItems.get(index);
    }

    public int getSize(){
        return taskItems.size();
    }

    public void complete(int index, boolean completed){
        taskItems.get(index).isComplete();
    }

    public String printList() {
        StringBuilder stringBuilder = new StringBuilder();
        TaskItem taskItem;
        for(int i=0;i<getSize();i++) {
            taskItem = getItem(i);
            if (taskItem.isComplete()) {
                stringBuilder.append(String.format("%d) *** %s%n", i, taskItem));
            } else {
                stringBuilder.append(String.format("%d) %s%n", i, taskItem));
            }
        }
        return stringBuilder.toString();
    }


    public String showCompletedTasks(){
        StringBuilder stringBuilder = new StringBuilder();
        TaskItem taskItem;
        for(int i=0;i<getSize();i++) {
            taskItem = getItem(i);
            if (taskItem.isComplete()) {
                stringBuilder.append(String.format("%d) *** %s%n", i, taskItem));
            }
        }
        return stringBuilder.toString();
    }


    public String showUncompletedTask(){
        StringBuilder stringBuilder = new StringBuilder();
        TaskItem taskItem;
        for(int i=0;i<getSize();i++) {
            taskItem = getItem(i);
            if (!taskItem.isComplete()) {
                stringBuilder.append(String.format("%d) %s%n", i, taskItem));
            }
        }
        return stringBuilder.toString();
    }


    public void update(int index, String title, String description, String dueDate) {
        this.getItem(index).update(title, description, dueDate);
    }
}
