package dk.BrugtMarket.repository;

import dk.BrugtMarket.domain.Ad_User;
import dk.BrugtMarket.domain.City;
import dk.BrugtMarket.domain.Id;
import dk.BrugtMarket.repository.entity.CityPO;
import dk.BrugtMarket.repository.entitymanager.DemoEntityManager;
import dk.BrugtMarket.repository.interfaces.IRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Dependent
public class CityRepository implements IRepository<City> {

    private final EntityManager entityManager;
    private final Mapper mapper;

    @Inject
    public CityRepository(DemoEntityManager entityManager, Mapper mapper) {
        this.entityManager = entityManager.getEntityManager();
        this.mapper = mapper;
    }

    @Override
    public void remove(Id id) {
        CityPO cityToRemove = entityManager.find(CityPO.class, id);
        entityManager.remove(cityToRemove);
    }

    @Override
    public List<City> getAll() {
        return mapper.mapCities(
                entityManager.createNamedQuery(
                        CityPO.FIND_ALL, CityPO.class
                ).getResultList());
    }

    @Override
    public void insert(City entity) {
        CityPO newCity = mapper.mapCityPO(entity);
        this.entityManager.persist(newCity);
    }

    @Override
    public City getById(Id id) {
        City foundCity = mapper.mapCity(entityManager.find(CityPO.class, id));
        return foundCity;
    }
}
