package org.sysco.cake;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by chamarap on 3/26/17.
 */
@RestController
public class RecipyController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/recipy")
    public Recipy greeting(@RequestParam(value="name", defaultValue="Fruit Cake") String name) {
        return new Recipy(counter.incrementAndGet(), String.format(template, name));
    }
}
