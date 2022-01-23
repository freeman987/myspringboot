package com.mygroup.myproject.es.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: EsClientConfig
 * @Description:
 * @Author 吴小田
 * @Date 2022/1/9
 */
@Configuration
public class EsClientConfig {

    @Bean
    public ElasticsearchClient elasticsearchClient(){
        // Create the low-level client
        RestClientBuilder httpClientBuilder = RestClient.builder(
                new HttpHost("127.0.0.1", 9200),
                new HttpHost("127.0.0.1", 9201),
                new HttpHost("127.0.0.1", 9202)
        );

        // Create the HLRC
        RestHighLevelClient hlrc = new RestHighLevelClient(httpClientBuilder);

        // Create the new Java Client with the same low level client
        ElasticsearchTransport transport = new RestClientTransport(
                hlrc.getLowLevelClient(),
                new JacksonJsonpMapper()
        );

        ElasticsearchClient esClient = new ElasticsearchClient(transport);
        // hlrc and esClient share the same httpClient
        return esClient;
    }

    /*
    Migrating from the High Level Rest Clientedit
The Elasticsearch Java API Client is an entirely new client library that has no relation to the older High Level Rest Client (HLRC).
This was a deliberate choice to provide a library that is independent from the Elasticsearch server code and that provides a very consistent and easier to use API for all Elasticsearch features.
Migrating from the HLRC therefore requires some code rewrite in your application.
This transition can however happen progressively as the two client libraries can coexist in a single application with no operational overhead.

从高级 Rest 客户端迁移编辑
Elasticsearch Java API Client 是一个全新的客户端库，
与旧的 High Level Rest Client (HLRC) 没有任何关系。
这是一个深思熟虑的选择，它提供了一个独立于 Elasticsearch 服务器代码的库，
并为所有 Elasticsearch 功能提供了一个非常一致且更易于使用的 API。
因此，从 HLRC 迁移需要在您的应用程序中重写一些代码。
然而，这种转变可以逐步发生，因为两个客户端库可以在一个应用程序中共存而没有操作开销。
     */


}
