package arpit.alistegnoproject.recyclerView;

public class Faculty {

    String name;
    String subject;
    String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Faculty(String name, String subject, String address) {
        this.name = name;
        this.subject = subject;
        this.address = address;
    }
}
