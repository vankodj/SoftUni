import entities.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EmployeesMaximumSalaries {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
      entityManager.createQuery("SELECT e.department.name, " +
              "MAX(e.salary) FROM Employee AS e GROUP BY e.department.id " +
              "HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000", Object[].class)
                .getResultList()
                .forEach(d -> System.out.printf("%s  %.2f%n",d[0],d[1]));


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
