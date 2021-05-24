package dk.BrugtMarket.repository;

import dk.BrugtMarket.domain.Ad_User;
import dk.BrugtMarket.domain.Id;
import dk.BrugtMarket.repository.interfaces.IRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class AdvertisementRepository implements IRepository<Ad_User> {

    private final EntityManager entityManager;
    private final Mapper mapper;

    @Inject
    public AdvertisementRepository(EntityManager entityManager, Mapper mapper) {
        this.entityManager = entityManager;
        this.mapper = mapper;
    }

    @Override
    public void remove(Id id) {

    }

    @Override
    public List<Ad_User> getAll() {
        return null;
    }

    @Override
    public void insert(Ad_User entity) {

    }

    @Override
    public Ad_User getById(Id id) {
        return null;
    }
}
