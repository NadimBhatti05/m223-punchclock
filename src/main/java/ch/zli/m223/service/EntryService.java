package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Entry;

@ApplicationScoped
public class EntryService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Entry createEntry(Entry entry) {
        entityManager.persist(entry);
        return entry;
    }

    public List<Entry> findAll() {
        var query = entityManager.createQuery("FROM Entry", Entry.class);
        return query.getResultList();
    }

    @Transactional
    public void delete(int id){
        var query = entityManager.createQuery("FROM Entry WHERE id="+id, Entry.class);
        var entry = query.getSingleResult();
        entityManager.remove(entry);
    }

    @Transactional
    public void edit(Entry entry, Long id){
        var entryToEdit = entityManager.find(Entry.class, id);
        entryToEdit.setCheckIn(entry.getCheckIn());
        entryToEdit.setCheckOut(entry.getCheckOut());
        entityManager.merge(entryToEdit);
    }
}