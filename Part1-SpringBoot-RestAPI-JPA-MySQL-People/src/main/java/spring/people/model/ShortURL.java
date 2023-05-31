/*******************************************************************************
 * Copyright (c) 2023 Viking Cloud, LLC - All Rights Reserved.
 *
 * Proprietary and confidential information of Viking Cloud, LLC.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 *******************************************************************************/
package spring.people.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TODO: Class description here
 *
 * <pre>
 * Copyright (c) 2023 Viking Cloud, LLC. - All rights reserved.
 * </pre>
 *
 * @author ymartinez
 */
@Entity
@Table(name = "url")
public class ShortURL {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String url;

    private String shortUrl;

    private int hit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }
}

