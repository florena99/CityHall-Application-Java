package controller;

import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import service.UserService;
import validators.UserValidator;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    public Button loginButton;
    @FXML
    public Label errorName;
    @FXML
    public Label errorCNP;
    @FXML
    public Label errorEmail;
    @FXML
    public Label errorPhone;
    @FXML
    public Label errorPass;
    @FXML
    public TextField textFieldName;
    @FXML
    public TextField textFieldCNP;
    @FXML
    public TextField textFieldPhone;
    @FXML
    public TextField textFieldEmail;
    @FXML
    public PasswordField textFieldPass;
    @FXML
    public Button registerButton;
    @FXML
    public ImageView imageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("images/primaris-cluj-napoca.png");
        javafx.scene.image.Image image = new Image(file.toURI().toString());
        imageView.setImage(image);


    }
    public void registerButtonOnAction(ActionEvent event){

        UserService userService=new UserService();
        UserValidator.validateUserNullOrEmptyTextFields(textFieldName.getText(),
                                                        textFieldPhone.getText(),
                                                        textFieldEmail.getText(),
                                                        textFieldCNP.getText(),
                                                        textFieldPass.getText(),
                                                        this);
        UserValidator.validateExistence(textFieldCNP.getText(),textFieldPhone.getText(),textFieldEmail.getText(),this,userService.getUserRepo());

        User user=new User(textFieldName.getText(),textFieldPhone.getText(),textFieldEmail.getText(),textFieldCNP.getText(),textFieldPass.getText());
        userService.addUser(user);
        }

    public void loginButtonOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Frames/mainPage.fxml"));
        Parent root = loader.load();
        stage.setTitle("Register");
        stage.setScene(new Scene(root, 793, 531));
        stage.show();
    }

}

