package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class LoggedInUserProvider {
    public LoggedInUserProvider() {
    }

    public User getLoggedUser() {
        return UserSession.getInstance().getLoggedUser();
    }
}