package HomeWork1.Task1;

import java.util.Objects;

class Node {
    private Person p1;//персона
    private Relationship re; //родственное отношение
    private Person p2;//родственник

    public Node(Person person, Relationship re, Person relative) {
        if (person == null || relative == null) return;
        this.p1 = person;
        this.re = re;
        this.p2 = relative;
    }

    //геттеры
    public Person getP1() {
        return p1;
    }

    public Person getP2() {
        return p2;
    }

    public Relationship getRe() {
        return re;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s", p1.getFullName(), re, p2.getFullName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return getP1().equals(node.getP1()) &&
                getRe() == node.getRe() &&
                getP2().equals(node.getP2());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getP1(), getRe(), getP2());
    }
}