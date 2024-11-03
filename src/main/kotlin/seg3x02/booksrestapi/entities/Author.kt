package seg3x02.booksrestapi.entities

import jakarta.persistence.*

@Entity
class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    var firstName: String = ""
    var lastName: String = ""

    constructor()
    constructor(firstName: String, lastName: String) {
        this.firstName = firstName
        this.lastName = lastName
    }

    @ManyToMany
    var books: MutableList<Book> = ArrayList()

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var bio: Bio = Bio()

    override fun toString(): String {
        return "Author{id: $id, First Name: $firstName, Last Name: $lastName}"
    }
}
