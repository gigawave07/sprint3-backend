package com.sprint3.backend.repository;

import com.sprint3.backend.entity.AppAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AppAccountRepository extends JpaRepository<AppAccount, Long> {
    @Query(value = "select * from app_account where username =?", nativeQuery = true)
    AppAccount findAccountByUserName(String username);

    @Query(value = "select * from app_account where id =?", nativeQuery = true)
    AppAccount findAccountById(Long id);

    @Modifying
    @Query(value = "update app_account set password=?1 where id=?2", nativeQuery = true)
    void changePasswordUser(String password, Long id);
}
