package pl.calculator.controllers.userInterface.menuPanes;

import pl.calculator.database.tasks.UserTask;
import pl.calculator.models.modelFx.UserFx;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StatisticController {

    @FXML
    private TableView<UserFx> tableView;

    @FXML
    private TableColumn<UserFx, Number> idTableColumn;

    @FXML
    private TableColumn<UserFx, String> nickTableColumn;

    @FXML
    private TableColumn<UserFx, String> emailTableColumn;

    @FXML
    private TableColumn<UserFx, Number> countTableColumn;

    @FXML
    public void initialize() {
        UserTask userTask = new UserTask();
        tableView.setItems(userTask.pullAllUserFx());
        idTableColumn.setCellValueFactory(cell-> cell.getValue().idProperty());
        nickTableColumn.setCellValueFactory(cell-> cell.getValue().nickProperty());
        emailTableColumn.setCellValueFactory(cell-> cell.getValue().emailProperty());
        countTableColumn.setCellValueFactory(cell-> cell.getValue().wealthProperty());

    }

}

