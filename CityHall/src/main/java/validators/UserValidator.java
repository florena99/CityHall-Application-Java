package validators;

import controller.LoginController;
import controller.RegisterController;
import Exception.CustomExceptionMessage;
import repository.UserRepo;

public class UserValidator {

    public static void validateUserNullOrEmptyTextFields(String name, String phone, String email, String CNP, String password, RegisterController controller) {
        if (name.matches("[0-9]+")) {
            controller.errorName.setText( "Invalid name");
            throw new IllegalArgumentException(CustomExceptionMessage.INVALID_NAME_MESSAGE);
        }
        if (CNP.length()!=13){
            controller.errorCNP.setText("Invalid CNP");
            throw new IllegalArgumentException(CustomExceptionMessage.INVALID_CNP_MESSAGE);
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            controller.errorEmail.setText(" Invalid email");
            throw new IllegalArgumentException(CustomExceptionMessage.INVALID_EMAIL_MESSAGE);
        }
        if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@!#$%^&+=])(?=\\S+$).{8,}$")){

            controller.errorPass.setText("Week password");
            throw new IllegalArgumentException(CustomExceptionMessage.INVALID_PASSWORD_MESSAGE);
        }
        if (phone.length()!=10){
            controller.errorPhone.setText( "Invalid phone");
            throw new IllegalArgumentException(CustomExceptionMessage.INVALID_PHONE_MESSAGE);
        }
    }



    public static void validateExistence(String CNP, String phone, String email, RegisterController registerController, UserRepo userRepo){
        if (userRepo.findUserCNP(CNP)){
            registerController.errorCNP.setText("CNP already exists");
            throw new IllegalArgumentException(CustomExceptionMessage.CNP_ALREADY_EXISTS_MESSAGE);
        }

        if (userRepo.findUserPhone(phone)){
            registerController.errorPhone.setText("Phone number already exists");
            throw new IllegalArgumentException(CustomExceptionMessage.PHONE_ALREADY_EXISTS_MESSAGE);
        }

        if (userRepo.findUserEmail(email)){
            registerController.errorEmail.setText("Email already exists");
            throw new IllegalArgumentException(CustomExceptionMessage.EMAIL_ALREADY_EXISTS_MESSAGE);
        }
    }

    public static void validateLogin( String phone, String email,String password, LoginController controller, UserRepo userRepo) {
        if (!userRepo.findUserEmail(email) && !userRepo.findUserPhone(phone)) {
            controller.errorMessage.setText("User doesn't exist");
            throw new IllegalArgumentException(CustomExceptionMessage.USER_DOESNT_EXIST);
        }

        if (!userRepo.findUserPassword(password)) {
            controller.errorMessage.setText("User doesn't exist");
            throw new IllegalArgumentException(CustomExceptionMessage.USER_DOESNT_EXIST);
        }
    }

}
