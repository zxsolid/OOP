package PhoneBook;

import java.util.ArrayList;
import java.util.HashSet;

public class Phone_Book_Storage {
    HashSet<Record> poolRecord;

    public Phone_Book_Storage () {
        clear();
    }

    public ArrayList<Record> getAll() {
        return new ArrayList<>(poolRecord);
    }

    public void addRecord(Record record) {
        poolRecord.add(record);
    }

    public void clear() {
        poolRecord = new HashSet<>();
    }

    public void delRecord(Record r) {
        poolRecord.remove(r);
    }

    public void replaceRecord(Record oldRecord, Record newRecord) {
        delRecord(oldRecord);
        addRecord(newRecord);
    }

    public int size() {
        if (poolRecord == null) {
            return 0;
        }
        return poolRecord.size();
    }

    public void setPoolRecords(HashSet<Record> data) {
        poolRecord = data;
    }
}