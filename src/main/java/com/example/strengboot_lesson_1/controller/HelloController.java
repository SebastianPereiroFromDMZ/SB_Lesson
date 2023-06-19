package com.example.strengboot_lesson_1.controller;

import com.example.strengboot_lesson_1.domain.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
//@ConfigurationProperties("hello")//это первый вариант конфигурации (второй через анотацию Value конкретно над полем) при этом варианте необходим сеттер
public class HelloController {

    @Value("${hello.from:bygaga}")
//здесь указываем полностью как в пропертис файле hello.from, плюс можем указать дефолтное значение(если спринг не нашол значение где либо)через запятые
    private String from;

    @GetMapping("/")
    public String hello() {
        return String.format("Hello from %s", from);
    }

    @PostMapping("/hello")
    public String hello(@RequestBody @Validated Person quest) {//Для десериализации обьекта нужно указать что он пришол в теле запроса это делвется анотацией @RequestBody(
        //в запросе приходит строка джейсона, мы ее десериализуем в наш обьект и уже обращаемся к нему через геттеры )
        return String.format("Hello from %s to name %s age %d",
                from, quest.getName(), quest.getAge());
    }

//    @GetMapping ("/hellol")
//    public String hellol(Person quest) {
//        return String.format("Hello from %s to name %s age %d",
//                from, quest.getName(), quest.getAge());
//    }

    @GetMapping ("/hellol")
    public String hellol(@RequestParam("name") String name,
                         @RequestParam("age") int age) {
        return String.format("Hello from %s to name %s age %d",
                from, name, age);
    }



//    public void setFrom(String from) {
//        this.from = from;
//    }
}
