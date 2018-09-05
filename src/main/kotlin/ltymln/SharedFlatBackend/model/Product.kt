package ltymln.SharedFlatBackend.model

import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
class Product(
        val name: String,
        val price: Double,
        @Column(name = "category", columnDefinition = "VARCHAR(50) default NULL")
        val category: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    constructor(): this("",0.0, "")
}