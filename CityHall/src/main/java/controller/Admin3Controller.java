package controller;

import dto.RequestTableDto;
import dto.RequestUserDto;
import dto.RequestUserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import service.RequestService;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Admin3Controller implements Initializable {

    @FXML
    public Button usersButton;
    @FXML
    public Button documentsButton;
    @FXML
    public Button requestButton;
    @FXML
    public Button exitButton;
    @FXML
    public TableView<RequestUserDto> requestsTable;
    @FXML
    public TableColumn<RequestUserDto,String> idRequestColumn;
    @FXML
    public TableColumn<RequestUserDto,String> idDocumentColumn;
    @FXML
    public TableColumn<RequestUserDto, String> idAddressColumn;
    @FXML
    public TableColumn<RequestUserDto, LocalDate> dateColumn;
    @FXML
    public TableColumn<RequestUserDto, Integer> statusColumn;
    @FXML
    public TableColumn<RequestUserDto, String> idUserColumn;
    @FXML
    public Button aproveButton;
    @FXML
    public Button declineButton;
    @FXML
    public Button refreshButton;
    @FXML
    public ImageView imageView;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("images/primaris-cluj-napoca.png");
        javafx.scene.image.Image image = new Image(file.toURI().toString());
        imageView.setImage(image);


    }


    public void refreshButtonOnAction(ActionEvent event) {
        RequestService requestService=new RequestService();
        idRequestColumn.setCellValueFactory(new PropertyValueFactory<RequestUserDto, String>("idRequest"));
        idDocumentColumn.setCellValueFactory(new PropertyValueFactory<RequestUserDto, String>("documentType"));
        idAddressColumn.setCellValueFactory(new PropertyValueFactory<RequestUserDto, String>("addressName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<RequestUserDto, LocalDate>("date"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<RequestUserDto, Integer>("status"));
        idUserColumn.setCellValueFactory(new PropertyValueFactory<RequestUserDto, String>("CNP"));
        requestsTable.getItems().setAll(requestService.getAllRequests());
    }

    public void aproveButtonOnAction(ActionEvent event) {
        RequestUserDto requestUserDto = requestsTable.getSelectionModel().getSelectedItem();
        RequestService requestService= new RequestService();
        requestService.updateStatus(requestUserDto,1);
    }

    public void declineButtonOnAction(ActionEvent event) {
        RequestUserDto requestUserDto = requestsTable.getSelectionModel().getSelectedItem();
        RequestService requestService= new RequestService();
        requestService.updateStatus(requestUserDto,-1);
    }
    public void exitButtonOnAction(ActionEvent event) throws IOException {

        Stage stage = (Stage) exitButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Frames/mainPage.fxml"));
        Parent root = loader.load();
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 793, 531));
        stage.show();

    }

    public void documentsButtonOnAction(ActionEvent event) throws IOException {

        Stage stage = (Stage) documentsButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Frames/admin2.fxml"));
        Parent root = loader.load();
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 793, 531));
        stage.show();

    }
    public void usersButtonOnAction(ActionEvent event) throws IOException {

        Stage stage = (Stage) usersButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Frames/admin.fxml"));
        Parent root = loader.load();
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 793, 531));
        stage.show();

    }
}
