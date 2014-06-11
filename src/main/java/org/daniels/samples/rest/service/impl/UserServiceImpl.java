package org.daniels.samples.rest.service.impl;

import com.daniels.transaction.TransactionBo;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.List;

import org.daniels.samples.rest.domain.User;
import org.daniels.samples.rest.repositories.contract.UserRepository;
import org.daniels.samples.rest.service.contract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//@Component
@Singleton
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

//    @Autowired
//    TransactionBo transactionBo;
    
    @Inject
    TransactionBo transactionBo;
    
    @Inject
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List getAllUsers() {
        System.out.println("transactionBo is null? "  + transactionBo == null);
        if (transactionBo != null){
            String str = transactionBo.save();
            System.out.println(">>>>>>>>>>>>> " + str);
        }
        return this.userRepository.getAll();
    }

    @Override
    public User getById(int id) {
        return this.userRepository.getById(id);
    }

    @Override
    public User createNewUser(User user) {
        User u = this.userRepository.create(user);
        return u;
    }

    @Override
    public User update(User user) {
        return this.userRepository.update(user);
    }

    @Override
    public void remove(int id) {
        this.userRepository.remove(id);
    }

    @Override
    public int getNumberOfUsers() {
        return this.userRepository.getNumberOfUsers();
    }
}
