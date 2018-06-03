import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class DBTaskRepository implements TaskRepository {
    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void add(Task task) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(task);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }

    }

    @Override
    public Task find(String name) {
        return null;
    }

    @Override
    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            tasks = entityManager.createQuery("from Task").getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return tasks;
    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void delete(Task task) {

    }

    @Override
    public void deleteAll() {

    }
}
