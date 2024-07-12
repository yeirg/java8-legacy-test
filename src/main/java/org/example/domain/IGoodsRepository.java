package org.example.domain;

import java.util.List;

public interface IGoodsRepository {
    boolean save(Good good);
    List<Good> findAll();
}
