package org.craftedsw.tripservicekata.trip

import org.craftedsw.tripservicekata.user.User

interface TripsResolver {
    fun findTripsByUser(user: User): List<Trip>
}