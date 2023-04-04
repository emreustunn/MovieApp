package com.bilgeadam.service;

import com.bilgeadam.dto.request.LoginRequestDto;
import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.mapper.IUserMapper;
import com.bilgeadam.repository.IUserRepository;
import com.bilgeadam.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IServiceCrud<User> {
    @Autowired
    private IUserRepository repository;

    public User createUser(String name, String surname, String password, String email) {
        User user = User.builder()
                .name(name)
                .surName(surname)
                .password(password)
                .email(email)
                .build();
        return repository.save(user);
    }

    public ResponseEntity<User> registerDto(UserRegisterRequestDto dto) {
        User user = User.builder()
                .name(dto.getName())
                .surName(dto.getSurName())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .build();
        return ResponseEntity.ok(repository.save(user));
    }

    public User registerDto2(UserRegisterRequestDto dto) {
        if(repository.existsByEmail(dto.getEmail())){
            throw new RuntimeException("Böyle bir kullanıcı adı zaten var!");
        }
        if(!dto.getPassword().equals(dto.getRePassword())){
            throw new RuntimeException("Girdiğiniz şifreler uyuşmuyor!!");
        }
        User user = IUserMapper.INSTANCE.toUser(dto);
        return repository.save(user);
    }
    public List<User> findAllByOrderByName(){
        return repository.findAllByOrderByName();
    }
    public List<User> findByNameContainingIgnoreCase(String value){
        return repository.findByNameContainingIgnoreCase(value);
    }
    public List<User> findByEmailContainingIgnoreCase(String value){
        return repository.findByEmailContainingIgnoreCase(value);
    }
    public List<User> findByEmailEndingWith(String value){
        return repository.findByEmailEndingWith(value);
    }

    public LoginResponseDto login(LoginRequestDto dto) {
        Optional<User> user =repository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if(user.isEmpty()){
            throw new RuntimeException("Kullanıcı adı veya şifre hatalı");
        }
        return IUserMapper.INSTANCE.toUserLoginResponseDto(user.get());
    }
    public List<User> passwordLongerThan(int value){
        return repository.passwordLongerThan(value);
    }
    public List<User> passwordLongerThan2(int value){
        return repository.passwordLongerThan2(value);
    }
    public List<User> passwordLongerThan3(int value){
        return repository.passwordLongerThan3(value);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public Iterable<User> saveAll(Iterable<User> t) {
        return repository.saveAll(t);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<User> findAll() {
        return findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return repository.findById(id);
    }
}
