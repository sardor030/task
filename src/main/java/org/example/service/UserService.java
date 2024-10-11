package org.example.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.dto.UserCreateDto;
import org.example.dto.UserDto;
import org.example.dto.UserUpdateDto;
import org.example.entity.User;
import org.example.mapper.BookMapper;
import org.example.mapper.UserMapper;
import org.example.repository.UserRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserMapper umapper;
    @Autowired
    private BookMapper mapper;
    public Long create(UserCreateDto createDto) {
        User user = mapper.fromCreateDto(createDto);
        user.setName(createDto.getName());
        user.setSureName(createDto.getSureName());
        user.setBirthDate(createDto.getBirthDate());
        user.setFaculty(createDto.getFaculty());
        user.setCourse(createDto.getCourse());
        return repository.save(user).getId();
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
    public void update(UserUpdateDto updateDto) {
        User user = mapper.fromUpdateDto(updateDto);
        repository.save(user);
    }
    public List<UserDto> getAll() {
        return mapper.toDto(repository.getAllUsers());
    }
    public UserDto get(Long id) {
        User user = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Not Found");
        });
        return mapper.toDto(user);
    }
}
