package builder;

import entity.Document;

import java.util.UUID;

public class DocumentBuilder {

    private Document document;

    public DocumentBuilder(){
        document=new Document();
    }

    public DocumentBuilder setId(){
        document.setIddocument(UUID.randomUUID().toString());
        return this;
    }

    public DocumentBuilder setName(String name){
        document.setName(name);
        return this;
    }

    public DocumentBuilder setType(String type){
        document.setType(type);
        return this;
    }

    public Document getDocument() {
        return document;
    }
}
