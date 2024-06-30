package academetrics.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BatchManagementController {

    @GetMapping("/batches")
    public  String batch() { return "batch";}

}
