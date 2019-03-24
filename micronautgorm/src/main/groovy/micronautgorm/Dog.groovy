package micronautgorm

import grails.gorm.annotation.Entity

@Entity
class Dog {
    String name
    String breed

    static mapping = {
        // disabling optimistic locking to be consistent
        // with the schema the other imnpls are using
        version false
    }
}
