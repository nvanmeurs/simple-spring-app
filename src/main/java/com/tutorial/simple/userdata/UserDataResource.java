package com.tutorial.simple.userdata;

import com.tutorial.simple.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/userdata")
@RequiredArgsConstructor
public class UserDataResource {
    private final MongoOperations mongoOperations;

    @GetMapping("/{entityName}")
    public List<Object> getEntities(@PathVariable String entityName) {
        return mongoOperations.findAll(Object.class, entityName);
    }

    @GetMapping("/{entityName}/{id}")
    public Object getEntity(
            @PathVariable String entityName,
            @PathVariable String id
    ) {
        Object entity = mongoOperations.findById(id, Object.class, entityName);

        if (entity == null) {
            throw new ResourceNotFoundException("Entity: " + entityName + " ID: " + id);
        }

        return entity;
    }
}
