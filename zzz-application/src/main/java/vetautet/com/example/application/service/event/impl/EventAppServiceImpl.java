package vetautet.com.example.application.service.event.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vetautet.com.example.application.service.event.EventAppService;
import vetautet.com.example.service.HiDomainService;

@Service
public class EventAppServiceImpl implements EventAppService {
    //Call domain service

    @Autowired
    private HiDomainService hiDomainService;

    @Override
    public String sayHi(String who) {
        return hiDomainService.sayHi(who);
    }


}
