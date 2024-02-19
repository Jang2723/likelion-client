package com.example.api;

import com.example.api.client.ArticleService;
import com.example.api.client.ArticleTemplateClient;
import com.example.api.client.ArticleWebClient;
import com.example.api.dto.ArticleDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleTemplateClient templateClient;
    private final ArticleWebClient articleWebClient;
    private final ArticleService service;

    @PostMapping
    public ArticleDto create(
            @RequestBody
            ArticleDto dto
    ) {
        return service.create(dto);
    }

    @GetMapping("{id}")
    public ArticleDto readOne(
            @PathVariable("id")
            Long id
    ) {
        return service.readOne(id);
    }
    
    @GetMapping
    public List<ArticleDto> readAll(){
        return service.readAll();
    }

    @PutMapping("{id}")
    public ArticleDto update(
            @PathVariable("id")
            Long id,
            @RequestBody
            ArticleDto dto
    ) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable("id")
            Long id
    ){
        service.delete(id);
    }
}
