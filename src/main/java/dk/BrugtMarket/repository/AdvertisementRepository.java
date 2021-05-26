package dk.BrugtMarket.repository;

import dk.BrugtMarket.domain.Ad_User;
import dk.BrugtMarket.domain.Advertisement;
import dk.BrugtMarket.domain.Category;
import dk.BrugtMarket.domain.Id;
import dk.BrugtMarket.repository.entity.Ad_UserPO;
import dk.BrugtMarket.repository.entity.AdvertisementPO;
import dk.BrugtMarket.repository.entity.CategoryPO;
import dk.BrugtMarket.repository.entitymanager.DemoEntityManager;
import dk.BrugtMarket.repository.interfaces.IRepository;
import dk.BrugtMarket.resource.dto.CreateAdvertisementDTO;
import dk.BrugtMarket.resource.dto.CreateCategoryDTO;

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
    public AdvertisementRepository(DemoEntityManager entityManager, Mapper mapper) {
        this.entityManager = entityManager.getEntityManager();
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
        //kan fjernes
    }

    @Override
    public Advertisement getById(Id id) {
        Advertisement foundAdvertisement = mapper.mapAdvertisement(entityManager.find(AdvertisementPO.class, id.getId()));
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

    /*public List<Advertisement> getByCategory(Id id) {
        try {
            return mapper.mapAdvertisements(entityManager.createNamedQuery(AdvertisementPO.FIND_BY_CATEGORY, AdvertisementPO.class)
                        .setParameter(AdvertisementPO.GID_PARAMETER, id)
                        .getResultList());
        } catch (NoResultException e) {
            return null;
        }
    }*/

    public Ad_User insertAdvertisement(Id id, CreateAdvertisementDTO advertisement) {
        Ad_UserPO adUser = entityManager.find(Ad_UserPO.class, id.getId());
        CategoryPO categoryPO = entityManager.find(CategoryPO.class, advertisement.getCategory());
        AdvertisementPO advertisement1 = new AdvertisementPO(
                categoryPO,
                advertisement.getType(),
                advertisement.getHeadline(),
                advertisement.getText(),
                advertisement.getPrice(),
                advertisement.getCreation()
        );
        adUser.addAdvertisement(advertisement1);
        entityManager.persist(advertisement1);
        return mapper.mapUser(adUser);
    }


}
