package com.mygroup.myproject.es.entity;

/**
 * @ClassName: ChildItem
 * @Description:
 * @Author 吴小田
 * @Date 2022/1/10
 */
public class ChildItem {

    private int id;
    private String name;

    public ChildItem(int id, String name) {
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() {
        return "ChildItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChildItem() {
    }
}
