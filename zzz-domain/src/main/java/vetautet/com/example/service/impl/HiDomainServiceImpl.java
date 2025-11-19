package vetautet.com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vetautet.com.example.repository.HiDomainRepository;
import vetautet.com.example.service.HiDomainService;

@Service
public class HiDomainServiceImpl implements HiDomainService {

    @Autowired
    private HiDomainRepository hiDomainRepository;

    @Override
    public String sayHi(String who) {

        return hiDomainRepository.sayHi(who);
    }
}
