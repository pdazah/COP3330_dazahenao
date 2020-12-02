import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    private TaskItem contactItem;
    TaskList tempList = new TaskList();

    @Test
    public void constructorFailsWithInvalidDueDate(){
        assertThrows(IllegalArgumentException.class,()->new TaskItem("Task1","Work","12/12/2020"));
    }


    @Test
    public void constructorFailsWithInvalidTitle(){
        assertThrows(IllegalArgumentException.class,()->new TaskItem("","Work","12/12/2020"));
    }


    @Test
    public void constructorSucceedsWithValidDueDate(){
        TaskItem item = new TaskItem("Task1","Work","2020/12/23");
        assertEquals("[2020/12/23]"+" "+"Task1:"+" "+"Work",item.toString());
    }


    @Test
    public void constructorSucceedsWithValidTitle(){
        TaskItem item = new TaskItem("Test_title","Work","2020/12/23");
        assertEquals("[2020/12/23]"+" "+"Test_title:"+" "+"Work",item.toString());
    }


    @Test
    public void editingDescriptionSucceedsWithExpectedValue(){
        TaskItem item = new TaskItem("Test_Title", "Play games", "2020/12/24");

        item.update("Test_title","Work","2020/12/24");
        assertEquals("[2020/12/24]" + " "+ "Test_title:" +" "+"Work", item.toString());
    }


    @Test
    public void editingDueDateSucceedsWithExpectedValue(){
        TaskItem item = new TaskItem("Test_Title", "Play games", "2020/12/24");
        item.update("Test_Title","Play games","2021/12/22");
        assertEquals("[2021/12/22]" + " "+ "Test_Title:" +" "+"Play games", item.toString());
    }


    @Test
    public void editingTitleFailsWithEmptyString(){
        TaskItem item = new TaskItem("Test_Title", "Play games", "2020/12/24");
        assertThrows(IllegalArgumentException.class,() ->item.update("","Work","2020/12/24"));
    }


    @Test
    public void editingTitleSucceedsWithExpectedValue(){
        TaskItem item = new TaskItem("Test_Title", "Play games", "2020/12/24");
        item.update("New Title","Work","2020/12/24");
        assertEquals("[2020/12/24]" + " "+ "New Title:" +" "+"Work", item.toString());
    }

}