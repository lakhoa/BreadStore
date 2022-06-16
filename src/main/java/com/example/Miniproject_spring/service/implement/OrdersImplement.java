package com.example.Miniproject_spring.service.implement;
import com.example.Miniproject_spring.entity.Orders;
import com.example.Miniproject_spring.entity.OrdersDetail;
import com.example.Miniproject_spring.entity.Product;
import com.example.Miniproject_spring.models.ResponseForm;
import com.example.Miniproject_spring.repository.OrderDetailsRepository;
import com.example.Miniproject_spring.repository.OrdersRepository;
import com.example.Miniproject_spring.repository.ProductRepository;
import com.example.Miniproject_spring.service.DTO.ItemDto;
import com.example.Miniproject_spring.service.DTO.OrdersDetailDto;
import com.example.Miniproject_spring.service.DTO.RequestDto;
import com.example.Miniproject_spring.service.OrdersDetailService;
import com.example.Miniproject_spring.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrdersImplement implements OrdersService {
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    public OrdersImplement(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public ResponseForm<Orders> createOrder(List<RequestDto<List<OrdersDetailDto>>> allOrders) {

        double totalPriceAll = 0.0;
        LocalDateTime now = LocalDateTime.now();
        List<OrdersDetail> entitys = new ArrayList<>();
        List<ItemDto> listItem = new ArrayList<>();

        for (RequestDto<List<OrdersDetailDto>> orderItem : allOrders) {

            // create List
            ArrayList<Long> listIdProduct = new ArrayList<Long>();
            listIdProduct.add(orderItem.getIdAdd());

            // case buy non bread
            if (orderItem.getItem() == null) {
                // search price of non bread
                Product productAdd = productRepository.findById(orderItem.getIdAdd());

                //calculate total price
                double totalPrice = productAdd.getPrice() * orderItem.getQuantity();
                totalPriceAll += totalPrice;

                // add data to listItem
                ItemDto itemDto = new ItemDto(productAdd, orderItem.getQuantity());
                listItem.add(itemDto);

            } else {

                // case buy bread have other items
                // get productID from list item
                List<OrdersDetailDto> ordersDetailDtoList = orderItem.getItem();
                for (OrdersDetailDto S : orderItem.getItem()) {
                    listIdProduct.add(S.getProductId());
                }

                // map productID to productQuantity
                Map<Long, Integer> map = orderItem.getItem()
                        .stream()
                        .collect(Collectors.toMap(OrdersDetailDto::getProductId, OrdersDetailDto::getQuantity));

                // search in database
                List<Product> productList = productRepository.findByIdIn(listIdProduct); // ->list product have bread

                // calculate total price of a item
                double itemPrice = 0.0;
                for (Product S : productList) {
                    if (map.get(S.getId()) != null) {
                        itemPrice += S.getPrice() * map.get(S.getId());
                        ItemDto itemDto = new ItemDto(S, map.get(S.getId())*orderItem.getQuantity());
                        listItem.add(itemDto);
                    } else {
                        itemPrice += S.getPrice();
                        ItemDto itemDto = new ItemDto(S, orderItem.getQuantity());
                        listItem.add(itemDto);
                    }
                }

                //calculate total price of all item in orderItem
                double totalPrice = itemPrice * orderItem.getQuantity();
                totalPriceAll += totalPrice;

            }
        }
        Orders responseData = new Orders(null, now, totalPriceAll);

        //save data to order table
        ordersRepository.save(responseData);

        //save data to order detail table
        for (ItemDto S : listItem){
            OrdersDetail ordersDetail = new OrdersDetail(null, responseData, S.getProduct(), S.getQuantity());
            entitys.add(ordersDetail);
        }
        orderDetailsRepository.saveAll(entitys);

        return new ResponseForm<Orders>(responseData, true, "The order is added");
    }
}
