package gar.osh.slmtest;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class MonitorController {

    @GetMapping(value = "/")
    EntityModel<Response> getSate() throws NoHandlerFoundException {
        return EntityModel.of(new Response("Everything is fine!"));
    }

}
