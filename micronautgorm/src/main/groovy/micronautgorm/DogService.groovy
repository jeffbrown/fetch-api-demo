package micronautgorm

import grails.gorm.services.Service

@Service(Dog)
interface DogService {
    Dog save(String name, String breed)

    Dog update(Serializable id, String breed, String name)

    List<Dog> list()

    void delete(Long id)
}
