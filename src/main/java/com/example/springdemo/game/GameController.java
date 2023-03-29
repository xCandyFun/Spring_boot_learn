package com.example.springdemo.game;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {


    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    @GetMapping("/{id}")
    Game get (@PathVariable Long id){
        return gameRepository.findById(id).orElseThrow();
    }

    @GetMapping
    List<Game> getAllGame(){
        return gameRepository.findAll();
    }

    @PostMapping
    void addGame(@RequestBody Game game){
     gameRepository.save(game);
    }

    @DeleteMapping("/{id}")
    void removeGame(@PathVariable long id){
        gameRepository.deleteById(id);
    }
}
