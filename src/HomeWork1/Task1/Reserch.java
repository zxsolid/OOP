package HomeWork1.Task1;

import java.util.ArrayList;
import java.util.PropertyPermission;

public interface Reserch {
    ArrayList<Person> getParents(Person person);

    ArrayList<Person> getChildren(Person person);

    ArrayList<Person> getBrotherSister(Person person);

    ArrayList<Person> getPartners(Person person);

    ArrayList<Person> getGrandParents(Person person);

    ArrayList<Person> spend(Person person, Relationship rel);

    ArrayList<Person> getAllAncestors(Person person);

    boolean isRelative(Person person1, Person person2);
}