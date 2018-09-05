package ltymln.SharedFlatBackend.repository

import ltymln.SharedFlatBackend.model.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : CrudRepository<Product, Long> {

}