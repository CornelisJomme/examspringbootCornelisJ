package fr.CornelisJ.exam.service;

import fr.CornelisJ.exam.entity.User;
import fr.CornelisJ.exam.exception.NotFoundInstantFrancingException;
import fr.CornelisJ.exam.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User getObjectById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundInstantFrancingException("User", "id", id);
        }
        return optionalUser.get();
    }

}
