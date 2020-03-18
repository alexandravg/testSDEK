package alexandra.golovchenko.repository;

import alexandra.golovchenko.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepositoryJPA extends JpaRepository<TaskEntity, UUID> {
}
