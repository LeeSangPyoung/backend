package classmgt.common;

import io.cucumber.spring.CucumberContextConfiguration;
import lecturemgt.ClassApplication;

import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ClassApplication.class })
public class CucumberSpingConfiguration {}
