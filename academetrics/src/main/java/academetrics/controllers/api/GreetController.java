package academetrics.controllers.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GreetController {
    @PostMapping("/greeting")
    String Greet(@RequestParam("inputText") String name){
        System.out.println("I was invoked");
        return "<h1 id='responseHeading' class='text-3xl font-bold underline'> Hello "+name+"! </h1>";
    }

}
