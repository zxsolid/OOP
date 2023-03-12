package HomeWork1.Task1;

import java.util.ArrayList;
import java.util.HashSet;

class GeoTree implements Reserch, Loaded<HashSet<Node>>, Saved<HashSet<Node>> {
    private final HashSet<Node> tree = new HashSet<>();

    public void addParent(Person parent, Person children) {
        if (checkPerson(parent, children)) { //нельзя добавлять null
            return;
        }
        tree.add(new Node(parent, Relationship.parent, children)); //  parent родитель для children
        tree.add(new Node(children, Relationship.children, parent)); // children ребенок для parent %(

    }

    public void addPartner(Person partner1, Person partner2) {
        if (checkPerson(partner1, partner2)) return;
        tree.add(new Node(partner1, Relationship.partner, partner2));
        tree.add(new Node(partner2, Relationship.partner, partner1));

    }

    private boolean checkPerson(Person person1, Person person2) {
        return (person1 == null || person2 == null);
    }

    public HashSet<Node> load() {
        // здесь код для загрузки данных
        return null;
    }

    public void Save(HashSet<Node> nodes) {
        // здесь код для записи данных
    }

    public ArrayList<String> getParents(Person person) {
        return spend(person, Relationship.children);
    }

    public ArrayList<String> getChildren(Person person) {
        return spend(person, Relationship.parent);
    }

    public ArrayList<String> getBrotherSister(Person person) {
        ArrayList<Node> parents = new ArrayList<>();
        for (Node parent : this.tree) {//собираем список родителей
            if (parent.getRe() == Relationship.parent && parent.getP2().equals(person)) {
                parents.add(parent);// в parents получили список родителей
                if (parents.size() > 1) break;
            }
        }
        HashSet<Person> brother_sister = new HashSet<>();
        for (Node parent : parents) {
            // находим всех братьев и сестер
            for (Node t : this.tree) {
                if (parent.getP1().equals(t.getP1()) &&
                        t.getRe() == Relationship.parent && //если отношение -> родитель
                        !t.getP2().equals(person)) {//кроме самого person
                    brother_sister.add(t.getP2());
                }
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for (Person p : brother_sister) {
            result.add(p.getFullName());
        }
        return result;
    }

    public ArrayList<String> getPartners(Person person) {
        return spend(person, Relationship.partner);
    }

    public ArrayList<String> spend(Person person, Relationship rel) {
        ArrayList<String> result = new ArrayList<>();
        for (Node t : tree) {
            if (t.getP1().getFullName().equals(person.getFullName()) && t.getRe() == rel) {
                result.add(t.getP2().getFullName());
            }
        }
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Node i : this.tree) {
            result.append(i.toString()+"\n");
        }
        return result.toString();
    }
}