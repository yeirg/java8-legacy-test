package org.example.domain;

public class EntityBase<T> {
    protected T id;

    public T getId() {
        return id;
    }
    
    public void setId(T id) {
        this.id = id;
    }
}

/*
public class EntityBase extends EntityBase<Integer> {
    
}
*/

