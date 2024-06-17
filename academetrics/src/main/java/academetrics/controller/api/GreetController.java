package academetrics.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class GreetController {
    @PostMapping(path = "/greet")
    String name(Map<String, Object> model, @RequestParam String name) {
        model.put("greeting", "Hello " + name);
        model.put("name", name);
        return "greet";
    }

}
