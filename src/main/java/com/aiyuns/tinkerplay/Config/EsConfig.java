package com.aiyuns.tinkerplay.Config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientOptions;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.aiyuns.tinkerplay.Controller.Service.ServiceImpl.Dao.Repository.EsUserRepository;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
import org.springframework.data.elasticsearch.core.convert.MappingElasticsearchConverter;
import org.springframework.data.elasticsearch.core.mapping.SimpleElasticsearchMappingContext;
import org.springframework.data.elasticsearch.repository.support.ElasticsearchRepositoryFactory;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;


/**
 * @Author: aiYunS
 * @Date: 2023年9月12日, 0012 下午 3:38:29
 * @Description: Elasticsearch配置类
 */
@Configuration
@EnableJpaRepositories("com.aiyuns.tinkerplay.Controller.Service.ServiceImpl.Dao.Repository")
public class EsConfig {

    @Value("${elasticsearch.rest.uris}")
    private String uris;
    @Value("${elasticsearch.rest.port}")
    private int port;

    @Bean(name = "myElasticsearchClient")
    public ElasticsearchClient myElasticsearchClient() {
        // 创建低级客户端
        RestClient restClient = RestClient.builder(new HttpHost(uris, port, "http")).build();
        // 使用 Jackson 映射器创建传输
        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        // 并创建 API 客户端
        return new ElasticsearchClient(transport);
    }

    @Bean("elasticsearchTemplate")
    public ElasticsearchTemplate elasticsearchTemplate() {
        return new ElasticsearchTemplate(myElasticsearchClient());
    }

    @Bean("myEsUserRepository")
    public EsUserRepository myEsUserRepository() {
        RepositoryFactorySupport factory = new ElasticsearchRepositoryFactory(elasticsearchTemplate());
        return factory.getRepository(EsUserRepository.class);
    }

    @Bean
    public ElasticsearchConverter elasticsearchConverter(SimpleElasticsearchMappingContext mappingContext) {
        return new MappingElasticsearchConverter(mappingContext);
    }

    @Bean
    public SimpleElasticsearchMappingContext mappingContext() {
        return new SimpleElasticsearchMappingContext();
    }

}
