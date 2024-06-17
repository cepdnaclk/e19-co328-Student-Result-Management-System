package academetrics.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetController {
    @GetMapping("/greeting")
    String Greet(@RequestParam String name){
        System.out.println("I was invoked");
        return "Hello " + name;
    }

}
