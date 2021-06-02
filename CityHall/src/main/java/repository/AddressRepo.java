package repository;

import entity.Address;
import entity.Document;
import entity.User;
import query.AddressQuery;
import query.UserQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AddressRepo {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewAddress(Address address) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(address);
        em.getTransaction().commit();
    }

    public List<Address> findall(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query jpqlQuery = em.createQuery(AddressQuery.ADDRESSES, Address.class).setParameter("user", user);
        List<Address> address = jpqlQuery.getResultList();
        em.close();
        return address;

    }

    public void deleteById(Address address) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(address) ? address : em.merge(address));
        em.getTransaction().commit();
        em.close();

    }

    public Address findByAddressName(String address){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query jpqlQuery = em.createQuery(AddressQuery.ADDRESS_BY_ADDRESS_NAME, Address.class).setParameter("addressname", address);
        List<Address> address2 = jpqlQuery.getResultList();
        em.close();
        return address2.get(0);
    }
}
