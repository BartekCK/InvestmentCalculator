package pl.calculator.controllers.university;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.calculator.university.struct.*;

import java.net.URL;
import java.util.*;

public class StructController implements Initializable {

    @FXML
    private ComboBox<God> comboBox1;



    @FXML
    private TextField keyLeft;

    @FXML
    private TextField valueLeft;

    @FXML
    private TextField hashLeft;


    @FXML
    private TableView<God> leftTableView;

    @FXML
    private TableColumn<God, Number> keyLeftTableColumn;

    @FXML
    private TableColumn<God, Number>  valueLeftTableColumn;

    @FXML
    private TableColumn<God, String> classLeftTableColumn;





    @FXML
    private TextField keyRight;

    @FXML
    private TextField valueRight;

    @FXML
    private TextField hashRight;

    @FXML
    private TableView<Map.Entry<ForMap,Double>> rightTableView;

    @FXML
    private TableColumn<Map.Entry<ForMap,Double>, Number> keyRightTableColumn;

    @FXML
    private TableColumn<Map.Entry<ForMap,Double>, Number> valueRightTableColumn;

    @FXML
    private TableColumn<Map.Entry<ForMap,Double>, String> classRightTableColumn;

    ForMap forMap;


    private List casualList;

    private Set<God> hashSet;


    private Map<ForMap, Double> hashMap;

    public StructController() {
        casualList = new LinkedList();
        hashSet = new HashSet<>();
        hashMap = new HashMap<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox1.setItems(FXCollections.observableArrayList(new First(),new Second(),new Third()));



    }



    @FXML
    void addToHashMap(ActionEvent event) {
         forMap = new ForMap(Integer.parseInt(keyRight.getText()),Double.parseDouble(valueRight.getText()));
         forMap.setHash(Integer.valueOf(hashRight.getText()));
         hashMap.put(forMap,Double.parseDouble(valueRight.getText()));

        setRightView(FXCollections.observableArrayList(hashMap.entrySet()));
    }

    @FXML
    void addToHashSet(ActionEvent event) {
        God god = (God) comboBox1.getSelectionModel().getSelectedItem().clone();
        god.setHash(Integer.valueOf(hashLeft.getText()));
        god.setKey(Integer.valueOf(keyLeft.getText()));
        god.setValue(Double.valueOf(valueLeft.getText()));

        hashSet.add(god);
        setLeftView(new ArrayList<>(hashSet));

    }

    @FXML
    void addToTreeMap(ActionEvent event) {

    }

    @FXML
    void showCasualList(ActionEvent event) {
        God god = (God) comboBox1.getSelectionModel().getSelectedItem().clone();
        god.setKey(Integer.valueOf(keyLeft.getText()));
        god.setValue(Double.valueOf(valueLeft.getText()));

        casualList.add(god);
        setLeftView(casualList);
    }

    public void setLeftView(List<God> list)
    {
        leftTableView.setItems(FXCollections.observableList(list));
        keyLeftTableColumn.setCellValueFactory(cell -> new ReadOnlyObjectWrapper(cell.getValue().getKey()));
        valueLeftTableColumn.setCellValueFactory(cell -> new ReadOnlyObjectWrapper(cell.getValue().getValue()));
        classLeftTableColumn.setCellValueFactory(cell -> new ReadOnlyObjectWrapper(cell.getValue().toString()));

    }

    public void setRightView(ObservableList<Map.Entry<ForMap,Double>> items)
    {
        //ObservableList<Map.Entry<String, String>> items = FXCollections.observableArrayList(map.entrySet());
        rightTableView.setItems(items);
        keyRightTableColumn.setCellValueFactory(cell -> new ReadOnlyObjectWrapper(cell.getValue().getKey().getKey()));
        valueRightTableColumn.setCellValueFactory(cell -> new ReadOnlyObjectWrapper(cell.getValue().getValue()));
        classRightTableColumn.setCellValueFactory(cell -> new ReadOnlyObjectWrapper(cell.getValue().toString()));
    }


}


