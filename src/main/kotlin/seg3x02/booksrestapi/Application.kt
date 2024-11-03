package seg3x02.booksrestapi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import seg3x02.booksrestapi.entities.Author
import seg3x02.booksrestapi.repository.AuthorRepository

@SpringBootApplication
class Application @Autowired constructor(
	private val authorRepository: AuthorRepository): CommandLineRunner {
	override fun run(vararg args: String?) {
		authorRepository.saveAll(listOf(
			Author("John", "Doe"),
			Author("Michael", "Smith"),
			Author("Jane", "Smith"),
			Author("Mohamed", "Abdi"),
			Author("Ali", "Ahmed")
		))
		println("Author ids are: " + authorRepository.findAll().map { i -> i.id })
	}
}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
