/*******************************************************************************
 * Copyright (c) 2023 Viking Cloud, LLC - All Rights Reserved.
 *
 * Proprietary and confidential information of Viking Cloud, LLC.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 *******************************************************************************/
package spring.people.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.people.model.ShortURL;
import spring.people.repository.UrlDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * TODO: Class description here
 *
 * <pre>
 * Copyright (c) 2023 Viking Cloud, LLC. - All rights reserved.
 * </pre>
 *
 * @author ymartinez
 */
@RestController
public class UrlController {

    @Autowired
    private UrlDAO urlDAO;


    @PostMapping("/url/short")
    public ResponseEntity<String> getShortUrl(@RequestParam(name = "url") String  largeUrlParam) {

       String shortUrl = UrlUtil.shortenURL(largeUrlParam);

       ShortURL shortUrlObj = new ShortURL();
       shortUrlObj.setUrl(largeUrlParam);
       shortUrlObj.setShortUrl(shortUrl);
       shortUrlObj.setHit(0);
       urlDAO.save(shortUrlObj);
       ResponseEntity<String> responseEntity = ResponseEntity.ok(shortUrl);
       return responseEntity;
    }


    @GetMapping("/url/large")
    public ResponseEntity<String> getLargeUrl(@RequestParam String  shortUrlParam) {
        Optional<ShortURL> shortURL = urlDAO.findByShortUrlIs(shortUrlParam);
        if(!shortURL.isPresent()){
            ResponseEntity<String> responseEntity = ResponseEntity.ok(shortURL.get().getUrl());
            return responseEntity;
        }
        ResponseEntity<String> responseEntity = ResponseEntity.ok("Url not found");
        return responseEntity;
    }


    @GetMapping("/url/hit/")
    public ResponseEntity<List<String>> getMosturlHit() {
        List<ShortURL> shortURLList = urlDAO.findTop100ByOrderByHitAsc();
        List<String> hitUrl = new ArrayList<>();
        shortURLList.stream().forEach(shortURL -> {
              hitUrl.add(shortURL.getUrl());
        });
        ResponseEntity<List<String>> responseEntity = ResponseEntity.ok(hitUrl);
        return responseEntity;
    }






}

