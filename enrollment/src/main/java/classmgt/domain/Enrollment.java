package classmgt.domain;

import classmgt.EnrollmentApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Enrollment_table")
@Data
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    @Embedded
    @AttributeOverride(
        name = "id",
        column = @Column(name = "classIdId", nullable = true)
    )
    private ClassId classId;

    @Enumerated(EnumType.STRING)
    private Status status;

    @PostPersist
    public void onPostPersist() {}

    public static EnrollmentRepository repository() {
        EnrollmentRepository enrollmentRepository = EnrollmentApplication.applicationContext.getBean(
            EnrollmentRepository.class
        );
        return enrollmentRepository;
    }
}
