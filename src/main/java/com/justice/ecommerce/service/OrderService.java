package com.justice.ecommerce.service;

import com.justice.ecommerce.dto.order.CheckOutItemDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;

import java.util.List;

public interface OrderService  {
    Session createSession(List<CheckOutItemDTO> checkOutItemDTOList) throws StripeException;

}
