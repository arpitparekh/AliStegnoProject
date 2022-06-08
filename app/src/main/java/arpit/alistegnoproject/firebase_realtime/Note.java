package arpit.alistegnoproject.firebase_realtime;

public class Note {

    String title;
    String description;

    Note(){

    }

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "title= " + title +
                "\ndescription='" + description;

    }
}
