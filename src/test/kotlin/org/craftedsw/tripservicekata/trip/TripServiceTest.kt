package org.craftedsw.tripservicekata.trip

import io.kotlintest.KTestJUnitRunner
import io.kotlintest.specs.WordSpec
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException
import org.craftedsw.tripservicekata.user.User
import org.junit.runner.RunWith

@RunWith(KTestJUnitRunner::class)
class TripServiceTest : WordSpec() {
    init {
        "getTripsByUser " should {
            "throw exception for no loggedUser user " {
                shouldThrow<UserNotLoggedInException> { TripService(null).getTripsByUser(User()) }
            }
            "return empty list" should {
                val trips = listOf(Trip(), Trip())
                val (logged, other, dao, t) = data_fixture(trips)
                "be true for user without friends" {
                    t.getTripsByUser(User()).isEmpty() shouldBe true
                }
                "be true also if loggedUser user has a friend" {
                    logged.addFriend(other)

                    t.getTripsByUser(other) should beEmpty()
                    dao.last shouldBe null
                }
                "be true also if other have some friend but not loggedUser user" {
                    other.addFriend(User())
                    other.addFriend(User())

                    t.getTripsByUser(other) should beEmpty()
                    dao.last shouldBe null
                }
            }
            "return given trip list if loggedUser user is a friend of other" {
                val trips = listOf(Trip(), Trip())
                val (logged, other, dao, t) = data_fixture(trips)

                other.addFriend(logged)

                trips shouldBe t.getTripsByUser(other)
                dao.last shouldBe other
            }
        }
    }

    private fun data_fixture(trips: List<Trip>): TestFixture {
        val logged = User()
        val other = User()
        val dao = TripDaoFake(trips)
        val t = TripService(logged, dao)
        return TestFixture(logged, other, dao, t)
    }
}

data class TestFixture(val logged: User, val other: User, val dao: TripDaoFake, val service: TripService)

class TripDaoFake(val trips: List<Trip>) : TripsResolver {
    var last: User? = null

    override fun findTripsByUser(user: User): List<Trip> {
        last = user
        return trips
    }

}