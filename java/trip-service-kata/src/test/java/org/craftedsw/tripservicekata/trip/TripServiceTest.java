package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.craftedsw.tripservicekata.user.User.UserBuilder.anUser;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TripServiceTest {

    private static User loggedInUser;
    private static List<Trip> trips;

    @Test
    public void shouldThrowExceptionWhenUserIsNotLoggedIn() {
        loggedInUser = null;
        assertThrows(UserNotLoggedInException.class, () -> {
            new TripService(createFakeTripService(loggedInUser, trips), createFakeLoggedInUserProvider(loggedInUser)).getTripsByUser(null);
        });
    }

    @Test
    void shouldReturnEmptryTripsListWhenUserIsLoggedInButIsNotFriends() {
        User laExDeEdu = new User();
        loggedInUser = new User(); //representa a Edu
        List<Trip> tripsDeLaExDeEdu = new TripService(createFakeTripService(laExDeEdu, trips), createFakeLoggedInUserProvider(loggedInUser)).getTripsByUser(laExDeEdu);

        assertThat(tripsDeLaExDeEdu.size(), is(0));
    }

    @Test
    void shouldReturnEmptyTripsListWhenUserAndLoggedInUserAreJustFriends() {
        loggedInUser = new User(); //representa a Edu
        Trip tripToSanFran = new Trip();
        Trip tripToThailand = new Trip();
        trips = List.of(tripToSanFran, tripToThailand);
        User javi = anUser()
                .withFriends(List.of(loggedInUser))
                .build();

        List<Trip> tripsDeJavi = new TripService(createFakeTripService(javi, trips), createFakeLoggedInUserProvider(loggedInUser)).getTripsByUser(javi);

        assertThat(tripsDeJavi.size(), is(0));
    }

    @Test
    void shouldReturnTripsWhenUserAndLoggedInUserAreCloseFriends() {
        loggedInUser = new User(); //representa a Edu
        Trip tripToSanFran = new Trip();
        Trip tripToThailand = new Trip();
        trips = List.of(tripToSanFran, tripToThailand);
        User javi = anUser()
                .withCloseFriends(List.of(loggedInUser))
                .build();

        List<Trip> tripsDeJavi = new TripService(createFakeTripService(javi, trips), createFakeLoggedInUserProvider(loggedInUser)).getTripsByUser(javi);

        assertThat(tripsDeJavi.size(), is(2));
        assertThat(tripsDeJavi.get(0), is(tripToSanFran));
        assertThat(tripsDeJavi.get(1), is(tripToThailand));
    }

    private static LoggedInUserProvider createFakeLoggedInUserProvider(User loggedInUser) {
        final LoggedInUserProvider loggedInUserProvider = mock(LoggedInUserProvider.class);
        when(loggedInUserProvider.getLoggedUser()).thenReturn(loggedInUser);
        return loggedInUserProvider;
    }

    private static TripsFinder createFakeTripService(User loggedInUser, List<Trip> trips) {
        final TripsFinder tripFinder = mock(TripsFinder.class);
        when(tripFinder.findTripsByUser(loggedInUser)).thenReturn(trips);
        return tripFinder;
    }

    //ifs positivos
    //declarar variables cerca de su primer uso
    //terminaciones tempranas vs un solo return
    //variables de un solo no hacen falta
    //dependencies como delegados
    //bloques de codigo complejo encapsulados en un metodo
}
