package HomeWork1.Task2_3;

public class Human extends BaseCreature implements CreatureAction {

    public Human(String name, Sex sex, int age) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void openWardbobe(Wardrobe obj) {
        obj.openDoor();
    }

    public void closeWardbobe(Wardrobe obj) {
        obj.closeDoor();
    }

    public void setItemInWardrobe(Wardrobe obj, Item item, int index) {
        if (obj.setItem(item, index)) {
            System.out.println("Положили предмет " + item.getName() + " на полку " + index + " в " + obj.description);
        } else {
            System.out.println("Не удалось положить предмет " + item.getName() + " на полку " + index + " в " + obj.description);
        }
    }

    public Item getItemInWardrobe(Wardrobe obj, int index) {
        Item tempItem = obj.getItem(index);
        if (tempItem == null) {
            System.out.println("Предметов нет");
        } else {
            System.out.println("Получили предмет " + tempItem.getName());
        }
        return tempItem;
    }

    public void viewInWardrobe(Wardrobe obj) {
        obj.viewItems();
    }

    public void feed_to_cat(BaseCreature cat, Integer meal) {//кормим кошку
        cat.eat(meal);//кошка есть
        System.out.println("Кошка поела");
    }

    public void pet_a_cat(BaseCreature cat) {//ласкаем кошку
        cat.reaction(); //кошка принимает ласки
    }

    public void call_cat(BaseCreature cat) {//позвать кошку
        cat.reply();//кошка должна ответить
    }

    public void speak() {
        speak("Добрый день!");
    }

    public void speak(String voice) {
        System.out.println(voice);
    }

    public void eat(Integer meal) {
        speak("Я поел!");
    }

    public void metabolizm() {
        speak("Я живу!");
    }
    public void reaction() {

    }
    public void reply() {
        speak("Я здесь!");
    }
}