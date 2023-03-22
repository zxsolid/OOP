package PhoneBook;

import java.io.Serializable;
import java.util.HashSet;

public class Import_Export_Data implements Serializable {
    HashSet<Record> data;

    public HashSet<Record> getData() {
        return data;
    }

    public void setData(HashSet<Record> data) {
        this.data = data;
    }

    public Import_Export_Data(HashSet<Record> data) {
        setData(data);
    }
}
