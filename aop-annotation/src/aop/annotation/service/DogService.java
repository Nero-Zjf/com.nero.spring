package aop.annotation.service;

import org.springframework.stereotype.Service;

@Service
public class DogService {
    public void getDog() {
        System.out.println("get dog");
        //int i = 1 / 0;
    }
    public void updDog() {
        System.out.println("upd dog");
    }
}
