package micronautgorm

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller('/dog')
class DogController {

    private DogService dogService

    DogController(DogService dogService) {
        this.dogService = dogService
    }

    @Post('/')
    Dog create(String breed,
               String name) {
        dogService.save breed, name
    }

    @Put('/{id}')
    Dog update(Long id,
               String breed,
               String name) {
        dogService.update id, breed, name
    }

    @Get('/')
    List<Dog> list() {
        dogService.list()
    }

    @Delete('/{id}')
    HttpResponse delete(Long id) {
        dogService.delete id
        HttpResponse.ok()
    }
}
