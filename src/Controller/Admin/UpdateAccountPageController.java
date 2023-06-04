/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.Account;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Abdullah
 */
public class UpdateAccountPageController implements Initializable {

    private Account oldAccount;
    
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
    @FXML
    private TextField dateTF;
    @FXML
    private Button updateNewUserBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //get selected user data from UsersManagmentController updatedUser var
        this.oldAccount = Controller.Admin.AccountsManagmentController.selectedAccountToUpdate;
        
        //set text field's data the same as updatedUser data
        userIDTF.setText(Integer.toString(oldAccount.getUser_id()));
        accountNumberTF.setText(Integer.toString(oldAccount.getAccount_number()));
        usernameTF.setText(oldAccount.getUsername());
        balanceTF.setText(Double.toString(oldAccount.getBalance()));
        currencyTF.setText(oldAccount.getCurrency());
        dateTF.setText(oldAccount.getCreation_date());
        
       
    }    


    @FXML
    private void updateNewAccount(ActionEvent event) throws SQLException, ClassNotFoundException {
        int user_id = Integer.parseInt(userIDTF.getText());
        int account_number = Integer.parseInt(accountNumberTF.getText());
        String username = usernameTF.getText();
        String currency = currencyTF.getText();
        double balance = Integer.parseInt(balanceTF.getText());
        String creationDate = dateTF.getText();
        
        // make an account object having this data
        Account newaccount = new Account(user_id, account_number, username, currency, balance);
        
        //set the new user id the same as the old user
        newaccount.setId(oldAccount.getId());
        
        // update the user in database by update method
        newaccount.update();
        
        //close the update stage using our global stage var in UsersManagmentController and show an alert
        Controller.Admin.AccountsManagmentController.updateStage.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User updated");
        alert.setContentText("User updated");
        alert.showAndWait();
        
    }

    @FXML
    private void cancelAccountUpdating(ActionEvent event) {
        Controller.Admin.AccountsManagmentController.updateStage.close(); 

    }
    
}
