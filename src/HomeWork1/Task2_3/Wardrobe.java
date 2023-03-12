package HomeWork1.Task2_3;

public class Wardrobe extends BaseItem {
    private Item[] storage; //хранилище вещей
    private boolean isOpenDoors;//состояние двери

    public Wardrobe(String name, int storageMaxDimm) {

        this.storage = new Item[storageMaxDimm];
        this.isOpenDoors = false;
        this.description = name;
        System.out.println("У нас новый \""+name+"\""+" на "+storageMaxDimm+" мест");
    }

    public void openDoor() {
        isOpenDoors = true;
        System.out.printf("Двери %s открыли\n",description );
    }

    public void closeDoor() {
        isOpenDoors = false;
        System.out.printf("Двери %s закрыли\n",description );
    }

    public Item getItem(int index) {
        index -= 1;
        if (!isOpenDoors) return null;
        if (index >= storage.length) return null;
        Item obj = storage[index];
        storage[index] = null;
        return obj;
    }

    public boolean setItem(Item obj, int index) {
        if (!isOpenDoors) return false;
        index -= 1;
        if (0 > index || this.storage.length <= index) return false;
        if (storage[index] != null) {
            System.out.println("полка занята");
            return false;
        } else {
            storage[index] = obj;
            return true;
        }
    }

    public void viewItems() {
        if (isOpenDoors) {
            System.out.println("в шкафу " + this.storage.length + " мест");
            StringBuilder forPrint = new StringBuilder();
            int count = 0;
            for (int i = 0; i < this.storage.length; i++) {
                if (this.storage[i] != null) {
                    count++;
                    forPrint.append (String.format("%5d  %s\n", i + 1,this.storage[i].getName()));
                }else {
                    forPrint.append(String.format("%5d  %s\n", i + 1," --- "));
                }
            }
            System.out.println("занято " + count + " мест(а|о)");
            System.out.println(forPrint);
        } else {
            System.out.println("шкаф закрыт");
        }
    }
}