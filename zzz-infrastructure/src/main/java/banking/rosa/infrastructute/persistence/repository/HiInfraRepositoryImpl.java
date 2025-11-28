package banking.rosa.infrastructute.persistence.repository;


import org.springframework.stereotype.Repository;
import banking.rosa.repository.HiDomainRepository;

@Repository
public class HiInfraRepositoryImpl implements HiDomainRepository {
    @Override
    public String sayHi(String who) {
        return "Infrastructure" + who;
    }
}
