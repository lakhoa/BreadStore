package com.example.Miniproject_spring.service.implement;
import com.example.Miniproject_spring.entity.Orders;
import com.example.Miniproject_spring.entity.OrdersDetail;
import com.example.Miniproject_spring.entity.Product;
import com.example.Miniproject_spring.entity.Topping;
import com.example.Miniproject_spring.exception_handler.CustomException;
import com.example.Miniproject_spring.repository.ToppingRepository;
import com.example.Miniproject_spring.service.DTO.OrdersDto;
import com.example.Miniproject_spring.service.OrdersService;
import com.example.Miniproject_spring.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import com.example.Miniproject_spring.models.ResponseForm;
import com.example.Miniproject_spring.repository.OrderDetailsRepository;
import com.example.Miniproject_spring.repository.OrdersRepository;
import com.example.Miniproject_spring.repository.ProductRepository;
import com.example.Miniproject_spring.service.DTO.ItemDto;
import com.example.Miniproject_spring.service.DTO.OrderToppingDto;
import com.example.Miniproject_spring.service.DTO.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
public class OrdersImplement implements OrdersService {
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Autowired
    ToppingRepository toppingRepository;


    public OrdersImplement(OrdersRepository ordersRepository, OrderDetailsRepository orderDetailsRepository) {
        this.ordersRepository = ordersRepository;
        this.orderDetailsRepository = orderDetailsRepository;
    }


    @Override
    public ResponseForm<Orders> createOrder(List<OrderDto<List<OrderToppingDto>>> allOrders) throws CustomException {

        //Check invalid quantity
        checkValidQuantity(allOrders);

        double totalPriceAll = 0.0;
        LocalDateTime now = LocalDateTime.now();
        List<OrdersDetail> listOrderDetail = new ArrayList<>();
        //List<ItemDto> listItem =new ArrayList<>();


        for (OrderDto<List<OrderToppingDto>> orderItem : allOrders) {

            Product product = productRepository.findById(orderItem.getProductId());
            //listItem.add(new ItemDto(product,orderItem.getQuantity()));
            double totalItemsPrice = 0.0;

            // case buy non bread
            if (orderItem.getToppings() == null) {

                //calculate total price
                totalItemsPrice = product.getPrice() * orderItem.getQuantity();



            } else {

                // case buy bread have other items
                // get productID from list item
                List<Long> listToppingId = new ArrayList<>();
                for (OrderToppingDto S : orderItem.getToppings()) {
                    listToppingId.add(S.getToppingId());
                }

                // map productID to productQuantity
                Map<Long, Integer> map = orderItem.getToppings()
                        .stream()
                        .collect(Collectors.toMap(OrderToppingDto::getToppingId, OrderToppingDto::getQuantity));

                // search in database
                List<Topping> toppingList = toppingRepository.findByIdIn(listToppingId);

                // calculate total price of a item
                double toppingsPrice = 0.0;
                for (Topping S : toppingList ) {
                    toppingsPrice += S.getPrice() * map.get(S.getId());
                    }
                double itemPrice = toppingsPrice + product.getPrice();
                totalItemsPrice = itemPrice*orderItem.getQuantity();
                }

            totalPriceAll += totalItemsPrice;
            }

        Orders responseData = new Orders(null, now, totalPriceAll);

        //save data to order table
        ordersRepository.save(responseData);

        //save data to order detail table


        return new ResponseForm<Orders>(responseData, true, "The order is added");
    }

    @Override
    public OrdersDto list() {
        List<Orders> ordersList = ordersRepository.findAll();
        List<OrdersDetail> ordersDetailsList = orderDetailsRepository.findAll();
        List<OrdersDto> ordersDtos = new ArrayList<>();

        // create empty list

        List ordersDetailList_get = new ArrayList<>();
        double total_all_price = 0;
        int quan = 0;
        for (Orders orders1 : ordersList) {
            OrdersDto ordersDto = new OrdersDto();
            total_all_price += orders1.getTotal_price();
            ordersDtos.add(ordersDto);
        }

        for (OrdersDetail ordersDetail : ordersDetailsList) {
            // stack in list

            List ordersDetailList_get_in = new ArrayList<>();
            quan += ordersDetail.getQuantity();
            ordersDetailList_get_in.add("name:  " + ordersDetail.getProduct().getName());

            ordersDetailList_get_in.add("quantity:  " + ordersDetail.getQuantity());

            ordersDetailList_get_in.add("price:  " + ordersDetail.getProduct().getPrice());

            ordersDetailList_get_in.add("price total:  " + ordersDetail.getOrders().getTotal_price());

            ordersDetailList_get_in.add("date:  " + ordersDetail.getOrders().getCreatedDate());

            ordersDetailList_get.add(ordersDetailList_get_in);

        }

        OrdersDto ordersDto = new OrdersDto();
        ordersDto.setTotal(total_all_price);
        ordersDto.setQuantity(quan);
        ordersDto.setProduct(ordersDetailList_get);
        return ordersDto;

    }

    // function check invalid
    public void checkValidQuantity(List<OrderDto<List<OrderToppingDto>>> allOrders) throws CustomException {
        for (OrderDto<List<OrderToppingDto>> orderItem : allOrders){
            int MAX_NUMBER_ITEM = Constant.MAX_NUMBER_PRODUCT;
            Integer amountProduct = 0;
            for (OrderToppingDto S : orderItem.getToppings()){
                amountProduct += S.getQuantity();
            }
            if (amountProduct > MAX_NUMBER_ITEM){
                throw new CustomException("Amount: "+amountProduct+ " invalid", allOrders);
            }
        }
    }
}
