package com.dojo.karate.services;

import org.modelmapper.ModelMapper;

public class ModelMapperProvider implements IModelMapperProvider{

    private ModelMapper modelMapper;

    public ModelMapperProvider(){
        this.modelMapper = new ModelMapper();
    }

    public ModelMapper getModelMapper(){
        return modelMapper;
    }
}
