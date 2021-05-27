package dk.BrugtMarket.service;

import dk.BrugtMarket.domain.Category;
import dk.BrugtMarket.domain.Id;
import dk.BrugtMarket.repository.CategoryRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional(rollbackOn = Exception.class)
@Dependent
public class CategoryService {

    private final CategoryRepository repository;

    @Inject
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public void remove(Id id) {repository.remove(id);}
    public List<Category> getCategories() { return repository.getAll();}
    public List<String> getCategoryNames() { return repository.getCategoryNames(); }
    public void insert(Category category) {repository.insert(category);}
    public Category getById(Id id) {return repository.getById(id);}
    public List<Category> getCategoryById(String id) { return repository.getByQId(id);}
    public Map<String, Integer> getCountCategory() {
        return repository.getAll().stream().collect(Collectors.toMap(Category::getCategory, c-> c.getAdvertisement().size()));
    }
}
