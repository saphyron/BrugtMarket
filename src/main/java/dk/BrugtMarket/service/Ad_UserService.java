package dk.BrugtMarket.service;

import dk.BrugtMarket.domain.Ad_User;
import dk.BrugtMarket.domain.Advertisement;
import dk.BrugtMarket.domain.Id;
import dk.BrugtMarket.repository.AdUserRepository;
import dk.BrugtMarket.service.request.AdvertisementRequest;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional(rollbackOn = Exception.class)
@Dependent
public class Ad_UserService {

    private final AdUserRepository repository;

    @Inject
    public Ad_UserService(AdUserRepository repository) { this.repository = repository; }

    public void remove(Id id) { repository.remove(id); }
    public List<Ad_User> getAllUsers() { return repository.getAll(); }
    public void insertUser(Ad_User adUser) { repository.insert(adUser); }
    public Ad_User getById(Id id) { return repository.getById(id); }
    public List<Ad_User> getByQId(Id id) { return repository.getByQId(id); }
    public Advertisement receiveAdvertisement(AdvertisementRequest advertisementRequest){
        Ad_User adUser = repository.getById(advertisementRequest.getAdvertisementId());
        return adUser.findAdvertisement(advertisementRequest.getUserId());
    }

}
