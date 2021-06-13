package dk.BrugtMarket.repository;

import dk.BrugtMarket.domain.Ad_User;
import dk.BrugtMarket.domain.City;
import dk.BrugtMarket.domain.Id;
import dk.BrugtMarket.repository.entity.Ad_UserPO;
import dk.BrugtMarket.repository.entitymanager.DemoEntityManager;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Dependent
public class Mundtlig_Eksamen_Sporgsmaal_7 {

    //Transient
    //Ad_User student = new Ad_User("værdier");

    //Persistent
    private final EntityManager entityManager;
    private final Mapper mapper;
    @Inject
    public Mundtlig_Eksamen_Sporgsmaal_7(DemoEntityManager entityManager, Mapper mapper) {
        this.entityManager = entityManager.getEntityManager();
        this.mapper = mapper;
    }
    public void insert(Ad_User user) {
        Ad_UserPO newUser = new Ad_UserPO(
                user.getFirst().getName(),
                user.getLast().getName(),
                user.getCompany().getName(),
                user.getPhone().getNumber(),
                user.getPhc().getCode(),
                user.getEmail().getEmail(),
                mapper.mapCityPO(user.getCity()),
                user.getCreation().getDate(),
                user.getType().getType()
        );
        entityManager.persist(newUser);
    }

    //Removed
    public void remove(Id id) {
        Ad_UserPO userToRemove = entityManager.find(Ad_UserPO.class, id);
        entityManager.remove(userToRemove);
    }

    //ManyToMany
    @ManyToMany
    @JoinTable(
            name = "BrugerCity",
            joinColumns = @JoinColumn(name = "BrugerID"),
            inverseJoinColumns = @JoinColumn(name = "ByZipCode")
    )
    Set<Ad_User> brugerBy;
    @ManyToMany(mappedBy = "brugerBy")
    Set<City> byBruger;


}
