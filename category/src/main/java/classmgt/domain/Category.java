package classmgt.domain;

import classmgt.CategoryApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Category_table")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    public static CategoryRepository repository() {
        CategoryRepository categoryRepository = CategoryApplication.applicationContext.getBean(
            CategoryRepository.class
        );
        return categoryRepository;
    }
}
