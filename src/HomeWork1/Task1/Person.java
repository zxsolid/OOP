package HomeWork1.Task1;

import java.util.Objects;

public class Person {
    private final String fullName;
    private final Sex sex;
    private final String birthday;

    public Sex getSex() {
        return sex;
    }

    public String getBirthday() {
        return birthday;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return (this.fullName.equals(((Person) o).getFullName())&&
                this.sex==((Person) o).getSex()) &&
                this.birthday.equals(((Person) o).getBirthday());
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(fullName).append(" ");
        switch (sex){
            case woman -> result.append("(ж.)");
            case man -> result.append("(м.)");
        }
        result.append(String.format("[%s]",birthday));
        return result.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, sex, birthday);
    }
}