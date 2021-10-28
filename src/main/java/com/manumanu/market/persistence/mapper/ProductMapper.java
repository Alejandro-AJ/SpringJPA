package com.manumanu.market.persistence.mapper;


import com.manumanu.market.domain.Product;
import com.manumanu.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Component
@Mapper(
        componentModel = "spring",
        uses = CategoryMapper.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper {

    @Mappings({
            @Mapping(source ="idProducto",target = "productId"),
            @Mapping(source ="nombre",target = "name"),
            @Mapping(source ="idCategoria",target = "categoryId"),
            @Mapping(source ="precioVenta",target = "price"),
            @Mapping(source ="cantidadStock",target = "stock"),
            @Mapping(source ="estado",target = "active"),
            @Mapping(source ="categoria", target = "category")
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore= true)
    Producto toProducto(Product product);
}
