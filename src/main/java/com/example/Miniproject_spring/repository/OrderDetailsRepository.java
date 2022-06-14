package com.example.Miniproject_spring.repository;

import com.example.Miniproject_spring.entity.Orders;
import com.example.Miniproject_spring.entity.Orders_detail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "orders_detail")
public interface OrderDetailsRepository extends PagingAndSortingRepository<Orders_detail,Long> {

    @RestResource(rel = "find-by-id", description = @Description("Find by id"))
    public Orders findFirstById(@Param("id") Long id);
    @RestResource(rel = "create", description = @Description("Create"))
    public Orders save(@Param("order") Orders orders);
}
