package com.project.bankproj.controller;

import com.project.bankproj.dto.ProductDto;
import com.project.bankproj.service.ProductServiceImpl;
import com.project.bankproj.util.DtoCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(ProductController.class)
@DisplayName("ProductController test class")
class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ProductController productController;

    @MockBean
    private ProductServiceImpl productService;

    @Test
    void getAllProducts() throws Exception {
        List<ProductDto> productDtoList = new ArrayList<>();
        ProductDto productDto = DtoCreator.getProductDto();
        productDtoList.add(productDto);
        when(productService.getAllProducts()).thenReturn(productDtoList);

        mvc.perform(MockMvcRequestBuilders.get("/api/product").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void getProduct() throws Exception {
        ProductDto productDto = DtoCreator.getProductDto();
        int productID = productDto.getId();
        when(productService.getProductById(productID)).thenReturn(productDto);

        mvc.perform(MockMvcRequestBuilders.get("/api/product/" + productID))
                .andExpect(status().isOk())
                .andDo(print());

        verify(productService, times(1)).getProductById(productID);
    }
}
