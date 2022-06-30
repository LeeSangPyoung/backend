package classmgt.domain;

import classmgt.ClassApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Class_table")
@Data
public class Clazz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private Integer minEnrollment;

    private Integer maxEnrollment;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Embedded
    @AttributeOverride(
        name = "id",
        column = @Column(name = "categoryIdId", nullable = true)
    )
    private CategoryId categoryId;

    public static ClassRepository repository() {
        ClassRepository classRepository = ClassApplication.applicationContext.getBean(
            ClassRepository.class
        );
        return classRepository;
    }
}
