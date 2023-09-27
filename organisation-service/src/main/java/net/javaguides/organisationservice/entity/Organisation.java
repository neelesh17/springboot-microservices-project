package net.javaguides.organisationservice.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "organisations")
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String organisationName;
    private String organisationDescription;
    @Column(nullable = false, unique = true)
    private String organisationCode;
    @CreationTimestamp
    private LocalDateTime organisationCreatedDate;
}
