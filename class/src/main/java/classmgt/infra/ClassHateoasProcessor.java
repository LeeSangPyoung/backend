package classmgt.infra;

import classmgt.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ClassHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Class>> {

    @Override
    public EntityModel<Class> process(EntityModel<Class> model) {
        return model;
    }
}
