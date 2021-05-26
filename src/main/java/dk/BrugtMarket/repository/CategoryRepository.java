package dk.BrugtMarket.repository;

import dk.BrugtMarket.domain.Category;
import dk.BrugtMarket.domain.Id;
import dk.BrugtMarket.repository.entity.CategoryPO;
import dk.BrugtMarket.repository.entitymanager.DemoEntityManager;
import dk.BrugtMarket.repository.interfaces.IRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class CategoryRepository implements IRepository<Category> {

    private final EntityManager entityManager;
    private final Mapper mapper;

    @Inject
    public CategoryRepository(DemoEntityManager entityManager, Mapper mapper) {
        this.entityManager = entityManager.getEntityManager();
        this.mapper = mapper;
    }

    @Override
    public void remove(Id id) {
        CategoryPO categoryToRemove = entityManager.find(CategoryPO.class, id);
        entityManager.remove(categoryToRemove);
    }

    @Override
    public List<Category> getAll() {
        return mapper.mapCategories(entityManager.createNamedQuery(CategoryPO.FIND_CATEGORIES,CategoryPO.class).getResultList());
    }

    public List<String> getCategoryNames() {
        return entityManager.createNamedQuery(CategoryPO.FIND_CATEGORIES,CategoryPO.class).getResultList().stream().map(CategoryPO::getCategory).collect(Collectors.toList());
    }

    @Override
    public void insert(Category entity) {
        CategoryPO newCategory = new CategoryPO(
                entity.getCategory()
        );
        entityManager.persist(newCategory);
    }

    @Override
    public Category getById(Id id) {
        return null;
    }


}
