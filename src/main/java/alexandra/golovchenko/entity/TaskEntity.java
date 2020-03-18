package alexandra.golovchenko.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "task")
public class TaskEntity {
    @Id
    private UUID id;
    @Column
    private UUID orderId;
    @Column
    private LocalDateTime dateOfCreatingTask;
    @Column
    private boolean isDone;

    public TaskEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDateOfCreatingTask() {
        return dateOfCreatingTask;
    }

    public void setDateOfCreatingTask(LocalDateTime dateOfCreatingTask) {
        this.dateOfCreatingTask = dateOfCreatingTask;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
}
