package ltymln.SharedFlatBackend.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Hotel(val name: String, val classification: Int, val nbRooms: Int) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    var nbFreeRomms: Int = this.nbRooms

    constructor(): this("", 0, 0)

    fun checkIn(nbGuests: Int) {
        if(this.nbFreeRomms > nbGuests) {
            this.nbFreeRomms -= nbGuests
        }
    }

    fun checkOut(nbGuests: Int) {
        this.nbFreeRomms += nbGuests
    }
}