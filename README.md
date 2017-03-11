# Trip Service Cover Game

Ma mia soluzione Kotlin del [Trip Service Kate][0] di Sandro Mancuso.

L'idea era quella di esplorare `kotlintest` e la sintassi Kotlin. Il risultato finale mi ha sodisfatto
molto.

In particolare:

1. Nei test di [`User`][1] ho sperimentato la struttura gerarchica di kotlintest
2. Nella classe [`User`][2] ho visto come usare `infix` per costruire linguaggi come naturali `bob isFriendOf jane`
3. Il risultato della classe [`TripService`][3] e' asciutto e espressivo

Le note originali del testo sono in [tripservice](tripservice.md).

[0]: https://github.com/sandromancuso/trip-service-kata
[1]: src/test/kotlin/org/craftedsw/tripservicekata/user/UserTest.kt
[2]: src/main/kotlin/org/craftedsw/tripservicekata/user/User.kt
[3]: src/main/kotlin/org/craftedsw/tripservicekata/trip/TripService.kt