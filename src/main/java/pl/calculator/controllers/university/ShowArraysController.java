package pl.calculator.controllers.university;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShowArraysController {

    @FXML
    private TextField leftFirst;

    @FXML
    private TextField leftSecond;

    @FXML
    private TextField leftThird;



    @FXML
    private TextField rightFirst;

    @FXML
    private TextField rightSecond;

    @FXML
    private TextField rightThird;

    @FXML
    private TextField shallowTextField;

    @FXML
    private TextField deepTextField;

    @FXML
    private CheckBox isDeep;



    @FXML
    void checkDeep(ActionEvent event) {
        Integer [] arrayLeft = {Integer.parseInt(leftFirst.getText()),Integer.parseInt(leftSecond.getText()),Integer.parseInt(leftThird.getText())};
        Integer [] arrayRight = {Integer.parseInt(rightFirst.getText()),Integer.parseInt(rightSecond.getText()),Integer.parseInt(rightThird.getText())};

        shallowTextField.setText(String.valueOf(Arrays.equals(arrayLeft,arrayRight)));

        Object[] objectArrayLeft = {arrayLeft};
        Object[] objectArrayRight = {arrayRight};

        if(isDeep.isSelected())
            deepTextField.setText(String.valueOf(Arrays.deepEquals(objectArrayLeft, objectArrayRight)));
        else
            deepTextField.setText(String.valueOf(Arrays.equals(objectArrayLeft,objectArrayRight)));


        List<Integer> show = new ArrayList<>(Arrays.asList(arrayLeft));
        System.out.println("Zamiana tablicy na listy i dodanie el 101");
        show.add(101);
        show.forEach(e-> System.out.println(e.toString()));
        System.out.println("Sortowanie tablicy na lewo (płytko)");
        Arrays.sort(arrayLeft);
        System.out.println(Arrays.toString(arrayLeft));


    }


}
