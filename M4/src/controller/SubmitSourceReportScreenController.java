package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.SourceReport;
import model.User;
import java.util.Date;

/**
 * Created by Yash on 10/12/2016.
 */
public class SubmitSourceReportScreenController {

    private User currentUser;

    private Date date;

    private static int reportCounter;

    private Main myApp;

    @FXML
    private TextField latitudeField;

    @FXML
    private TextField longitudeField;

    @FXML
    private TextField typeField;

    @FXML
    private TextField conditionField;

    @FXML
    private Button cancelButton;

    @FXML
    private Button doneButton;

    @FXML
    private ComboBox latBox;

    @FXML
    private ComboBox longBox;

    private ObservableList<String> northList = FXCollections.observableArrayList("N", "S");

    private ObservableList<String> westList = FXCollections.observableArrayList("E", "W");

    @FXML
    private void initialize() {
        latBox.setItems(northList);
        longBox.setItems(westList);
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

    public void setMainApp(Main mainApp) {
        myApp = mainApp;
    }

    @FXML
    private void handleCancelPressed() {
        myApp.loadApplication(currentUser);
    }

    @FXML
    private void handleDonePressed() {
        date = new Date();
        String name = currentUser.getFirstName() + " " + currentUser.getLastName();
        SourceReport report = new SourceReport(reportCounter, name, date.toString(), longitudeField.getText() + longBox.getValue(), latitudeField.getText() + latBox.getValue(), typeField.getText(), conditionField.getText());
        reportCounter++;
        myApp.addSourceReport(report);
        myApp.loadApplication(currentUser);
    }




}
