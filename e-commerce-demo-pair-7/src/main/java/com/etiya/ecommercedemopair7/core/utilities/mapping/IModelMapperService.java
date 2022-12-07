package com.etiya.ecommercedemopair7.core.utilities.mapping;

import org.modelmapper.ModelMapper;

public interface IModelMapperService {
    ModelMapper forRequest();

    ModelMapper forResponse();

}
