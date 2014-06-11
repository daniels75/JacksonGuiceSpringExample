package org.daniels.samples.rest.repositories.contract;

import org.daniels.samples.rest.domain.User;

public interface DummyRepository extends Repository<User> {
    User getDefaultUser();
}
