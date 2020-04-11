package com.hy.tt.mode.chain;

import com.hy.tt.mode.chain.service.IReceiptHandler;
import com.hy.tt.mode.chain.service.impl.ErrorReceiptHandler;
import com.hy.tt.mode.chain.service.impl.SuccessReceiptHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author thy
 * @date 2020/4/11
 */
public class ReceiptHandlerContainer {

    public ReceiptHandlerContainer() {
    }


    /**
     * demo先写死  TODO 反射注入
     */

    public static List<IReceiptHandler> getReceiptHandlerList(){
        List<IReceiptHandler> receiptHandlerList = new ArrayList<>();
        receiptHandlerList.add(new SuccessReceiptHandler());
        receiptHandlerList.add(new ErrorReceiptHandler());
        return receiptHandlerList;
    }
}
