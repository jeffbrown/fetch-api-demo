package micronautjpa;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

@Singleton
@Transactional
public class DogService {

    private EntityManager entityManager;

    public DogService(@CurrentSession EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Dog save(String name, String breed) {
        Dog dog = new Dog(name, breed);
        entityManager.persist(dog);
        return dog;
    }

    public Dog update(Serializable id, String breed, String name) {
        Dog dog = entityManager.find(Dog.class, id);
        dog.setName(name);
        dog.setBreed(breed);
        entityManager.persist(dog);
        return dog;
    }

    @Transactional(readOnly = true)
    public List<Dog> list() {
        String qlString = "SELECT d FROM Dog d";
        TypedQuery<Dog> query = entityManager.createQuery(qlString, Dog.class);
        return query.getResultList();
    }

    public void delete(Long id) {
        entityManager.remove(entityManager.find(Dog.class, id));
        String qlString = "Delete from Dog where id = :id";
        Query query = entityManager.createQuery(qlString);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
