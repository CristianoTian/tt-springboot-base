package com.hy.tt.mode.chain.service;

import com.hy.tt.mode.chain.IReceiptHandleChain;
import com.hy.tt.mode.chain.entity.Receipt;

public interface IReceiptHandler {

    void handlReceipt(Receipt receipt, IReceiptHandleChain chain);
}
