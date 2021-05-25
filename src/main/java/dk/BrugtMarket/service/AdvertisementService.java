package dk.BrugtMarket.service;

import dk.BrugtMarket.domain.Ad_User;
import dk.BrugtMarket.domain.Advertisement;
import dk.BrugtMarket.domain.Id;
import dk.BrugtMarket.repository.AdvertisementRepository;
import dk.BrugtMarket.resource.dto.CreateAdvertisementDTO;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional(rollbackOn = Exception.class)
@Dependent
public class AdvertisementService {

    private final AdvertisementRepository repository;

    @Inject
    public AdvertisementService(AdvertisementRepository repository) { this.repository = repository; }

    public void remove(Id id) { repository.remove(id); }
    public List<Advertisement> getAllAdvertisements() { return repository.getAll(); }
    public Advertisement getById(Id id) { return repository.getById(id); }
    public List<Advertisement> getByQId(Id id) { return repository.getByQId(id); }
    //public List<Advertisement> getByGId(Id id) { return repository.getByGId(id); }
    //public List<Advertisement> getAllCategories() { return repository.getAllCategories(); }
    public Ad_User insertAdvertisement(Id id, CreateAdvertisementDTO advertisement) {
        return repository.insertAdvertisement(
                id,
                advertisement);
    }
}
