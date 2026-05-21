package site.memoria.global.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    @Column(name = "db_inserted_at", nullable = false, updatable = false)
    private LocalDateTime dbInsertedAt;

    @Column(name = "db_updated_at")
    private LocalDateTime dbUpdatedAt;

    @PrePersist
    public void prePersist() {
        this.dbInsertedAt = LocalDateTime.now();
        this.dbUpdatedAt = null;
    }

    @PreUpdate
    public void preUpdate() {
        this.dbUpdatedAt = LocalDateTime.now();
    }
}
