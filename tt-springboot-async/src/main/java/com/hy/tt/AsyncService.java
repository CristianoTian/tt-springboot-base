package com.hy.tt;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @auther thy
 * @date 2019/10/30
 */
@Service
public class AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);

    private List<String> movies = new ArrayList<>(Arrays.asList("Forrest Gump",
            "Titanic",
            "Spirited Away",
            "The Shawshank Redemption",
            "Zootopia",
            "Farewell ",
            "Joker",
            "Crawl"));


    /**
     * 模拟电影以start开头的搜索
     * @param start
     * @return
     */
    @Async
    public CompletableFuture<List<String>> completableFuture(String start){

        //记录当前线程信息
        logger.info(Thread.currentThread().getName() + "start this task!");

        //以start开头的电影集合
        List<String> collect = movies.stream().filter(movie -> movie.startsWith(start)).collect(Collectors.toList());

        //模拟时间
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //返回结果合集
        return CompletableFuture.completedFuture(collect);
    }
}
