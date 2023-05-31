/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.Account;
import Model.User;
import View.ViewManager;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Abdullah
 */
public class CreateAccountController implements Initializable {

    @FXML
    private Button usersManagmentPageBtn;
    @FXML
    private Button accountsPageBtn;
    @FXML
    private Button operationsPageBtn;
    @FXML
    private Button saveNewUserBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField userIDTF;
    @FXML
    private TextField accountNumberTF;
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField balanceTF;
    @FXML
    private TextField currencyTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showUsersManagmentPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToUsersManagment();

    }

    @FXML
    private void showAccountsPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }

    @FXML
    private void showOperationsPage(ActionEvent event) {
    }

    @FXML
    private void saveNewAccount(ActionEvent event) throws SQLException, ClassNotFoundException {
        // get data from all text fields 
        String user_id = userIDTF.getText();
        int account_number = Integer.parseInt(accountNumberTF.getText());
        String username = usernameTF.getText();
        String currency = currencyTF.getText();
        double balance = Integer.parseInt(balanceTF.getText());
        LocalDate currentDate = LocalDate.now();
        Date date = (Date) Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        
        // make an user object having this data
        Account account = new Account(user_id, account_number, username, currency, balance, date);
        // save the user in database by save method
        account.save();
        
        //after saving should return to the back scene and show an alert
        ViewManager.adminPage.changeSceneToUsersManagment();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User inserted");
        alert.setContentText("User inserted");
        alert.showAndWait();
    }

    @FXML
    private void cancelUserCreation(ActionEvent event) {
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }
    
}
