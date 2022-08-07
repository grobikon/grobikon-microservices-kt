package ru.grobikon.micro.grobikonusers.repo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.grobikon.common.grobikoncommonentity.entity.User;

// принцип ООП: абстракция-реализация - здесь описываем все доступные способы доступа к данным
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // возвращает только либо 0 либо 1 объект, т.к. email уникален для каждого пользователя
    User findByEmail(String email); // email уникально для всей таблицы

    void deleteByEmail(String email); // строгое соотвествие email (не вхождени)


    // искать по всем переданным параметрам (пустые параметры учитываться не будут)
    @Query("SELECT u FROM User u where " +
            "(:email is null or :email='' or lower(u.email) like lower(concat('%', :email,'%'))) and" +
            " (:username is null or :username='' or lower(u.username) like lower(concat('%', :username,'%')))"
    )
    Page<User> findByParams(@Param("email") String email,
                            @Param("username") String username,
                            Pageable pageable
    );

}
