package org.craftedsw.tripservicekata.trip

import org.craftedsw.tripservicekata.exception.CollaboratorCallException
import org.craftedsw.tripservicekata.user.User

class TripDAO : TripsResolver {

    private companion object {
        @Suppress("UNUSED_PARAMETER")
        @JvmStatic fun _findTripsByUser(user: User): List<Trip> {
            throw CollaboratorCallException("TripDAO should not be invoked on an unit test.")
        }
    }

    override fun findTripsByUser(user: User): List<Trip> = _findTripsByUser(user)

}
