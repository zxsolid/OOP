package HomeWork1.Task2_3;
//Базовый класс живых существ
public abstract class BaseCreature implements CreatureAction {

    String name;
    int age;
    Sex sex;
    int safety;
    int mood;
    Stage stage;

    String getName(){
        return name;
    }
    void metabolizm() {
    }
}
