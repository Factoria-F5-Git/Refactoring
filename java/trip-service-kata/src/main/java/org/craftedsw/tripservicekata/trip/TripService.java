package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	private final TripsFinder tripsFinder;

	public TripService(TripsFinder tripsFinder) {
		this.tripsFinder = tripsFinder;
	}

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		User loggedUser = getLoggedUser();
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

	public User getLoggedUser() {
		return UserSession.getInstance().getLoggedUser();
	}

}
