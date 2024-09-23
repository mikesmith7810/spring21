package com.example;

import com.example.model.PersonalDetails;
import com.example.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(final HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/")
    public String index(@RequestBody final PersonalDetails personalDetails) {

        return helloService.giveAnswer(personalDetails.name());
    }

}
