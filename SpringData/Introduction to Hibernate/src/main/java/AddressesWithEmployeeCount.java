import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddressesWithEmployeeCount {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery("select a" +
                " from Address a order by a.employees.size desc ", Address.class).setMaxResults(10)
                .getResultList()
                        .forEach(a -> System.out.printf("%s, %s - %d employees%n"
                                ,a.getText()
                                ,a.getTown().getName()
                                ,a.getEmployees().size()));
//163 Nishava Str, ent A, apt. 1, Sofia - 3 employees

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
