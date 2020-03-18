package alexandra.golovchenko.entity;

import alexandra.golovchenko.repository.TaskRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Component
public class TaskWorker {

    @Autowired
    private TaskRepositoryJPA taskRepositoryJPA;
    @PersistenceContext
    private EntityManager entityManager;

    public UUID addNewTask(UUID order) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(UUID.randomUUID());
        taskEntity.setOrderId(order);
        taskEntity.setDateOfCreatingTask(LocalDateTime.now());
        taskEntity.setDone(false);
        taskRepositoryJPA.save(taskEntity);
        return taskEntity.getId();
    }
    @Nullable
    public List<TaskEntity> getTasks(RequestEntity requestEntity) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TaskEntity> criteriaQuery = criteriaBuilder.createQuery(TaskEntity.class);
        Root<TaskEntity> root = criteriaQuery.from(TaskEntity.class);
        List<Predicate> predicates = new LinkedList<>();
        predicates.add(criteriaBuilder.between(root.get("dateOfCreatingTask"), requestEntity.getStartDate(),
                requestEntity.getFinishDate()));
        if (requestEntity.getOrderId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("orderId"), requestEntity.getOrderId()));
        }
        Predicate[] pr = new Predicate[predicates.size()];
        pr = predicates.toArray(pr);
        criteriaQuery.select(root).where(pr);
        return entityManager.createQuery(criteriaQuery).getResultList();

    }
}
