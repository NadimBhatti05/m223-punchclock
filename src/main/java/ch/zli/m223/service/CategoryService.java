package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Category;

@ApplicationScoped
public class CategoryService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Category createTag(Category category) {
        entityManager.persist(category);
        return category;
    }

    public List<Category> findAll() {
        var query = entityManager.createQuery("FROM Tag", Category.class);
        return query.getResultList();
    }

    @Transactional
    public void delete(int id){
        var query = entityManager.createQuery("FROM Category WHERE id="+id, Category.class);
        var category = query.getSingleResult();
        entityManager.remove(category);
    }

    @Transactional
    public void edit(Category category, Long id){
        var categoryToEdit = entityManager.find(Category.class, id);
        categoryToEdit.setTitle(category.getTitle());
        entityManager.merge(categoryToEdit);
    }
}