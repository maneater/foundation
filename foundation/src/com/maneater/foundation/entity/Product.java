package com.maneater.foundation.entity;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by macbook on 15/11/15.
 */
@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Table(name = "t_product")
public class Product {
    private String name;
    private String info;
    private Category category;
    private String authorName;
    private String authorId;

    private String productId;

    private String content;

    private String refferUrl;

    private String picUrls;
    private String thumbnails;
    private long orderNum;
}
