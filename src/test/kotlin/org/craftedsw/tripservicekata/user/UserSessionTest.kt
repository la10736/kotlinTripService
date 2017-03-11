package org.craftedsw.tripservicekata.user

import io.kotlintest.KTestJUnitRunner
import io.kotlintest.specs.WordSpec
import org.craftedsw.tripservicekata.exception.CollaboratorCallException
import org.junit.runner.RunWith

@RunWith(KTestJUnitRunner::class)
class UserSessionTest : WordSpec() {
    init {
        "throw exception for loggedUser user " {
            shouldThrow<CollaboratorCallException> {
                UserSession.instance.loggedUser
            }
        }
    }
}