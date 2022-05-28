package com.nocountry.ecommerce.domain.model;

import lombok.*;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;

import java.util.Objects;

@Entity
@Table(name = "mark")
@NoArgsConstructor @AllArgsConstructor
@SQLDelete(sql = "UPDATE mark SET is_available = false WHERE mark_id = ?")
@Getter @Setter
@ToString
public class Mark {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "mark_id")
   private Long id;
   @Column(name = "name", unique = true, nullable = false)
   private String name;
   @Column(name = "is_available", updatable = true, nullable = false)
   private Boolean isAvailable;

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Mark mark = (Mark) o;
      return id.equals(mark.id) && name.equals(mark.name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }
}
