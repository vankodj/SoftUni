
import entities.Car;
import entities.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("relations");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Vehicle car = new Car("Ford Focus","Petrol",5);


        entityManager.persist(car);



        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
