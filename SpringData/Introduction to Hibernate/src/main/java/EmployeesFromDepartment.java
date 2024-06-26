import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeesFromDepartment {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        String department = "Research and Development";

        entityManager.createQuery("select e from Employee e WHERE e.department.name = " +
                ":dp order by e.salary asc, e.id asc", Employee.class)
                .setParameter("dp" , department)
                .getResultList()
                .forEach(e -> System.out.printf("%s %s from %s - $%.2f%n"
                                ,e.getFirstName()
                                ,e.getLastName()
                                ,e.getDepartment().getName()
                                ,e.getSalary()));


        entityManager.close();
    }
}
