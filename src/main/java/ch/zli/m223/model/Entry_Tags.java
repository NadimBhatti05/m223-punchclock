package ch.zli.m223.model;

import javax.persistence.Column;

public class Entry_Tags {

    @Column(nullable = false)
    private Long tag_id;

    @Column(nullable = false)
    private Long category_id;

    public Long getTag_id() {
        return tag_id;
    }

    public void setTag_id(Long tag_id) {
        this.tag_id = tag_id;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
}
