package service;

import builder.DocumentBuilder;
import entity.Document;
import repository.DocumentRepo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DocumentService {
    private DocumentRepo documentRepo;


    public DocumentService(){
        documentRepo=new DocumentRepo();
    }
    public void addDocument(DocumentBuilder documentBuilder){
        documentRepo.insertNewDocument(documentBuilder.getDocument());
    }

    public List<Document> getAllDocs(){
        return documentRepo.findAll();

    }

    public void deleteSelectedDocument(Document document){
        documentRepo.deleteById(document);

    }

    public List<String> getAllDocsType(){
        List<Document> documents= documentRepo.findAll();
        List<String> types = new ArrayList<>();
        Iterator it= documents.iterator();
        while (it.hasNext()){
            Document document=(Document) it.next();
            types.add(document.getType());
        }
        return types;

    }

    public DocumentRepo getDocumentRepo() {
        return documentRepo;
    }

    public void setDocumentRepo(DocumentRepo documentRepo) {
        this.documentRepo = documentRepo;
    }

    public Document getDocument2(String type){
        return documentRepo.findDocumentTypee(type);
    }
}
