package com.example.springdemo.game;

import org.springframework.data.repository.ListCrudRepository;

public interface GameRepository extends ListCrudRepository<Game,Long> {
}
