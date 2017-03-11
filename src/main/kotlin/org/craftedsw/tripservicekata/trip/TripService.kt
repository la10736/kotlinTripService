package org.craftedsw.tripservicekata.trip

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException
import org.craftedsw.tripservicekata.user.User

class TripService(val loggedUser: User?, val tripsEngine: TripsResolver = TripDAO()) {

    val logged: User = loggedUser ?: throw UserNotLoggedInException()

    fun getTripsByUser(user: User): List<Trip> = if (logged isFriendOf user) {
            findTripsByUser(user)
        } else {
            noTrips()
        }

    private fun findTripsByUser(user: User): List<Trip> = tripsEngine.findTripsByUser(user)
    private fun noTrips(): List<Trip> = listOf()
}
