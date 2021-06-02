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

public class LoginController implements Initializable {
    @FXML
    public Button buttonRegister;
    @FXML
    public Label errorMessage;
    @FXML
    public PasswordField passwordTextField;
    @FXML
    private Button button1,buttonLogin;
    @FXML
    public ImageView imageView;

    @FXML
    private TextField username;
    private AdminController adminController=new AdminController();



    public void registerButtonOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) buttonRegister.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Frames/register.fxml"));
        Parent root = loader.load();
        stage.setTitle("Register");
        stage.setScene(new Scene(root, 793, 531));
        stage.show();
    }



    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("images/primaris-cluj-napoca.png");
        javafx.scene.image.Image image = new Image(file.toURI().toString());
        imageView.setImage(image);


    }

    public void loginButtonOnAction(ActionEvent event) throws IOException {
        UserService userService=new UserService();
        UserValidator.validateLogin(username.getText(),username.getText(),passwordTextField.getText(),this,userService.getUserRepo());
        User user=userService.getUser(username.getText());
        if(userService.getUser(username.getText()).getAdmin()==1) {
            Stage stage = (Stage) buttonLogin.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Frames/admin.fxml"));
            Parent root = loader.load();
            stage.setTitle("Register");
            stage.setScene(new Scene(root, 793, 531));
            stage.show();
        }
        else
        {




            Stage stage = (Stage) buttonLogin.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Frames/user.fxml"));

            UserAddressController userAddressController=new UserAddressController(user);
            userAddressController.setUserAccount(user);
            loader.setController(userAddressController);
            Parent root = loader.load();
            stage.setTitle("Home");
            stage.setScene(new Scene(root, 793, 531));
            stage.show();



        }
    }
}
