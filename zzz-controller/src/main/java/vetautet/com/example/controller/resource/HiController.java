package vetautet.com.example.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vetautet.com.example.application.service.event.EventAppService;
import vetautet.com.example.application.service.event.impl.EventAppServiceImpl;

@RestController
@RequestMapping("/hello")
public class HiController {

    @Autowired
    private EventAppService eventAppService;
    @GetMapping("/v1/xinchao")
    String Hello(){

        return eventAppService.sayHi("hello hieu");
    }
}
