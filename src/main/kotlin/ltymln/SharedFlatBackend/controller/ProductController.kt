package ltymln.SharedFlatBackend.controller

import ltymln.SharedFlatBackend.model.Product
import ltymln.SharedFlatBackend.repository.ProductRepository
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
class ProductController(val productRepository: ProductRepository) {

    @GetMapping("/all")
    fun getAll(): MutableIterable<Product> = this.productRepository.findAll()

    @PostMapping("/create")
    fun create(@RequestBody product: Product): Product {
        return this.productRepository.save(product);
    }
}