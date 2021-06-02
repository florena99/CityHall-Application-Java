package controller;

import dto.UserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.UserService;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML
    public Button usersButton;
    @FXML
    public Button documentsButton;
    @FXML
    public Button requestButton;
    @FXML
    public Button exitButton;
    @FXML
    public TableView<UserDto> usersTable;
    @FXML
    public Label nrofusersLabel;
    @FXML
    public TableColumn<UserDto,String> columnId;
    @FXML
    public TableColumn<UserDto,String> columnName;
    @FXML
    public TableColumn<UserDto,String> columnCNP;
    @FXML
    public TableColumn<UserDto,String> columnPhone;
    @FXML
    public TableColumn<UserDto,String> columnEmail;
    public UserService userService= new UserService();
    @FXML
    public ImageView imageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("images/primaris-cluj-napoca.png");
        javafx.scene.image.Image image = new Image(file.toURI().toString());
        imageView.setImage(image);

    }


    public void documentsButtonOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) documentsButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Frames/admin2.fxml"));
        Parent root = loader.load();
        stage.setTitle("Register");
        stage.setScene(new Scene(root, 793, 531));
        stage.show();

    }


    public void usersButtononAction(ActionEvent event) {
        columnId.setCellValueFactory(new PropertyValueFactory<UserDto, String>("iduser"));
            columnName.setCellValueFactory(new PropertyValueFactory<UserDto, String>("name"));
            columnCNP.setCellValueFactory(new PropertyValueFactory<UserDto, String>("CNP"));
            columnPhone.setCellValueFactory(new PropertyValueFactory<UserDto, String>("phone"));
            columnEmail.setCellValueFactory(new PropertyValueFactory<UserDto, String>("email"));
            usersTable.getItems().setAll(userService.getAllUsers());
            nrofusersLabel.setText(String.valueOf(usersTable.getItems().size()));
    }


        public void exitButtonOnAction(ActionEvent event) throws IOException {

            Stage stage = (Stage) exitButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Frames/mainPage.fxml"));
            Parent root = loader.load();
            stage.setTitle("Login");
            stage.setScene(new Scene(root, 793, 531));
            stage.show();

        }

    public void requestButtonOnAction(ActionEvent event) throws IOException {

        Stage stage = (Stage) requestButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Frames/admin3.fxml"));
        Parent root = loader.load();
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 793, 531));
        stage.show();

    }

}
