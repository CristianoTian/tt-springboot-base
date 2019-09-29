package com.hy.tt.spring.mybatis.service;

import com.hy.tt.spring.mybatis.dao.TDao;
import com.hy.tt.spring.mybatis.entity.TEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther thy
 * @date 2019/9/29
 */
@Service
public class TService {

    @Autowired
    TDao tDao;

    public TDao gettDao() {
        return tDao;
    }

    public void settDao(TDao tDao) {
        this.tDao = tDao;
    }

    public void query(){
        List<TEntity> query = tDao.query();
        for(TEntity t : query){
            System.out.println(t.getGenerate_id());
        }
    }
}
