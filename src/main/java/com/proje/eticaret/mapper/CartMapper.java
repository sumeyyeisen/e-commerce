package com.proje.eticaret.mapper;

import com.proje.eticaret.dto.CartDTO;
import com.proje.eticaret.dto.CustomerDTO;
import com.proje.eticaret.dto.ItemDTO;
import com.proje.eticaret.entity.Cart;
import com.proje.eticaret.entity.Item;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {

    private final ModelMapper modelMapper;

    public CartMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CartDTO toDTO(Cart cart) {
        if (cart == null) return null;
        CartDTO dto = new CartDTO();
        dto.setId(cart.getId());
        dto.setTotalPrice(cart.getTotalPrice());
        if (cart.getCustomer() != null) {
            dto.setCustomer(modelMapper.map(cart.getCustomer(), CustomerDTO.class));
        }
        dto.setItems(cart.getItems().stream().map(this::toItemDTO).collect(Collectors.toList()));
        return dto;
    }

    private ItemDTO toItemDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setProductId(item.getProduct() != null ? item.getProduct().getId() : null);
        itemDTO.setQuantity(item.getQuantity());
        itemDTO.setProductPrice(item.getProductPrice());
        return itemDTO;
    }

    public Cart toEntity(CartDTO dto) {
        if (dto == null) return null;
        Cart cart = modelMapper.map(dto, Cart.class);
        return cart;
    }

    public List<CartDTO> toDTOList(List<Cart> carts) {
        return carts.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
