package com.local.naruto.knowledge.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ServerDemoFeignClient", url = "http://localhost:8080")
public interface InvokeServiceClient {

}
