package HomeWork1.Task1;

import java.util.ArrayList;

class GeoTree {
    private final ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return tree;
    }

    public void addParent(Person parent, Person children) {
        if (checkPerson(parent, children)) { //нельзя добавлять null
            return;
        }
        tree.add(new Node(parent, Relationship.parent, children)); //  parent родитель для children
        tree.add(new Node(children, Relationship.children, parent)); // children ребенок для parent %(
    }

    public void addPartner(Person partner1,Person partner2){
        if (checkPerson(partner1,partner2))return;
        tree.add(new Node(partner1,Relationship.partner,partner2));
        tree.add(new Node(partner2,Relationship.partner,partner1));

    }

    public boolean replaceChildren(Person person, Person newChildren, Person oldChildren) {
        if (checkPerson(person, newChildren)) return false;
        for (Node t : tree) {
            if (t.getP1().equals(person) &&
                    Relationship.children == t.getRe() &&
                    t.getP2().equals(oldChildren)) {
                t.setP2(newChildren);
                return true;
            }
        }
        return false;
    }

    private boolean checkPerson(Person person1, Person person2) {
        return (person1 == null || person2 == null);
    }
}
