package com.study.decorator.spring;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class DecoratorController {

    @PostMapping
    public Map<Object, Object> origin(@RequestBody Map<Object, Object> json) {
        return json;
    }
}
