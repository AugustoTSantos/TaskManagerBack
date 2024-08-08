package selaz.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import selaz.api.dto.UserDTO;
import selaz.api.entity.user.User;
import selaz.api.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userReposiroty;

    //Crud Start
    public List<User> getAllUsers(){
        return this.userReposiroty.findAll();
    }

    // Auxiliary Method
    public void saveUser(User user){
        this.userReposiroty.save(user);
    }

    public User createUser(UserDTO userDTO){
        User newUser = new User(userDTO);

        this.saveUser(newUser);

        return newUser;
    }

    // Auxiliary Method
    public User getUserById(Long useId) throws Exception{
        return this.userReposiroty.findByUseId(useId).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public User updateUser(Long useId, UserDTO userDTO) throws Exception{
        User user = this.getUserById(useId);

        user.setUseUsername(userDTO.useUsername());
        user.setUsePassword(userDTO.usePassword());
        user.setUseNivel(userDTO.useNivel());

        return this.userReposiroty.save(user);
    }

    public void deleteUser(Long useId) throws Exception{
        User user = this.getUserById(useId);

        this.userReposiroty.delete(user);
    }
    //Crud End
}
