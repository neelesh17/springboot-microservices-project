package net.javaguides.departmentservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String departmentName;
    @Column(nullable = false)
    private String departmentDescription;
    @Column(nullable = false)
    private String departmentCode;
}
