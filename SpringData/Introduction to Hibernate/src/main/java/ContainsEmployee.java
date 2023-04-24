import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class ContainsEmployee {
    private static final String COUNT_INPUT_NAMES_OF_EMPLOYEES =
            "SELECT COUNT(e) FROM Employee e " +
                    "WHERE e.firstName = :fn AND e.lastName = :ln";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Employee Name: ");

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
       String [] inputName = scan.nextLine().split(" ");
       String firstName = inputName[0];
       String lastName = inputName[1];
        Long matches = entityManager.createQuery
               (COUNT_INPUT_NAMES_OF_EMPLOYEES, Long.class)
                       .setParameter("fn" , firstName)
                               .setParameter("ln",lastName)
                                       .getSingleResult();

        if (matches ==0){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }

        entityManager.close();
    }
}
