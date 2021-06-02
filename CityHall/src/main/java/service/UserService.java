package service;

import dto.UserDto;
import entity.User;
import repository.UserRepo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserService {
    private UserRepo userRepo=new UserRepo();
    public void addUser(User user){

        userRepo.insertNewUser(user);
    }

    public List<UserDto> getAllUsers(){
        List<User> users1= userRepo.findall();
        List<UserDto> users=new ArrayList<>();
        Iterator it=users1.iterator();
        while(it.hasNext())
        {
            User user_current= (User) it.next();
            UserDto user = new UserDto(user_current.getIduser(), user_current.getName(), user_current.getCNP(), user_current.getPhone(), user_current.getEmail());
            users.add(user);
        }
        return users;
    }


    public User getUser(String email){

        return userRepo.findAdminbyEmail(email);
    }

    public User getUserById(String iduser){
        return userRepo.findById(iduser);
    }

    public UserRepo getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
}
