import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class FindLatest10Projects {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery
                        ("select p from Project p order by p.startDate desc ", Project.class)
                .setMaxResults(10).getResultStream()
                .sorted((p1,p2)->p1.getName().compareTo(p2.getName()))
                .forEach(p -> System.out.printf("Project name: %s%n" +
                        "        Project Description: %s%n" +
                        "        Project Start Date: %s%n" +
                        "        Project End Date: %s%n"
                                ,p.getName()
                                ,p.getDescription()
                                ,p.getStartDate()
                                ,p.getEndDate()));


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
