package sampleshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ThymeleafController {

    @GetMapping("/ui/**/{path:.*}")
    public String uiPage(@PathVariable String path) {
        return path;
    }

    @GetMapping("/home.html")
    public String home() {
        return "home.html";
    }
}
