package com.hy.tt.mode.chain.entity;

import lombok.Data;

/**
 * @author thy
 * @date 2020/4/11
 */
@Data
public class Receipt {

    /**
     * 回执信息
     */
    String message;

    /**
     * 回执类型(`SUCCESS、ERROR`)
     */
    String type;
}
