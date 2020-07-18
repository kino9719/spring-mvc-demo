package com.example.repository;

import com.example.model.UserOrder;
import com.example.model.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserOrderRepository extends JpaRepository<UserOrder, Integer>, JpaSpecificationExecutor<UserOrder> {
    @Query(value="select NEW com.example.model.OrderInfo(uo.id, uo.accountId, uo.phone, uo.address, uo.createdTime, a.name as accountName, sum(i.price * oi.amount) as total) from UserOrder uo \n" +
            " join uo.orderItems oi on uo.id = oi.orderId\n" +
            " join oi.item i on oi.itemId = i.id\n" +
            " join uo.account a on a.id = uo.accountId\n" +
            " group by uo.id, uo.accountId, uo.phone, uo.address, uo.createdTime, a.name")
    List<OrderInfo> listOrderInfos();

    @Query(value="select NEW com.example.model.OrderInfo(uo.id, uo.accountId, uo.phone, uo.address, uo.createdTime, a.name as accountName, sum(i.price * oi.amount) as total) from UserOrder uo \n" +
            " join uo.orderItems oi on uo.id = oi.orderId\n" +
            " join oi.item i on oi.itemId = i.id\n" +
            " join uo.account a on a.id = uo.accountId\n" +
            " where uo.accountId = :accountId\n" +
            " group by uo.id, uo.accountId, uo.phone, uo.address, uo.createdTime, a.name")
    List<OrderInfo> findOrderInfoByAccountId(@Param("accountId") Integer accountId);
}
