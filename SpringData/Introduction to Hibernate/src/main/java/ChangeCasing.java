import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ChangeCasing {
    private static final String DATABASE_NAME =
            "soft_uni";

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory(DATABASE_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query towns = entityManager.createQuery("SELECT t FROM Town t", Town.class);
        List<Town> ResultList = towns.getResultList();

        for (Town town:ResultList ){
            final String townName = town.getName();
            if (townName.length()<=5){
                town.setName(townName.toUpperCase());
                entityManager.persist(town);
            }
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
