package dk.BrugtMarket.service;

import dk.BrugtMarket.domain.City;
import dk.BrugtMarket.domain.Id;
import dk.BrugtMarket.repository.CityRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional(rollbackOn = Exception.class)
@Dependent
public class CityService {

    private final CityRepository repository;

    @Inject
    public CityService(CityRepository repository) { this.repository = repository; }

    public void remove(Id id) { repository.remove(id); }
    public List<City> getAllCities() { return repository.getAll(); }
    public void insert(City adUser) { repository.insert(adUser); }
    public City getById(Id id) { return repository.getById(id); }
}
