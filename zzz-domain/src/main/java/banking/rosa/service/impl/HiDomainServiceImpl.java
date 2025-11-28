package banking.rosa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import banking.rosa.repository.HiDomainRepository;
import banking.rosa.service.HiDomainService;

@Service
public class HiDomainServiceImpl implements HiDomainService {

    @Autowired
    private HiDomainRepository hiDomainRepository;

    @Override
    public String sayHi(String who) {

        return hiDomainRepository.sayHi(who);
    }
}
