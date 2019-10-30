package com.hy.tt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @auther thy
 * @date 2019/10/30
 */
@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/movies")
    public String completableFutureTask(){
        long start = System.currentTimeMillis();
        List<String> words = Arrays.asList("F", "T", "S", "Z", "J", "C");

        List<CompletableFuture<List<String>>> collect = words.stream().map(word -> asyncService.completableFuture(word)).collect(Collectors.toList());

        List<List<String>> collect1 = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());

        long end = System.currentTimeMillis();
        System.out.println("time = " + (end - start));
        return collect1.toString();
    }
}
