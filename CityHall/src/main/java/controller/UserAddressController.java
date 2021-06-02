package controller;

import builder.AddressBuilder;
import dto.AddressDto;
import dto.UserDto;
import entity.Address;
import entity.Document;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import service.AddressService;
import service.DocumentService;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserAddressController implements Initializable {
    @FXML
    public TextField addressTextField;
    @FXML
    public TextField cityTextField;
    @FXML
    public TextField postcodeTextField;
    @FXML
    public Button addButton;
    @FXML
    public TableView<AddressDto> addressesTable;
    @FXML
    public TableColumn<AddressDto, String> idaddress;
    @FXML
    public TableColumn<AddressDto, String> address;
    @FXML
    public TableColumn<AddressDto, String> city;
    @FXML
    public TableColumn<AddressDto, String> postcode;
    @FXML
    public Button requestButton;
    @FXML
    public Button exitButton;
    @FXML
    public ImageView imageView;
    private User userAccount;
    private final AddressService addressService=new AddressService();

    public UserAddressController(User userAccount) {
        this.userAccount = userAccount;
    }




    public void addButtonOnAction(ActionEvent event) {
        AddressBuilder address=new AddressBuilder()
                            .setId()
                            .setAddress(addressTextField.getText())
                            .setCity(cityTextField.getText())
                            .setPostCode(postcodeTextField.getText());
        System.out.println(userAccount.getName());
        addressService.addAddress(address.getAddress(),userAccount);



    }

    public void refreshButtonOnAction(ActionEvent event) {

        idaddress.setCellValueFactory(new PropertyValueFactory<AddressDto, String>("idaddress"));
        address.setCellValueFactory(new PropertyValueFactory<AddressDto, String>("addressname"));
        city.setCellValueFactory(new PropertyValueFactory<AddressDto, String>("city"));
        postcode.setCellValueFactory(new PropertyValueFactory<AddressDto, String>("postalcode"));
        addressesTable.getItems().setAll(addressService.getAllAddresses(userAccount));


    }

    public void deleteButtonOnAction(ActionEvent event) {

        AddressDto addr = addressesTable.getSelectionModel().getSelectedItem();
        AddressBuilder addressBuilder= new AddressBuilder().setIdAddress(addr.getIdaddress()).setAddress(addr.getAddressname()).setCity(addr.getCity()).setPostCode(addr.getPostalcode());
        AddressService addressService=new AddressService();
        addressService.delete(addressBuilder.getAddress());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("images/primaris-cluj-napoca.png");
        javafx.scene.image.Image image = new Image(file.toURI().toString());
        imageView.setImage(image);


    }

    public void requestButtonOnAction(ActionEvent event) throws IOException {

        Stage stage = (Stage) requestButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Frames/user2.fxml"));

        UserRequestController userRequestController=new UserRequestController();
        userRequestController.setUserAccount(userAccount);
        loader.setController(userRequestController);
        Parent root = loader.load();
        stage.setTitle("Requests");
        stage.setScene(new Scene(root, 793, 531));
        stage.show();

    }

    public void setUserAccount(User user){
        userAccount=user;
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
