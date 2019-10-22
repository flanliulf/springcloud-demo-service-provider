package com.fancyliu.springcloud.demo.provider.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product/demo")
@Slf4j
public class DemoController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/instance-info")
    public String info() {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("SERVICE-PROVIDER", false);

        log.info("/instance-info, host name ={}, port={}, app name={}, home page url={}",
                instanceInfo.getHostName(), instanceInfo.getPort(),
                instanceInfo.getAppName(), instanceInfo.getHomePageUrl());

        return "success";
    }

    @GetMapping("/service-instance")
    public String serviceInstance() {
        List<ServiceInstance> instances = discoveryClient.getInstances("SERVICE-PROVIDER");

        if (instances != null && instances.size() > 0) {
            ServiceInstance serviceInstance = instances.get(0);
            String host = serviceInstance.getHost();
            String instanceId = serviceInstance.getInstanceId();
            int port = serviceInstance.getPort();
            String serviceId = serviceInstance.getServiceId();
            URI uri = serviceInstance.getUri();
            Map<String, String> metadata = serviceInstance.getMetadata();
            String scheme = serviceInstance.getScheme();

            log.info("/service-instance, host name ={}, port={}, instance id={}, " +
                            "serviceId={}, uri={}, metadata={}, scheme={}",
                    host, port, instanceId, serviceId, uri, metadata, scheme);
        }

        return "success";
    }
}
