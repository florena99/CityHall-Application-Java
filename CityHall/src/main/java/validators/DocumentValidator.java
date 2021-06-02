package validators;

import controller.Admin2Controller;
import repository.DocumentRepo;
import Exception.CustomExceptionMessage;

public class DocumentValidator {
    public static void validateDocumentExistence(String name, String type, Admin2Controller admin2Controller, DocumentRepo documentRepo){
        if(name==null || name.equals("")){
           admin2Controller.errorName.setText("Name can't be empty.");
            throw new IllegalArgumentException(CustomExceptionMessage.INVALID_NAME_DOCUMENT);
        }

        if(type==null || type.equals("")){
            admin2Controller.errorType.setText("Type can't be empty");
            throw new IllegalArgumentException(CustomExceptionMessage.INVALID_NAME_DOCUMENT);
        }

        if (documentRepo.findDocumentName(name) && documentRepo.findDocumentType(type)){
            admin2Controller.errorLabel.setText("Document already exists");
            throw new IllegalArgumentException(CustomExceptionMessage.DOCUMENT_ALREADY_EXISTS);
        }


    }
}
