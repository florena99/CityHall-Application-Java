package start;

import controller.LoginController;
import entity.Address;
import entity.Document;
import entity.Request;
import entity.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import repository.AddressRepo;
import repository.DocumentRepo;
import repository.RequestRepo;
import repository.UserRepo;

import java.io.File;
import java.time.LocalDate;
import java.util.UUID;


import javafx.application.Application;




public class ApplicationStart extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\PC\\Desktop\\Facultate\\An III\\Sem II\\PS\\2021-ps-a1-florena99-master\\src\\main\\resources\\Frames\\mainPage.fxml").toURI().toURL());
        Parent root= loader.load();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root,700,475));
        primaryStage.show();
        LoginController loginController=new LoginController();

    }

    public static void main(String[] args) {
        launch(args);





//        UserRepo ur = new UserRepo();
//        User user = new User();
//        user.setIduser("2");
//        user.setName("Streang Florena");
//        user.setPhone("0757176949");
//        user.setEmail("streangflorena@gmail.com");
//        user.setAdmin(1);
//        user.setCNP("2990607123444");
//        user.setUsername("fflorenastr");
//        user.setPassword("123123");
//
//
//        AddressRepo ar=new AddressRepo();
//        Address address=new Address();
//        address.setIdaddress(UUID.randomUUID().toString());
//        address.setAddressname("Str. Ciocarliei, nr. 42");
//        address.setCity("Cluj-Napoca");
//        address.setPostalcode("400619");
//        address.setUser(user);
//        user.addAddress(address);
//
//
//        DocumentRepo dr=new DocumentRepo();
//        Document document=new Document();
//        document.setIddocument(UUID.randomUUID().toString());
//        document.setName("Cerere tip 1");
//        document.setType("Cerere");
//
//        RequestRepo rr=new RequestRepo();
//        Request request=new Request();
//        request.setIdrequest(UUID.randomUUID().toString());
//        request.setDate(LocalDate.now());
//        request.setDocument(document);
//        request.setUser(user);
//        request.setApproved(1);
//
//
//        ur.insertNewUser(user);
//        ar.insertNewAddress(address);
//        dr.insertNewDocument(document);
//        rr.insertNewRequest(request);
    }


}
