package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;

public class TripService {

	private final TripsFinder tripsFinder;
	private final LoggedInUserProvider loggedInUserProvider;

	public TripService(TripsFinder tripsFinder, LoggedInUserProvider loggedInUserProvider) {
		this.tripsFinder = tripsFinder;
		this.loggedInUserProvider = loggedInUserProvider;
	}

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		User loggedUser = loggedInUserProvider.getLoggedUser();
		if (loggedUser == null) {
			throw new UserNotLoggedInException();
		}

		for (User friend : user.getCloseFriends()) {
			if (friend.equals(loggedUser)) {
				return tripsFinder.findTripsByUser(user);
			}
		}

		return new ArrayList<Trip>();
	}

}
