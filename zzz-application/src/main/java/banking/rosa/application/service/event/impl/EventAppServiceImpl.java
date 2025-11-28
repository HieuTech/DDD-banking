package banking.rosa.application.service.event.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import banking.rosa.application.service.event.EventAppService;
import banking.rosa.service.HiDomainService;

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
