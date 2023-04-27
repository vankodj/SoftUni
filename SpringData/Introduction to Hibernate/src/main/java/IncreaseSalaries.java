import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class IncreaseSalaries {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery
                ("update Employee e set e.salary = e.salary *1.12" +
                        " where e.department.id in(1, 2, 4, 11)")
                .executeUpdate();
        entityManager.getTransaction().commit();
         entityManager.createQuery("select e from Employee e " +
                 "where e.department.name in" +
                 "('Engineering', 'Tool Design', 'Marketing', 'Information Services')",Employee.class)
                         .getResultList().forEach(e -> System.out.printf("%s %s ($%.2f)%n"
                 ,e.getFirstName()
                 ,e.getLastName()
                 ,e.getSalary()));

        entityManager.close();
    }
}
