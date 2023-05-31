/*******************************************************************************
 * Copyright (c) 2023 Viking Cloud, LLC - All Rights Reserved.
 *
 * Proprietary and confidential information of Viking Cloud, LLC.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 *******************************************************************************/
package spring.people.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.people.model.ShortURL;

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
@Repository
public interface UrlDAO extends JpaRepository<ShortURL, Integer> {

    Optional<ShortURL> findByShortUrlIs(String shortUrl);

    List<ShortURL> findTop100ByOrderByHitAsc();


}



