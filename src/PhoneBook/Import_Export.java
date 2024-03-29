package PhoneBook;


import java.nio.file.Paths;

public abstract class Import_Export {
    Phone_Book_Storage pb;
    String filename;
    Import_Export_Data data;
    View view;

    public Import_Export(Phone_Book_Storage pb, String filename, View view) {
        this.pb = pb;
        this.filename = filename;
        data = new Import_Export_Data(pb.poolRecord);
        this.view = view;
    }

    public boolean validateFilename(String fileName) {
        try {
            Paths.get(fileName);
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
