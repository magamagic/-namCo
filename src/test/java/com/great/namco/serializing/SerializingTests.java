package com.great.namco.serializing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.great.namco.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SerializingTests {

    @Test
    public void ObjectMapperTest() throws JsonProcessingException {
        // ObjectMapper 를 생성합니다.
        ObjectMapper objectMapper = new ObjectMapper();

        // 객체를 하나 만듭니다.
        Person person1 = new Person();
        person1.setAge(20);
        person1.setCar("a");
        person1.setName("b");

        // 직렬화 방식입니다. Object를 Json String으로 변환합니다.
        String json1 = objectMapper.writeValueAsString(person1);

        // 역직렬화 방식입니다. Json String을 Object로 변환합니다.
        Person person3 = objectMapper.readValue(json1, Person.class);

        //ㅊㅓ음 만들었던 객체와 동일한 지 비교합니다.
        assertThat(person3).isEqualTo(person1);
    }

    @Test
    public void GsonMapperTest(){
        // Gson을  생성합니다.
        Gson gson = new Gson();

        // 객체를 하나 만듭니다.
        Person person1 = new Person();
        person1.setAge(20);
        person1.setCar("a");
        person1.setName("b");

        // 위에서 만들어둔 객체를 Json String 으로 변환합니다.
        String json2 =  gson.toJson(person1);

        // Json String을 Object로 변환합니다.
        Person person4 = gson.fromJson(json2 , Person.class);

        //ㅊㅓ음 만들었던 객체와 동일한 지 비교합니다.
        assertThat(person4).isEqualTo(person1);
    }

}
