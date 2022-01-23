package com.mygroup.myproject.es.mapper;

import com.mygroup.myproject.es.entity.SomeApplicationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SomeApplicationDataMapper  extends ElasticsearchRepository<SomeApplicationData, String> {

    List<SomeApplicationData> findByName(String name);



//    @Highlight(fields = {
//            @HighlightField(name = "name"),
//            @HighlightField(name = "summary")
//    })

    @Query("{\"match\": {\"name\": {\"query\": \"?0\"}}}")
    Page<SomeApplicationData> findByName(String name, Pageable pageable);
}
