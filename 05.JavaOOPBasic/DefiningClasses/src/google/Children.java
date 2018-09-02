package google;

public class Children {
    private String name;
    private String birthday;

    public Children(String name,String birthday) {
        this.name = name;
        this.birthday=birthday;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getName(), this.getBirthday());
    }
}
