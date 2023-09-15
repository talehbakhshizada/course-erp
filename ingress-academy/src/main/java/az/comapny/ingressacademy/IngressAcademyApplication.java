package az.comapny.ingressacademy;

import az.comapny.ingressacademy.repository.CourseRepository;
import az.comapny.ingressacademy.repository.StudentRepository;
import az.comapny.ingressacademy.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class IngressAcademyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(IngressAcademyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
