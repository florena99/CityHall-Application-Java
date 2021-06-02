package controller;

import builder.DocumentBuilder;
import dto.UserDto;
import entity.Document;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import repository.DocumentRepo;
import service.DocumentService;
import validators.DocumentValidator;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Admin2Controller implements Initializable {
    @FXML
    public Button usersButton;
    @FXML
    public Button documentsButton;
    @FXML
    public Button requestButton;
    @FXML
    public Button exitButton;
    @FXML
    public AnchorPane adaugare_document;
    @FXML
    public TextField docNameTextField;
    @FXML
    public TextField docTypeTextField;
    @FXML
    public Button addButtom;
    @FXML
    public Label errorName;
    @FXML
    public Label errorType;
    @FXML
    public Label errorLabel;
    @FXML
    public TableView<Document> docstableView;

    @FXML
    public Button refreshButton;
    @FXML
    public Button deleteButton;
    @FXML
    public TableColumn<Document,String> id_doc_col;
    @FXML
    public TableColumn<Document, String> name_col;
    @FXML
    public TableColumn<Document, String> type_col;
    @FXML
    public ImageView imageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("images/primaris-cluj-napoca.png");
        javafx.scene.image.Image image = new Image(file.toURI().toString());
        imageView.setImage(image);

    }


    public void addButtonOnAction(ActionEvent event) {
        DocumentService documentService=new DocumentService();
        DocumentValidator.validateDocumentExistence(docNameTextField.getText(),docTypeTextField.getText(),this,documentService.getDocumentRepo());
        DocumentBuilder documentBuilder=new DocumentBuilder()
                                            .setId()
                                            .setName(docNameTextField.getText())
                                            .setType(docTypeTextField.getText());
        documentService.addDocument(documentBuilder);
    }


    public void refreshOnAction(ActionEvent event) {
        DocumentService documentService=new DocumentService();
        id_doc_col.setCellValueFactory(new PropertyValueFactory<Document, String>("iddocument"));
        name_col.setCellValueFactory(new PropertyValueFactory<Document, String>("name"));
        type_col.setCellValueFactory(new PropertyValueFactory<Document, String>("type"));
        docstableView.getItems().setAll(documentService.getAllDocs());

    }

    public void deleteOnAction(ActionEvent event) {
        Document doc = docstableView.getSelectionModel().getSelectedItem();
        DocumentService documentService=new DocumentService();
        documentService.deleteSelectedDocument(doc);

    }

    public void requestButtonOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) requestButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Frames/admin3.fxml"));
        Parent root = loader.load();
        stage.setTitle("Register");
        stage.setScene(new Scene(root, 793, 531));
        stage.show();
    }
    public void exitButtonOnAction(ActionEvent event) throws IOException {

        Stage stage = (Stage) exitButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Frames/mainPage.fxml"));
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
