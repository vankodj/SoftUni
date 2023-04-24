import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class AddingANewAddressAndUpdatingEmployee {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String lastName = scan.nextLine();

        entityManager.getTransaction().begin();

        Address inputAddress = new Address();
        inputAddress.setText("Vitoshka 15");
        entityManager.persist(inputAddress);

        entityManager.createQuery("UPDATE Employee e SET e.address = :ia" +
                " WHERE e.lastName = :ln")
                .setParameter("ia",inputAddress)
                .setParameter("ln",lastName).executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
