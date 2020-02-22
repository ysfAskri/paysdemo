package com.example.demo.mapper;

import com.example.demo.dto.AbstractDto;
import org.dom4j.tree.AbstractEntity;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class ReferenceMapper {

    @PersistenceContext
    private EntityManager em;

    @ObjectFactory
    public <T extends AbstractEntity> T resolve(AbstractDto sourceDto, @TargetType Class<T> type) throws IllegalAccessException, InstantiationException {
        T entity = em.find( type, sourceDto.getId() );
        return entity != null ? entity : type.newInstance();
    }
}
