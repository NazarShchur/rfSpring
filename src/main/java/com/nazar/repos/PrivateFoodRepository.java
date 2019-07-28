package com.nazar.repos;

import com.nazar.entity.PrivateFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PrivateFoodRepository extends JpaRepository<PrivateFood, Long>{
    List<PrivateFood> findByUserIsNotNull();
    List<PrivateFood> findAllByUserIsNull();
    List<PrivateFood> findAllByUser_Id(Long id);
    @Transactional
    @Modifying
    @Query("UPDATE PrivateFood f " +
            "SET f.user = null " +
            "WHERE f.id = :id")
    void updateFoodMakePublic(@Param("id") Long id);
}
