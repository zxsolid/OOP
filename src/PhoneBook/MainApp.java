package PhoneBook;

public class MainApp {
    public static void main(String[] args) {
        View vw = new View();
        Phone_Book_Storage st = new Phone_Book_Storage();
        startLoad(st);
        new Controller(st, vw).run();
    }

    private static void startLoad(Phone_Book_Storage st) {
        st.addRecord(new Record("Админ 1", "101"));
        st.addRecord(new Record("Админ 1", "101"));//проверка на исключение дублей
        st.addRecord(new Record("Модератор", "200","+79008001222","12-231"));
        st.addRecord(new Record("Менеджер по связям с клиентами", "210"));
        st.addRecord(new Record("Директор", "111"));
    }
}