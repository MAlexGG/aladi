package com.aladi.aladi.service;

import com.aladi.aladi.entity.Editorial;

public interface EditorialService {

    public Editorial findOrCreateEditorialByName(String name);

}
