package PhoneBook;

import java.util.List;

public class ConsoleView implements View{
    @Override
    public <R> void printAll(List<R> records) {
        if (records == null || records.size() == 0) return;
        int i = 1;
        for (R r : records) {
            System.out.printf("%4d %s\n", i++, r);
        }
    }

    @Override
    public <R> void printAllwithDescription(List<R> records, String description) {
        if (!description.isBlank() || !description.isEmpty()) System.out.println(description);
        printAll(records);
    }

    @Override
    public void print() {
        System.out.println();
    }

    @Override
    public <T> void print(T text) {
        System.out.print(text);
    }

    @Override
    public <T> void println(T text) {
        System.out.println(text);
    }
}