package controller;

import builder.AddressBuilder;
import builder.RequestBuilder;
import dto.AddressDto;
import dto.RequestDto;
import dto.RequestTableDto;
import entity.Address;
import entity.Request;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import repository.AddressRepo;
import repository.RequestRepo;
import service.AddressService;
import service.DocumentService;
import service.RequestService;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class UserRequestController  implements Initializable {

    @FXML
    public ChoiceBox<String> documentPicker;
    @FXML
    public ChoiceBox<String> addressPicker;
    @FXML
    public Button addButton;
    @FXML
    public TableColumn<RequestTableDto, String> idRequestColumn;
    @FXML
    public TableColumn<RequestTableDto, String> idDocumentColumn;
    @FXML
    public TableColumn<RequestTableDto, String> idAddressColumn;
    @FXML
    public TableColumn<RequestTableDto, LocalDate> dateColumn;
    @FXML
    public TableColumn<RequestTableDto, Integer> statusColumn;
    @FXML
    public Button deleteButton;
    @FXML
    public Button updateButton;
    @FXML
    public Button refreshButton;
    @FXML
    public Button usersButton;
    @FXML
    public Button requestButton;
    @FXML
    public Button exitButton;
    @FXML
    public TableView<RequestTableDto> requestsTable;
    @FXML
    public ImageView imageView;
    private User userAccount;
    private AddressService addressService = new AddressService();
    private DocumentService documentService = new DocumentService();
    private RequestService requestService = new RequestService();

    public User getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(User userAccount) {
        this.userAccount = userAccount;
    }

    public void addButtonOnAction(ActionEvent event) {

    String documentType = documentPicker.getSelectionModel().getSelectedItem();
    String addressName = addressPicker.getSelectionModel().getSelectedItem();
    requestService.addRequest(requestService.build(new RequestDto(userAccount,addressService.getAddressName(addressName),documentService.getDocument2(documentType))));



    }



    public void deleteButtonOnAction(ActionEvent event) {
        RequestTableDto addr = requestsTable.getSelectionModel().getSelectedItem();
        requestService.delete(addr,userAccount);
    }

    public void updateButtonOnAction(ActionEvent event) {
        String documentType = documentPicker.getSelectionModel().getSelectedItem();
        String addressName = addressPicker.getSelectionModel().getSelectedItem();
        RequestTableDto addr = requestsTable.getSelectionModel().getSelectedItem();
        requestService.updateRequest(addr, addressName);


    }

    public void refreshButtonOnAction(ActionEvent event) {
        idRequestColumn.setCellValueFactory(new PropertyValueFactory<RequestTableDto, String>("idRequest"));
        idDocumentColumn.setCellValueFactory(new PropertyValueFactory<RequestTableDto, String>("documentType"));
        idAddressColumn.setCellValueFactory(new PropertyValueFactory<RequestTableDto, String>("addressName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<RequestTableDto, LocalDate>("date"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<RequestTableDto, Integer>("status"));
        requestsTable.getItems().setAll(requestService.getAllUserRequests(userAccount));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("images/primaris-cluj-napoca.png");
        javafx.scene.image.Image image = new Image(file.toURI().toString());
        imageView.setImage(image);


        addressPicker.setItems(FXCollections.observableList(addressService.getAllAddressesName(userAccount)));
        documentPicker.setItems(FXCollections.observableList(documentService.getAllDocsType()));

    }

    public void requestButtonOnAction(ActionEvent event) throws IOException {

        Stage stage = (Stage) usersButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Frames/user.fxml"));

        UserAddressController userAddressController=new UserAddressController(userAccount);
        userAddressController.setUserAccount(userAccount);
        loader.setController(userAddressController);
        Parent root = loader.load();
        stage.setTitle("Addresses");
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
}
