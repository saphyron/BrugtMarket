package dk.BrugtMarket.repository;

import dk.BrugtMarket.domain.Advertisement;
import dk.BrugtMarket.domain.Id;
import dk.BrugtMarket.repository.entity.AdvertisementPO;
import dk.BrugtMarket.repository.interfaces.IRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Dependent
public class AdvertisementRepository implements IRepository<Advertisement> {

    private final EntityManager entityManager;
    private final Mapper mapper;

    @Inject
    public AdvertisementRepository(EntityManager entityManager, Mapper mapper) {
        this.entityManager = entityManager;
        this.mapper = mapper;
    }

    @Override
    public void remove(Id id) {
        AdvertisementPO advertisementToRemove = entityManager.find(AdvertisementPO.class, id);
        entityManager.remove(advertisementToRemove);
    }

    @Override
    public List<Advertisement> getAll() {
        return mapper.mapAdvertisements(entityManager.createNamedQuery(AdvertisementPO.FIND_ALL, AdvertisementPO.class).getResultList());
    }

    @Override
    public void insert(Advertisement entity) {
        AdvertisementPO newAdvertisement = mapper.mapAdvertisementPO(entity);
        this.entityManager.persist(newAdvertisement);
    }

    @Override
    public Advertisement getById(Id id) {
        Advertisement foundAdvertisement = mapper.mapAdvertisement(entityManager.find(AdvertisementPO.class, id));
        return foundAdvertisement;
    }

    public List<Advertisement> getByQId(Id id) {
        try {
            return mapper.mapAdvertisements(entityManager.createNamedQuery(AdvertisementPO.FIND_BY_QID, AdvertisementPO.class)
                        .setParameter(AdvertisementPO.QID_PARAMETER, id)
                        .getResultList());
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Advertisement> getByGId(Id id) {
        try {
            return mapper.mapAdvertisements(entityManager.createNamedQuery(AdvertisementPO.FIND_BY_CATEGORY, AdvertisementPO.class)
                        .setParameter(AdvertisementPO.GID_PARAMETER, id)
                        .getResultList());
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Advertisement> getAllCategories() {
        try {
            return mapper.mapAdvertisement(entityManager.createNamedQuery(AdvertisementPO.FIND_ALL_CATEGORIES, AdvertisementPO.class).getResultList());
        } catch (NoResultException e) {
            return null;
        }
    }
}
