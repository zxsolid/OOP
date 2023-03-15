package HomeWork1.Task1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class GeoTree implements Reserch, Loaded, Saved {
    private final HashSet<Node> tree = new HashSet<>();

    public ArrayList<Node> getTree() {
        return new ArrayList<Node>(tree);
    }

    public void addParent(Person parent, Person children) {
        if (checkPerson(parent, children)) return; //нельзя добавлять null
        tree.add(new Node(parent, Relationship.parent, children)); //  parent родитель для children
        tree.add(new Node(children, Relationship.children, parent)); // children ребенок для parent %(

    }

    public void addPartner(Person partner1, Person partner2) {
        if (checkPerson(partner1, partner2)) return; //нельзя добавлять null
        tree.add(new Node(partner1, Relationship.partner, partner2));
        tree.add(new Node(partner2, Relationship.partner, partner1));

    }

    private boolean checkPerson(Person person1, Person person2) {
        return (person1 == null || person2 == null);
    }

    @Override
    public boolean load(String filename) {
        // здесь код для загрузки tree из filename
        return true; //если все загрузилось
    }
    @Override
    public boolean SaveToFile(String filename) {
        // здесь код для tree в filename
        return true; //если все записалось
    }
    @Override
    public ArrayList<Person> getParents(Person person) {
        return spend(person, Relationship.children);
    }
    @Override
    public ArrayList<Person> getChildren(Person person) {
        return spend(person, Relationship.parent);
    }
    @Override
    public ArrayList<Person> getBrotherSister(Person person) {
        if (person == null) return null;
        ArrayList<Node> parents = new ArrayList<>();
        for (Node parent : this.tree) {//собираем список родителей
            if (parent.getRe() == Relationship.parent &&
                    parent.getP2().equals(person)) {
                parents.add(parent);// в parents получили список родителей
                if (parents.size() > 1) break;
            }
        }

        Set<Person> brother_sister = new HashSet<>();
        for (Node parent : parents) {
            brother_sister.addAll(getChildren(parent.getP1()));
        }
        brother_sister.remove(person);
        return new ArrayList<Person>(new HashSet<Person>(brother_sister));
    }

    @Override
    public ArrayList<Person> getPartners(Person person) {
        return null;
    }

    @Override
    public ArrayList<Person> getGrandParents(Person person) {
        if (person == null) return null;
        ArrayList<Person> result = new ArrayList<>();
        for (Person parent : getParents(person)) {
            result.addAll(getParents(parent));
        }
        return result;
    }

    @Override
    public ArrayList<Person> spend(Person person, Relationship rel) {
        ArrayList<Person> result = new ArrayList<>();
        for (Node t : tree) {
            if (t.getP1().equals(person) &&
                    t.getRe() == rel) {
                result.add(t.getP2());
            }
        }
        return result;
    }
    @Override
    public ArrayList<Person> getAllAncestors(Person person) {
        if (getParents(person).size() == 0) return new ArrayList<Person>();
        ArrayList<Person> result = new ArrayList<>();
        ArrayList<Person> parents = getParents(person);
        while (parents.size() > 0) {
            result.addAll(parents);
            ArrayList<Person> nextParents = new ArrayList<>();
            for (Person p : parents) {
                if (getParents(p).size() > 0) {
                    nextParents.addAll(getParents(p));
                }
            }
            parents = nextParents;
        }
        return result;
    }
    @Override
    public boolean isRelative(Person person1, Person person2) {
        ArrayList<Person> relatyveP1 = getAllAncestors(person1);
        ArrayList<Person> relatyveP2 = getAllAncestors(person2);
        relatyveP1.add(person1);
        relatyveP2.add(person2);
        relatyveP1.retainAll(relatyveP2);
        return (relatyveP1.size() > 0);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Node i : this.tree) {
            result.append(i.toString()).append("\n");
        }
        return result.toString();
    }
    private ArrayList<Node> getAllPersonNodes(Person person) {
        ArrayList<Node> result = new ArrayList<>();
        for (Node t : this.tree) {
            if (t.getP1().equals(person) ||
                    t.getP2().equals(person)) {
                result.add(t);
            }
        }
        return result;
    }
}