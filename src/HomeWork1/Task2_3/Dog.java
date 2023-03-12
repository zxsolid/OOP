package HomeWork1.Task2_3;

public class Dog extends BaseCreature{
    public void speak() {
        System.out.println("Гав! Гав!");
    }
    public void eat(Integer meal) {
        System.out.println("Собака поела "+meal+" еды!");
    }
    public void reaction() {}
    public void reply() {}
    @Override
    public void metabolizm(){}
}