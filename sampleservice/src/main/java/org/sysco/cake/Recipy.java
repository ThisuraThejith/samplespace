package org.sysco.cake;

/**
 * Created by chamarap on 3/26/17.
 */
public class Recipy {

    private final long id;
    private final String name;

    public Recipy(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
