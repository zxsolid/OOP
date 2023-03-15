package HomeWork1.Task2_3;
/**
 * Базовые действия живых существ
 */
public interface CreatureAction {
    void speak();
    void eat(Integer meal);
    void reaction();
    void reply();
    void call(BaseCreature obg);
}