package repository;

import entity.Address;
import entity.Document;
import entity.Request;
import entity.User;
import query.RequestQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class RequestRepo {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewRequest(Request request) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(request);
        em.getTransaction().commit();
        em.close();
    }


    public List<Request> findall(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query jpqlQuery = em.createQuery(RequestQuery.REQUESTS, Request.class).setParameter("user", user);
        List<Request> address = jpqlQuery.getResultList();
        em.close();
        return address;

    }

    public List<Request> findAllRequests() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query jpqlQuery = em.createQuery(RequestQuery.ALL_REQUESTS, Request.class);
        List<Request> address = jpqlQuery.getResultList();
        em.close();
        return address;

    }

    public void delete(Request request){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(request) ? request : em.merge(request));
        em.getTransaction().commit();
        em.close();


    }

    public void update(Address address, String idrequest) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery(RequestQuery.UPDATE_REQUEST).setParameter("address", address).setParameter("idrequest", idrequest).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void updateStatus(int status,String idrequest) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery(RequestQuery.UPDATE_STATUS).setParameter("approved", status).setParameter("idrequest", idrequest).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
