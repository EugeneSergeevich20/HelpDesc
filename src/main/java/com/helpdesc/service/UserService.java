package com.helpdesc.service;

import com.helpdesc.model.user.Client;
import com.helpdesc.model.user.Master;
import com.helpdesc.model.user.Role;
import com.helpdesc.model.user.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        Master master1 = new Master("NameMaster", "SurnameMaster", "PatronymicMaster", "UsernameMaster", "1234");
        master1.setRole(Role.ROLE_MASTER);

        User user = new User("Admin", "Admin", "Admin", "Admin", "Admin");
        user.setRole(Role.ROLE_ADMIN);

        userList.add(master1);
        userList.add(user);
    }

    public void register(Client client){
        client.setRole(Role.ROLE_CLIENT);
        userList.add(client);
    }

    public List<User> getUserList(){
        return userList;
    }

}
