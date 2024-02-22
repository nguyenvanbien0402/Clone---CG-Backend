package com.backend.repository;

import com.backend.entity.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserMasterRepository extends JpaRepository<UserMaster, Integer> {

    @Query(value = "select * from user_master_mst u where u.user_name = :username and u.is_active = :isActive", nativeQuery = true)
    UserMaster findUserByUsernameandIsActive(@Param("username") String username, @Param("isActive") Integer isActive);

    @Query(value = "SELECT * FROM user_master_mst WHERE user_name =:username and is_active = :isActive ", nativeQuery = true)
    UserMaster findByUsernameAndActive(@Param("username") String username, @Param("isActive") Integer isActive);

    @Query(value = "SELECT * FROM user_master_mst WHERE user_name =:username ", nativeQuery = true)
    UserMaster findByUsername(String username);
}
