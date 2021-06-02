package repository;

import entity.Document;
import entity.User;
import query.DocumentQuery;
import query.UserQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.print.Doc;
import java.util.List;

public class DocumentRepo {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewDocument(Document document) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(document);
        em.getTransaction().commit();
        em.close();
    }

    public boolean findDocumentName(String name){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query jpqlQuery = em.createQuery(DocumentQuery.DOCUMENT_BY_NAME, Document.class).setParameter("name", name);
        List<Document> users = jpqlQuery.getResultList();
        em.close();
        return users.size() != 0;
    }

    public boolean findDocumentType(String type){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query jpqlQuery = em.createQuery(DocumentQuery.DOCUMENT_BY_TYPE, Document.class).setParameter("type", type);
        List<Document> docs = jpqlQuery.getResultList();
        em.close();
        return docs.size() != 0;
    }

    public List<Document> findAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query jpqlQuery = em.createQuery(DocumentQuery.DOCUMENT_ALL, Document.class);
        List<Document> docs = jpqlQuery.getResultList();
        em.close();
        return docs;
    }

    public void deleteById(Document document){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(document) ? document : em.merge(document));
        em.getTransaction().commit();
        em.close();


    }

    public Document findDocumentTypee(String type){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query jpqlQuery = em.createQuery(DocumentQuery.DOCUMENT_BY_TYPE, Document.class).setParameter("type", type);
        List<Document> docs = jpqlQuery.getResultList();
        em.close();
        System.out.println(docs.get(0));
        return docs.get(0);
    }
}
