package com.hy.tt.mode.chain.service.impl;

import com.hy.tt.mode.chain.IReceiptHandleChain;
import com.hy.tt.mode.chain.service.IReceiptHandler;
import com.hy.tt.mode.chain.entity.Receipt;
import org.apache.commons.lang3.StringUtils;

public class ErrorReceiptHandler implements IReceiptHandler {
    @Override
    public void handlReceipt(Receipt receipt, IReceiptHandleChain chain) {
        if(StringUtils.equals("SUCCESS",receipt.getType())){
            System.out.println("收到消息SUCCESS");
        }else{
            chain.handleReceipt(receipt);
        }
    }
}
