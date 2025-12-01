package com.aladi.aladi.service;

import org.springframework.stereotype.Service;

import com.aladi.aladi.entity.Editorial;
import com.aladi.aladi.repository.EditorialRepository;

@Service
public class EditorialServiceImpl implements EditorialService {

    private final EditorialRepository editorialRepository;

    public EditorialServiceImpl(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    @Override
    public Editorial getEditorialByName(String name) {
        Editorial editorial = editorialRepository.findByName(name);
        return editorial;
    }

    @Override
    public Editorial createEditorialByName(String name) {
        Editorial editorial = new Editorial();
        editorial.setName(name);
        editorialRepository.save(editorial);
        return editorial;
    }



}
