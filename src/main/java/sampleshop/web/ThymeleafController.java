package sampleshop.web;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ThymeleafController {

    @GetMapping("/ui/**/{path:.*}")
    public String uiPage(@PathVariable String path) {
        return path;
    }

    @GetMapping("/display/**")
    public String home() {
        return "display.html";
    }
    
    @GetMapping("/order/**")
    public String order() {
        return "order.html";
    }
    
    @GetMapping("/mypage/**")
    public String mypage() {
        return "mypage.html";
    }
    
    @GetMapping("/images/sample/goods/**")
    public ResponseEntity<Resource> goodsImage() throws IOException {
    	Resource resource = new ClassPathResource("/static/images/sample/goods-main.jpg");
    	long fileSize = resource.getFile().length();
//        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders header = new HttpHeaders();
//        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=img.jpg");
//        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
//        header.add("Pragma", "no-cache");
//        header.add("Expires", "0");
    	
        return ResponseEntity.ok()
                .headers(header)
                .contentLength(fileSize)
                .contentType(org.springframework.http.MediaType.IMAGE_JPEG)
                .body(resource);
    }
}


