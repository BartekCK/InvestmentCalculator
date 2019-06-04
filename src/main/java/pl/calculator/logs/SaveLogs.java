package pl.calculator.logs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveLogs {

    private static List<ThisIsLogInformation> listLog;

    public static void saveToFile(ThisIsLogInformation log)
    {
        readFromFile();
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("logs.bin"))) {
            if (listLog == null)
                listLog = new ArrayList<>();
            listLog.add(log);
            outputStream.writeObject(listLog);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromFile()
    {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("logs.bin")))
        {
            listLog = new ArrayList<>((ArrayList<ThisIsLogInformation>)objectInputStream.readObject());
        } catch (FileNotFoundException e) {
            e.getMessage();
            System.out.println("Tworzenie nowego pliku");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<ThisIsLogInformation> getListLog() {
        readFromFile();
        return listLog;
    }
}
