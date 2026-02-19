package com.ecommerce.back.services;

import org.springframework.stereotype.Service;

import com.ecommerce.back.repositories.PostresRepository;

@Service
public class PostresService {

    private final PostresRepository postresRepository;

    public PostresService(PostresRepository postresRepository) {
        this.postresRepository = postresRepository;
    }

    

}
