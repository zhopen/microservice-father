package com.hpe.father;

import org.apache.http.client.fluent.Request;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.management.ManagementFactory;

@RestController
public class FatherController {
    @RequestMapping("/son/where")
    public String where() throws IOException{
        String where = ManagementFactory.getRuntimeMXBean().getName();

        return "Father is at" + where + " ---- Son： " + Request.Get("http://127.0.0.1:10100/where").execute().returnContent().toString();
    }
}

