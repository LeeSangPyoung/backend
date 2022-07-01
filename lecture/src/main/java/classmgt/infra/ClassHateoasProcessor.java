package classmgt.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

import classmgt.domain.Clazz;

@Component
public class ClassHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Clazz>> {

    @Override
    public EntityModel<Clazz> process(EntityModel<Clazz> model) {
        return model;
    }
}
