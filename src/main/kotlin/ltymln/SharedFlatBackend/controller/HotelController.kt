package ltymln.SharedFlatBackend.controller

import ltymln.SharedFlatBackend.model.CheckInRequest
import ltymln.SharedFlatBackend.model.Hotel
import ltymln.SharedFlatBackend.repository.HotelRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/hotels")
class HotelController(val hotelRepository: HotelRepository) {

    @GetMapping("/all")
    fun all(): MutableIterable<Hotel> = this.hotelRepository.findAll()

    @GetMapping("/{name}")
    fun byName(@PathVariable(value = "name") name: String): List<Hotel> {
        return this.hotelRepository.findByName(name)
    }

    @PostMapping("/checkIn")
    fun checkIn(@RequestBody checkInRequest: CheckInRequest) {
        val hotel = this.hotelRepository.findByName(checkInRequest.hotelName).get(0)
        hotel.checkIn(checkInRequest.nbGuests)
        this.hotelRepository.save(hotel)
    }

}