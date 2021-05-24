package dk.BrugtMarket.repository;

import dk.BrugtMarket.domain.Ad_User;
import dk.BrugtMarket.domain.Id;
import dk.BrugtMarket.repository.entity.Ad_UserPO;
import dk.BrugtMarket.repository.interfaces.IRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Dependent
public class AdUserRepository implements IRepository<Ad_User> {

    private final EntityManager entityManager;
    private final Mapper mapper;

    @Inject
    public AdUserRepository(EntityManager entityManager, Mapper mapper) {
        this.entityManager = entityManager;
        this.mapper = mapper;
    }

    @Override
    public void remove(Id id) {

    }

    @Override
    public List<Ad_User> getAll() {
        return mapper.mapUsers(entityManager.createNamedQuery(Ad_UserPO.FIND_ALL, Ad_UserPO.class).getResultList());
    }

    @Override
    public void insert(Ad_User user) {
        Ad_UserPO newUser = new Ad_UserPO(
                user.getFirst().getName(),
                user.getLast().getName(),
                user.getCompany().getName(),
                user.getPhone().getNumber(),
                user.getPhc().getCode(),
                user.getEmail().getEmail(),
                user.getCreation().getDate(),
                mapper.mapCityPO(user.getCity()),
                user.getType().getType()
        );
        user.getAdvertisements().forEach(a-> newUser.addAdvertisement(mapper.mapAdvertisementPO(a)));
        entityManager.persist(newUser);
        newUser.getAdvertisements().forEach(entityManager::persist);
    }

    @Override
    public Ad_User getById(Id id) {
        Ad_User foundUser = mapper.mapUser(entityManager.find(Ad_UserPO.class, id));
        return foundUser;
    }

    public List<Ad_User> getByQId(Id id) {
        try {
            return mapper.mapUsers(entityManager.createNamedQuery(Ad_UserPO.FIND_BY_QID, Ad_UserPO.class)
                        .setParameter(Ad_UserPO.QID_PARAMETER, id)
                        .getResultList());
        } catch (NoResultException e) {
            return null;
        }
    }

}