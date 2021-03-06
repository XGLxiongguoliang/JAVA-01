package com.jikeshijian.transaction.mapper;

import com.jikeshijian.transaction.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderMapper {
    void insert(Order order);

    void insertBatch(List<Order> list);

    String selectByKey(Integer id);
}
