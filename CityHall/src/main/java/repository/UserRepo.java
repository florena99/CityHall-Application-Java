package repository;

import entity.User;
import query.UserQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserRepo {
	
	private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");


	public void insertNewUser(User user) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

	public boolean findUserCNP(String CNP){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query jpqlQuery = em.createQuery(UserQuery.USER_BY_CNP, User.class).setParameter("CNP", CNP);
		List<User> users = jpqlQuery.getResultList();
		em.close();
		return users.size() != 0;
	}

	public boolean findUserEmail(String email){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query jpqlQuery = em.createQuery(UserQuery.USER_BY_EMAIL, User.class).setParameter("email", email);
		List<User> users = jpqlQuery.getResultList();
		em.close();
		return users.size() != 0;
	}
	public boolean findUserPhone(String phone){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query jpqlQuery = em.createQuery(UserQuery.USER_BY_PHONE, User.class).setParameter("phone", phone);
		List<User> users = jpqlQuery.getResultList();
		em.close();
		return users.size() != 0;
	}

	public boolean findUserPassword(String password ){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query jpqlQuery = em.createQuery(UserQuery.USER_BY_PASSWORD, User.class).setParameter("password", password);
		List<User> users = jpqlQuery.getResultList();
		em.close();
		return users.size() != 0;
	}

	public List<User> findall(){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query jpqlQuery = em.createQuery(UserQuery.USERS, User.class).setParameter("admin",0);
		List<User> users = jpqlQuery.getResultList();
		em.close();
		return users;
	}

	public User findAdminbyEmail(String email){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query jpqlQuery = em.createQuery(UserQuery.USER_BY_EMAIL, User.class).setParameter("email", email);
		List<User> users = jpqlQuery.getResultList();
		em.close();
		return users.get(0);
	}

	public User findById(String id){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query jpqlQuery = em.createQuery(UserQuery.USER_BY_ID, User.class).setParameter("iduser", id);
		List<User> users = jpqlQuery.getResultList();
		em.close();
		return users.get(0);

	}


}
