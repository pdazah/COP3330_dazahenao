import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

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


    }


    @Test
    public void editingDescriptionSucceedsWithExpectedValue(){


    }


    @Test
    public void editingDueDateFailsWithInvalidDateFormat(){


    }


    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD(){

    }


    @Test
    public void editingDueDateSucceedsWithExpectedValue(){


    }


    @Test
    public void editingTitleFailsWithEmptyString(){


    }


    @Test
    public void editingTitleSucceedsWithExpectedValue(){


    }

}