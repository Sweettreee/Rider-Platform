package org.example.backend.domain.user.repository;

import java.util.Optional;
import org.example.backend.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    Boolean existsByUsername(String username);

    // 오버로딩 하면 깔끔할거같은데....
    Optional<UserEntity> findByUsernameAndIsLockAndIsSocial(String username, Boolean isLock, Boolean isSocial);

    Optional<UserEntity> findByUsernameAndIsSocial(String username, Boolean social);

    @Transactional
    void deleteByUsername(String username);

    Optional<UserEntity> findByUsernameAndIsLock(String username, Boolean isLock);
}
