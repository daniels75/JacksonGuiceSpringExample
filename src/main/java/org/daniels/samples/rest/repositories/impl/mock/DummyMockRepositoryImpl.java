package org.daniels.samples.rest.repositories.impl.mock;

import org.daniels.samples.rest.domain.User;
import org.daniels.samples.rest.repositories.contract.DummyRepository;

public class DummyMockRepositoryImpl extends GenericMockRepository<User> implements DummyRepository {

    @Override
    public User getDefaultUser() {
        User user = new User();
        user.setFirstName("JonFromREST");
        user.setLastName("DoeFromREST");
        return user;
    }
}
