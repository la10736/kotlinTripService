package org.craftedsw.tripservicekata.user

import io.kotlintest.KTestJUnitRunner
import io.kotlintest.specs.WordSpec
import org.craftedsw.tripservicekata.trip.Trip
import org.junit.runner.RunWith

@RunWith(KTestJUnitRunner::class)
class UserTest : WordSpec() {
    init {
        "new user" should {
            val u = User()
            "have empty friend list" {
                u.friends should beEmpty()
            }
            "add friends" should {
                val (o0, o1) = Pair(User(), User())

                "add the first one" {
                    u.addFriend(o0)

                    u.friends should contain(o0)
                    (o1 !in u.friends) shouldBe true
                }

                "add the second without losing the first"{
                    u.addFriend(o1)

                    u.friends should contain(o1)
                    u.friends should contain(o0)
                }
            }
            "have empty trip list" {
                u.trips should beEmpty()
            }
            "add some trips"  should {
                val (t0, t1) = Pair(Trip(), Trip())

                "add the first one"{
                    u.addTrip(t0)

                    u.trips should contain(t0)
                    (t1 !in u.trips) shouldBe true
                }

                "add the second one without losing the first one" {
                    u.addTrip(t1)

                    u.trips should contain(t1)
                    u.trips should contain(t0)
                }
            }
        }
        "you are a friend of mine" should {
            val (me, you) = Pair(User(), User())

            me.addFriend(you)

            "be true" {
                you isFriendOf me shouldBe true
            }
            "not imply that I'm friend of yours" {
                me isFriendOf you shouldBe false
            }
        }
    }

}
