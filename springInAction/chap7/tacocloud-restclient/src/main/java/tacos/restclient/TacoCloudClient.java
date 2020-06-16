package tacos.restclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.client.Traverson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tacos.Ingredient;

@Service
@Slf4j
public class TacoCloudClient {

    private RestTemplate rest;
    private Traverson traverson;

    // constructor
    public TacoCloudClient(RestTemplate rest, Traverson traverson) {
        this.rest = rest;
        this.traverson = traverson;
    }

    /**
     * 将参数指定为 varargs 参数
     * getForObject 接收三个参数
     * */
    public Ingredient getIngredientById(String ingredientId) {
        return rest.getForObject("http://localhost:8080/ingredients/{id}",
                Ingredient.class, ingredientId);
    }

}
