package netflix.springgraphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringGraphQlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringGraphQlApplication.class, args);
    }

    @RestController
    static final class MyContorller {
        @GetMapping("/")
        String hello(){
            return "hello universe!\n";
        }
    }

}
