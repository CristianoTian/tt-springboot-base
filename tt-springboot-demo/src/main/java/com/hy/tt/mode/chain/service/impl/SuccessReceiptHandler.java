package com.hy.tt.mode.chain.service.impl;

import com.hy.tt.mode.chain.IReceiptHandleChain;
import com.hy.tt.mode.chain.service.IReceiptHandler;
import com.hy.tt.mode.chain.entity.Receipt;
import org.apache.commons.lang3.StringUtils;

/**
 * @author thy
 * @date 2020/4/11
 */
public class SuccessReceiptHandler implements IReceiptHandler {
    @Override
    public void handlReceipt(Receipt receipt, IReceiptHandleChain chain) {
        if(StringUtils.equals("ERROR",receipt.getType())){
            System.out.println("收到消息ERROR");
        }else{
            chain.handleReceipt(receipt);
        }
    }
}
