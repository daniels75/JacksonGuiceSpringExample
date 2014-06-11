package org.daniels.samples.rest.repositories.contract;

import org.daniels.samples.rest.domain.User;

public interface UserRepository extends Repository<User> {
    User create(User user);

    User update(User user);

    void remove(int id);

    int getNumberOfUsers();
}
