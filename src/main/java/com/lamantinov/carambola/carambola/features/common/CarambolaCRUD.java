package com.lamantinov.carambola.carambola.features.common;

import java.util.List;

public interface CarambolaCRUD<E> {
        public List<E> getAll();

        public void save(E e);

        public E getById(int id);

        public void delete(int id);
}
