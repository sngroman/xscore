package sg.com.fairprice.fpon.xscore.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("hello");
    }
}
