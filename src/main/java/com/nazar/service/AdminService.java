package com.nazar.service;

import com.nazar.entity.PrivateFood;
import com.nazar.repos.PrivateFoodRepository;
import com.nazar.repos.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class AdminService {
    private final PrivateFoodRepository foodRepository;
    @Autowired
    public AdminService( PrivateFoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }

    public List<PrivateFood> findUsersFood(){
        return foodRepository.findByUserIsNotNull();
    }

    public void updateFoodToPublic(Long id){
        foodRepository.updateFoodMakePublic(id);
    }
}
