package org.craftedsw.tripservicekata.trip

import io.kotlintest.KTestJUnitRunner
import io.kotlintest.specs.WordSpec
import org.craftedsw.tripservicekata.exception.CollaboratorCallException
import org.craftedsw.tripservicekata.user.User
import org.junit.runner.RunWith

@RunWith(KTestJUnitRunner::class)
class TripDAOTest: WordSpec() {
    init {
        "findTripsByUser" should {
            "throw exception" {
                shouldThrow<CollaboratorCallException> {
                    TripDAO().findTripsByUser(User())
                }
            }
        }
    }
}
