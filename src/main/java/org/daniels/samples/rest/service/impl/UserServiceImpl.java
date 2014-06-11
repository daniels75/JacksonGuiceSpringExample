package org.daniels.samples.rest.service.impl;

import com.daniels.transaction.TransactionBo;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Date;
import java.util.List;

import org.daniels.examples.hibernate.util.HibernateUtil;
import org.daniels.examples.model.Employee1;
import org.daniels.samples.rest.domain.User;
import org.daniels.samples.rest.repositories.contract.UserRepository;
import org.daniels.samples.rest.service.contract.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    SessionFactory sessionFactory;
    
    @Inject
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public int insertUser(){
    	System.out.println("sessionFactory is null? " + sessionFactory == null);
		Employee1 emp = new Employee1();
		emp.setName("David");
		emp.setRole("Developer");
		emp.setInsertTime(new Date());
		
		//Get Session
		Session session = sessionFactory.getCurrentSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(emp);
		//Commit transaction
		session.getTransaction().commit();
		System.out.println("Employee ID="+emp.getId());
		
		
		return emp.getId();
    }
    
    
    @Override
    public List getAllUsers() {
    	System.out.println("sessionFactory is null? " + sessionFactory == null);
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
