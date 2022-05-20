package com.nocountry.ecommerce.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mark")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
public class Mark {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "mark_id")
   private Long id;
   @Column(unique = true, nullable = false)
   private String name;

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
