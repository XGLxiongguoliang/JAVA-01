package com.jikeshijian.transaction.service;

import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    void insert();

    void insertBatch();

    String selectByKey(Integer key);
}
