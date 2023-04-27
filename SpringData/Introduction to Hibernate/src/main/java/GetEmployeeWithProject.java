import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.Scanner;

public class GetEmployeeWithProject {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        int inputID = Integer.parseInt(scan.nextLine());

        entityManager.getTransaction().begin();
        Employee singleResult = entityManager.createQuery
                        ("select e from Employee e " +
                                "where e.id = :id ", Employee.class)
                .setParameter("id", inputID).getSingleResult();
        System.out.printf("%s %s - %s%n",singleResult.getFirstName()
                ,singleResult.getLastName()
                ,singleResult.getJobTitle());
        singleResult.getProjects().stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.printf("    %s%n",p.getName()));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
