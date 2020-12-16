package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;

import java.util.List;

public class TripsFinder {
    public TripsFinder() {
    }

    public List<Trip> findTripsByUser(User user) {
        return TripDAO.findTripsByUser(user);
    }
}