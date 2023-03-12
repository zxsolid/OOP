package HomeWork1.Task1;

import java.util.Calendar;

public class Person {
    private String fullName;
    private Sex sex;
    private String birthday;

    public Person(String fullName) {
        this(fullName, Sex.none, "-");
    }

    public Person(String fullName, String birthday) {
        this(fullName, Sex.none, birthday);

    }

    public Person(String fullName, Sex sex, String birthday) {
        this.fullName = fullName;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getFullName() {
        return fullName;
    }
}