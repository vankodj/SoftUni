import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class FindEmployeesByFirstName {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String input = scan.nextLine();
        entityManager.getTransaction().begin();

        entityManager.createQuery("select e from Employee e " +
                "where e.firstName like :in", Employee.class)
                .setParameter("in",input + "%")
                .getResultStream().forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n"
                                ,e.getFirstName()
                                ,e.getLastName()
                                ,e.getJobTitle()
                                ,e.getSalary()));


        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
