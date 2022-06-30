package classmgt.domain;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import classmgt.ClassApplication;
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
    private List<CategoryId> categoryId;

    public static ClassRepository repository() {
        ClassRepository classRepository = ClassApplication.applicationContext.getBean(ClassRepository.class);
        return classRepository;
    }
}
