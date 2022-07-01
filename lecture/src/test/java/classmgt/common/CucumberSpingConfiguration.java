package classmgt.common;

import classmgt.ClassApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ClassApplication.class })
public class CucumberSpingConfiguration {}
