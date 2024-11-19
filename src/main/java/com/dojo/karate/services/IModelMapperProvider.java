package com.dojo.karate.services;

import org.modelmapper.ModelMapper;

public interface IModelMapperProvider {
    public ModelMapper getModelMapper();
}
