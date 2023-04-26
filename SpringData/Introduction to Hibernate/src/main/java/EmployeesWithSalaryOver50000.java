import entities.Employee;

import javax.persistence.*;


public class EmployeesWithSalaryOver50000 {
  private static final String GET_EMPLOYEE_SALARY_OVER_50000 =
          "select e.firstName from Employee e where e.salary > 50000";

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.createQuery(GET_EMPLOYEE_SALARY_OVER_50000, String.class)
       .getResultList().forEach(System.out::println);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
