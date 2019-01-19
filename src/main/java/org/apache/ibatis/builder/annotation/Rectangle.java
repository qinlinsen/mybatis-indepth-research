package org.apache.ibatis.builder.annotation;

import java.io.Serializable;

/**
 * @author Abraham Qin
 * @since 2019/1/13
 */
public class Rectangle implements Serializable{
    private Integer height;
    private Integer width;
    private  Integer area;

    public Rectangle(Integer height, Integer width) {
        this.height = height;
        this.width = width;
        this.area=height*width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
    public void setArea(){
        this.area=this.height*this.width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                ", area=" + area +
                '}';
    }
}
