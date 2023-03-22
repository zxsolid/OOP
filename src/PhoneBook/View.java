package PhoneBook;

import java.util.List;

public class View {
    public <R> void printAll(List<R> records) {
        if (records == null || records.size() == 0) return;
        int i = 1;
        for (R r : records) {
            System.out.printf("%4d %s\n", i++, r);
        }
    }

    public <R> void printAllwithDescription(List<R> records, String descripton) {
        if (!descripton.isBlank() || !descripton.isEmpty()) System.out.println(descripton);
        printAll(records);
    }
}