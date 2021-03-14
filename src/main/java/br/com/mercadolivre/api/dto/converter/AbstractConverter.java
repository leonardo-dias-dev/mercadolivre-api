package br.com.mercadolivre.api.dto.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<ENTITY, RESPONSE, REQUEST> {

    @Autowired
    private ModelMapper modelMapper;

    private Class<ENTITY> entityClass;

    private Class<RESPONSE> responseClass;

    @SuppressWarnings("unchecked")
    public AbstractConverter() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();

        this.entityClass = (Class<ENTITY>) parameterizedType.getActualTypeArguments()[0];
        this.responseClass = (Class<RESPONSE>) parameterizedType.getActualTypeArguments()[1];
    }

    public RESPONSE toResponse(ENTITY entity) {
        return modelMapper.map(entity, responseClass);
    }

    public List<RESPONSE> toCollectionResponse(Collection<ENTITY> entities) {
        return entities.stream()
                .map(entity -> toResponse(entity))
                .collect(Collectors.toList());
    }

    public ENTITY toEntity(REQUEST requestDto) {
        return modelMapper.map(requestDto, entityClass);
    }

    public void copyToEntity(REQUEST requestDto, ENTITY entity) {
        modelMapper.map(requestDto, entity);
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }
}
