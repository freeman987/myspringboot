package com.mygroup.myproject.es.controller;

import co.elastic.clients.elasticsearch.ElasticsearchAsyncClient;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
//import co.elastic.clients.elasticsearch.indices.Alias;
//import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch._types.SortOrder;

import co.elastic.clients.elasticsearch._types.aggregations.Aggregation;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
//import org.elasticsearch.action.index.IndexRequest;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.client.RequestOptions;
import com.alibaba.fastjson.JSONObject;
import com.mygroup.myproject.es.entity.SomeApplicationData;
//import com.mygroup.myproject.es.mapper.SomeApplicationDataMapper;
import com.mygroup.myproject.es.mapper.SomeApplicationDataMapper;
import org.elasticsearch.action.index.IndexRequest;
//import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: EsControllerHighLevel
 * @Description:
 * @Author 吴小田
 * @Date 2022/1/9
 */
@RestController
@RequestMapping("/hello2")
public class EsController {

    @Autowired
    ElasticsearchClient elasticsearchClient;

    @Resource
    SomeApplicationDataMapper someApplicationDataMapper;


//http://127.0.0.1:8080/hello1/hello2/searchesindex?name=goodname
    @GetMapping("/searchesindex")
    public List<SomeApplicationData> findAvailableBookByName(@RequestParam(value="name")String name) {
        return someApplicationDataMapper.findByName(name);
    }



    //http://127.0.0.1:8080/hello1/hello2/searchesindex?name=goodname
    @GetMapping("/searchesindex2")
    public Page<SomeApplicationData> findAvailableBookByName2(@RequestParam(value="name")String name) {
        //name如果是text类型就不能排序。
        Pageable pageable= PageRequest.of(0,100, Sort.by(Sort.Direction.ASC, "name"));
        Page<SomeApplicationData> books = someApplicationDataMapper.findByName(name,pageable);
//        Iterator<SomeApplicationData> goodsIterator = goodsPage.iterator();
//        int count=0;
//        while (goodsIterator.hasNext()){
//            SomeApplicationData someApplicationData = goodsIterator.next();
//            System.out.println(someApplicationData);
//            count++;
//        }
//        System.out.println(count);

        return books;
    }


    @GetMapping("/createesindex")
    public int createesindex()  {
        try{
//        CreateIndexResponse createResponse = elasticsearchClient2.indices().create(
//                new CreateIndexRequest.Builder()
//                        .index("my-index")
//                        .aliases("foo",new Alias.Builder().isWriteIndex(true).build())
//                        .build()
//        );



            CreateIndexResponse createResponse = elasticsearchClient.indices()
                    .create(createIndexBuilder -> createIndexBuilder
                            .index("my-index")
                            .aliases("foo", aliasBuilder -> aliasBuilder.isWriteIndex(true)
                            )
                    );



//            SearchResponse<SomeApplicationData> results = elasticsearchClient
//                    .search(_0 -> _0
//                                    .query(_1 -> _1
//                                            .intervals(_2 -> _2
//                                                    .field("my_text")
//                                                    .allOf(_3 -> _3
//                                                            .ordered(true)
//                                                            .intervals(_4 -> _4
//                                                                    .match(_5 -> _5
//                                                                            .query("my favorite food")
//                                                                            .maxGaps(0)
//                                                                            .ordered(true)
//                                                                    )
//                                                            )
//                                                            .intervals(_4 -> _4
//                                                                    .anyOf(_5 -> _5
//                                                                            .intervals(_6 -> _6
//                                                                                    .match(_7 -> _7
//                                                                                            .query("hot water")
//                                                                                    )
//                                                                            )
//                                                                            .intervals(_6 -> _6
//                                                                                    .match(_7 -> _7
//                                                                                            .query("cold porridge")
//                                                                                    )
//                                                                            )
//                                                                    )
//                                                            )
//                                                    )
//                                            )
//                                    ),
//                            SomeApplicationData.class
//                    );




//// Prepare a list of index names
//            List<String> names = Arrays.asList("idx-a", "idx-b", "idx-c");
//// Prepare cardinality aggregations for fields "foo" and "bar"
//            Map<String, Aggregation> cardinalities = new HashMap<>();
//            cardinalities.put("foo-count", Aggregation.of(a -> a.cardinality(c -> c.field("foo"))));
//            cardinalities.put("bar-count", Aggregation.of(a -> a.cardinality(c -> c.field("bar"))));
//// Prepare an aggregation that computes the average of the "size" field
//            final Aggregation avgSize = Aggregation.of(a -> a.avg(v -> v.field("size")));
//            SearchRequest search = SearchRequest.of(r -> r
//                    // Index list:
//                    // - add all elements of a list
//                    .index(names)
//                    // - add a single element
//                    .index("idx-d")
//                    // - add a vararg list of elements
//                    .index("idx-e", "idx-f", "idx-g")
//                    // Sort order list: add elements defined by builder lambdas
//                    .sort(s -> s.field(f -> f.field("foo").order(SortOrder.Asc)))
//                    .sort(s -> s.field(f -> f.field("bar").order(SortOrder.Desc)))
//                    // Aggregation map:
//                    // - add all entries of an existing map
//                    .aggregations(cardinalities)
//                    // - add a key/value entry
//                    .aggregations("avg-size", avgSize)
//                    // - add a key/value defined by a builder lambda
//                    .aggregations("price-histogram",
//                            a -> a.histogram(h -> h.field("price")))
//            );



//            Query query = new Query.Builder()
//                    .term(t -> t.field("name").value(v -> v.stringValue("foo"))
//                    ).build();



//            // Synchronous blocking client
//            ElasticsearchClient client = new ElasticsearchClient(transport);
//            if (client.exists(b -> b.index("products").id("foo")).value()) {
//                logger.info("product exists");
//            }
//            // Asynchronous non-blocking client
//            ElasticsearchAsyncClient asyncClient =new ElasticsearchAsyncClient(transport);
//            asyncClient.exists(b -> b.index("products").id("foo"))
//                    .thenAccept(response -> {
//                        if (response.value()) {
//                            logger.info("product exists");
//                        }
//                    });


//            SearchResponse<SomeApplicationData> search = elasticsearchClient.search(s -> s
//                            .index("products")
//                            .query(q -> q
//                                    .term(t -> t
//                                            .field("name")
//                                            .value(v -> v.stringValue("bicycle"))
//                                    )),
//                    SomeApplicationData.class);
//
//            for (Hit<SomeApplicationData> hit: search.hits().hits()) {
//                processProduct(hit.source());
//            }


//            System.out.println("----");

        }catch (IOException e){

        }
        return 0;
    }




}
