package com.lamantinov.carambola.carambola.service;

import java.util.List;

public interface ServiceInterface<E> {
        public List<E> getAll();

        public void save(E e);

        public E getById(int id);

        public void delete(int id);
}
