package ToDoPlanner;

public class MainApp {
    public static void main(String[] args) {

        Scheduler sc = new Scheduler();
        Controller controller = new Controller(sc);
        controller.run();
        System.out.println("Работа завершена");
    }
}