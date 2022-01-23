package com.mygroup.myproject.controller;

import com.mygroup.myproject.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: RestTemplateController
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/9
 * @Version 1.0
 */
@RestController
@RequestMapping("/hello2")
public class RestTemplateController {

//    //第二种：
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
//
//    //第三种
//    @Autowired
//    RestTemplate restTemplate;

    @GetMapping("/testtemplate")
    public Person testtemplate()
    {
        System.out.println("------???-------");
        //1,第一种方式：
        RestTemplate restTemplate = new RestTemplate();
        Person person= restTemplate.getForObject("http://127.0.0.1:8080/hello1/hello2/getperson?id=1",Person.class);
        return person;

//        //2,第二种：
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance serviceInstance=loadBalancerClient.choose("myeurekaclient");
//        String url =String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort())+"/hello1/hello2/getperson?id=1";
//        Person person= restTemplate.getForObject(url,Person.class);
//        return person;

//        //3，第三种：
//        Person person=restTemplate.getForObject("http://myeurekaclient/hello1/hello2/getperson?id=1",Person.class);
//        return person;
    }

    /*
        List<ProfitListVo> weekprofitlist = new ArrayList<>();
        List<ProfitListVo> tradelist = new ArrayList<>();

        //调用大数据接口获取周盈利榜
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String,String> params = new LinkedMultiValueMap<String,String>();
        params.add("htimggcid",starttimes);
        params.add("htimggcid1",endtimes);
        HttpEntity<MultiValueMap<String,String>> formEntity = new HttpEntity<MultiValueMap<String,String>>(params,headers);
        log.info("获取周盈利榜，周交易榜请求参数 htimggcid: {},htimggcid1: {}",starttimes,endtimes);
        ResponseEntity<String> exchange = restTemplate.exchange(PROFITURL, HttpMethod.POST, formEntity, String.class);
        String result = exchange.getBody();

        Map<String,Object> map = JSON.parseObject(result, Map.class);
        if ((boolean)map.get("status")){
            List<Map<String,Object>> list = (List<Map<String,Object>>)map.get("data");
            weekprofitlist = list.stream().map(x->{
                ProfitListVo profitListVo = new ProfitListVo();
                String name = String.valueOf(x.get("nickname"));
                String nickname = StringTransitionUtils.getName(name);
                profitListVo.setNickname(nickname);
                profitListVo.setSellnum(Integer.valueOf(x.get("Sell_quantity").toString()));
                profitListVo.setBuyprice(new BigDecimal(x.get("Average_price").toString()));
                profitListVo.setSellprice(new BigDecimal(x.get("Ave_price").toString()));
                profitListVo.setTotalprofit(new BigDecimal(x.get("total_profit").toString()));
                return profitListVo;
            }).collect(Collectors.toList());
        }
         */

        /*
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Map> formEntity = new HttpEntity<>(headers);
            String result = restTemplate.postForObject(PROFITURL, formEntity, String.class);
         */

        /*
        //拼装请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("sku",req.getSku());
        multiValueMap.add("size",req.getSize());
        multiValueMap.add("type",req.getType());
        HttpEntity requestBody = new HttpEntity(multiValueMap,headers);

        ResponseEntity<Map> mapResp = restTemplate.postForEntity(spiderUrl, requestBody, Map.class);
        log.info("比价请求参数 req:{}获取数据：{}",JSONUtil.toJson(req),JSONUtil.toJson(mapResp));
        Map map = mapResp.getBody();
        List<Map> comparePriceSpiderDtos =(List) map.get("data");
         */

        /*
            //调用大数据接口获取日盈利榜
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Map> formEntity = new HttpEntity<>(headers);
            String result = restTemplate.postForObject(PROFITURL, formEntity, String.class);
            Map<String,Object> map = JSON.parseObject(result, Map.class);
            if ((boolean)map.get("status")){
                List<Map<String,Object>> list = (List<Map<String,Object>>)map.get("data");
                dayprofitlist = list.stream().map(x->{
                    ProfitListVo profitListVo = new ProfitListVo();
                    String name = String.valueOf(x.get("nickname"));
                    String nickname = StringTransitionUtils.getName(name);
                    profitListVo.setNickname(nickname);
                    profitListVo.setSellnum(Integer.valueOf(x.get("Sell_quantity").toString()));
                    profitListVo.setBuyprice(new BigDecimal(x.get("Average_price").toString()));
                    profitListVo.setSellprice(new BigDecimal(x.get("Ave_price").toString()));
                    profitListVo.setTotalprofit(new BigDecimal(x.get("total_profit").toString()));
                    return profitListVo;
                }).collect(Collectors.toList());
                redisTemplate.opsForValue().set(dayKey,dayprofitlist);
                redisTemplate.expire(dayKey,1, TimeUnit.DAYS);
            }
         */

}
