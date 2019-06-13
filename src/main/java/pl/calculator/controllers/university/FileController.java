package pl.calculator.controllers.university;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileController {

    private Path path = Paths.get("zapisOdczyt.txt");


    @FXML
    private TextArea textArea;

    @FXML
    void readToConsole(ActionEvent event) throws IOException {

        byte[] bytes = Files.readAllBytes(path);
        String fileContent = new String(bytes, Charset.forName("UTF-8"));
        System.out.println("Zwartość pliku:\n"+ fileContent);
    }

    @FXML
    void readByBufferedRead(ActionEvent event) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("zapisOdczyt.txt"))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void saveByFileWrite() {

        try(FileWriter fileWriter = new FileWriter("zapisOdczyt.txt"))
        {
            fileWriter.write(textArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void readByFileRead()
    {
        try (FileReader fileReader = new FileReader("zapisOdczyt.txt")) {
            StringBuilder stringBuilder = new StringBuilder();
            int character = fileReader.read();

            while (character != -1) {
                stringBuilder.append((char)character);
                character = fileReader.read();
            }
            System.out.println(stringBuilder.toString());
        } catch (IOException e) {
                    e.printStackTrace();
                }
    }

    @FXML
    void saveToFile(ActionEvent event) throws IOException {

        String toSave = textArea.getText();
        Files.write(path,toSave.getBytes(Charset.forName("UTF-8")));


    }

    @FXML
    void readByScanner()
    {
        try{
            FileReader fileReader = new FileReader("zapisodczyt.txt");
            Scanner in = new Scanner(fileReader);


            StringBuilder stringBuilder = new StringBuilder();
            while (in.hasNext()) {
                stringBuilder.append(in.nextLine());
            }

            in.close();
            fileReader.close();
            System.out.print(stringBuilder.toString());

        }
        catch (IOException io) {
            io.printStackTrace();
        }

    }


    @FXML
    void readByByteArrayOutputStream()
    {
        try(ByteArrayOutputStream bout = new ByteArrayOutputStream())
        {

            for (int i=0;i<10;i++) {
                bout.write((byte) (Math.random() * 100));
            }

            byte[] byteArray = bout.toByteArray();
            System.out.println("\nTablica wyjdzie przy kolejnym wywolaniu");
            for (byte b : byteArray)
                System.out.print(b+" ");

            bout.reset();
            bout.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
