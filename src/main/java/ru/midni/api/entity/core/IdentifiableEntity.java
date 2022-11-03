package ru.midni.api.entity.core;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class IdentifiableEntity {

  @Id
  @GeneratedValue(generator = "id")
  @GenericGenerator(name = "id", strategy = "ru.midni.api.entity.generator.IdGenerator")
  @Column(name = "id", columnDefinition = "varchar(26)", updatable = false, nullable = false)
  private String id;

  @Column(name = "created_at", columnDefinition = "timestamp", updatable = false, nullable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at", columnDefinition = "timestamp", nullable = false)
  private LocalDateTime updatedAt;

  @Builder.Default
  @Column(name = "is_deleted", columnDefinition = "boolean", nullable = false)
  private Boolean isDeleted = false;

  @Builder.Default
  @Column(name = "is_completely_deleted", columnDefinition = "boolean", nullable = false)
  private Boolean isCompletelyDeleted = false;
}
