package classmgt.infra;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import classmgt.domain.ClassRepository;

@RestController
@RequestMapping(value = "/classes")
@Transactional
public class ClassController {

    @Autowired
    ClassRepository classRepository;
    // keep
}
