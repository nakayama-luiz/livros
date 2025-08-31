package com.example.orliv.controller;

import com.example.orliv.domain.Author;
import com.example.orliv.dto.AuthorDTO;
import com.example.orliv.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/redis")
public class HelloRedisController {

    private final AuthorRepository authorRepository;

    public HelloRedisController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Autowired
    private RedisTemplate<String, AuthorDTO> template;

    @PostMapping("/strings")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<Long, AuthorDTO> set(@RequestParam String key, @RequestParam Long value) {
        AuthorDTO first = template.opsForValue().get(key);
        if (Objects.nonNull(first)) {
            return Map.of(value, first);
        }

        Author dto = authorRepository.findById(value).orElse(new Author());
        AuthorDTO shioujop = new AuthorDTO(dto);
        template.opsForValue().set(key, shioujop);
        return Map.of(value, shioujop);
    }

    @GetMapping("/get/{id}")
    public AuthorDTO get(@PathVariable String id) {
        return Optional.ofNullable(template.opsForValue().get(id)).orElse(new AuthorDTO());
    }

}