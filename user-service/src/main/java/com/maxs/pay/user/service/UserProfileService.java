package com.maxs.pay.user.service;
import com.maxs.pay.user.entity.UserProfile;import com.maxs.pay.user.exception.ResourceNotFoundException;import com.maxs.pay.user.repository.UserProfileRepository;
import org.springframework.stereotype.Service;import java.util.List;
@Service public class UserProfileService {
    private final UserProfileRepository repository;
    public UserProfileService(UserProfileRepository repository){this.repository=repository;}
    public UserProfile getById(Long id){return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));}
    public UserProfile update(Long id, UserProfile request){UserProfile u=getById(id);u.setFullName(request.getFullName());u.setPhone(request.getPhone());u.setStatus(request.getStatus());return repository.save(u);} 
    public List<UserProfile> list(){return repository.findAll();}

}