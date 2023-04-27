import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class RemoveTowns {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        String inputTown = scan.nextLine();

        Town town = entityManager
                .createQuery("SELECT t FROM Town t "
                        + "WHERE t.name = :townName", Town.class)
                .setParameter("townName", inputTown)
                .getSingleResult();

        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address a "
                        + "WHERE a.town.id = :townId", Address.class)
                .setParameter("townId", town.getId())
                .getResultList();


        addresses.forEach(entityManager::remove);

        if (addresses.size() == 1) {
            System.out.printf("1 address in %s deleted", town.getName());
        } else {
            System.out.printf("%d addresses in %s deleted", addresses.size(), town.getName());
        }
    }
}