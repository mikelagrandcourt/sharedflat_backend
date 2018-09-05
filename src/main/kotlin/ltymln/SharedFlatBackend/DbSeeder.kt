package ltymln.SharedFlatBackend

import ltymln.SharedFlatBackend.model.Product
import ltymln.SharedFlatBackend.repository.ProductRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DbSeeder(val productRepository: ProductRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        this.productRepository.deleteAll()

        val product1 = Product("Klopapier", 10.3, "Haushalt")
        val product2 = Product("Benzin", 20.0, "Haushalt")
        val product3 = Product("Gurken", 5.5, "Spielzeug")

        this.productRepository.save(product1)
        this.productRepository.save(product2)
        this.productRepository.save(product3)

        println("--- Database has been initialized")
    }
}