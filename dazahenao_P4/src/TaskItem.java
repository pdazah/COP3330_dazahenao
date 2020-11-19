import javax.naming.InvalidNameException;
import java.util.ArrayList;
import java.util.List;


public class TaskItem {
    private String itemTitle;
    private String itemDescription;
    private String itemDueDate;
    private boolean itemCompleted;


    public TaskItem(String itemTitle,String itemDescription,String itemDueDate, boolean completed) {
        this.itemCompleted = completed;
        if (isTitleValid(itemTitle)) {
            this.itemTitle = itemTitle;
        } else {
            throw new InvalidTitleException("title is not valid; must be at least 1 character long");
        }

        if (isDescriptionValid(itemDescription)) {
            this.itemDescription = itemDescription;
        } else {
            throw new InvalidDescriptionException("description is not valid; must be at least 1 character long");
        }

        if (isDuedateValid(itemDueDate)) {
            this.itemDueDate = itemDueDate;
        } else {
            throw new InvalidDuedateException("due date is not valid; must be at least 1 character long");
        }
    }

    @Override
    public String toString() {
       return itemTitle + " " + itemDescription + " "+ itemDueDate;
    }

    protected boolean isTitleValid(String itemTitle) {
        return itemTitle.length() > 0;
    }

    protected boolean isDescriptionValid(String itemDescription) {
        return itemDescription.length() > 0;
    }

    protected boolean isDuedateValid(String itemDueDate) {
        return itemDueDate.length() > 0;
    }

    public String getItemTitle() {
        return this.itemTitle;
    }

    public String getItemDescription() {
        return this.itemDescription;
    }

    public String getItemDueDate() {
        return this.itemDueDate;
    }

    protected void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    protected void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    protected void setItemDueDate(String itemDueDate) {
        this.itemDueDate = itemDueDate;
    }

    protected void setItemCompleted(boolean itemCompleted) {
        this.itemCompleted = itemCompleted;
    }

    class InvalidTitleException extends IllegalArgumentException {
        public InvalidTitleException(String msg) {
            super(msg);
        }
    }

    class InvalidDescriptionException extends IllegalArgumentException {
        public InvalidDescriptionException(String msg) {
            super(msg);
        }
    }

    class InvalidDuedateException extends IllegalArgumentException {
        public InvalidDuedateException(String msg) {
            super(msg);
        }
    }
}


