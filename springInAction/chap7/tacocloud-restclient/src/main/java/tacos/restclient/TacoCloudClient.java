package tacos.restclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.tags.Param;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import tacos.Ingredient;
import tacos.Taco;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 使用一个Map 来指定Url变量
     * */
//    public Ingredient getIngredientById(String ingredientId) {
//        Map<String, String> urlVariables = new HashMap<>();
//        urlVariables.put("id", ingredientId);
//
//        return rest.getForObject("http://localhost:8080/ingredients/{id}",
//                Ingredient.class, urlVariables);
//    }

    // 与上面方法类似
//    public Ingredient getIngredientById(String ingredientId) {
//        Map<String, String> urlVariables= new HashMap<>();
//        urlVariables.put("id", ingredientId);
//
//        URI uri = UriComponentsBuilder
//                .fromHttpUrl("http://localhost:8080/ingredients/{id}")
//                .build(urlVariables);
//        return rest.getForObject(uri, Ingredient.class);
//    }

    /**
     * 替换为getForEntity
     * 返回 ResponseEntity 包含更丰富的信息
     * */
//    public Ingredient getIngredientById(String ingredientId) {
//        ResponseEntity<Ingredient> responseEntity =
//                rest.getForEntity("http://localhost:8080/ingredients/{id}",
//                        Ingredient.class, ingredientId);
//
//        log.info("Fetch time: " +
//                responseEntity.getHeaders().getDate());
//
//        return responseEntity.getBody();
//    }

    public List<Ingredient> getAllIngredients() {
        return rest.exchange("http://localhost:8080/ingredients",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Ingredient>>() {})
                .getBody();
    }

    /**
     * Put
     * */
    public void updateIngredient(Ingredient ingredient) {
        rest.put("http://localhost:8080/ingredients/{id}",
                ingredient, ingredient.getId());
    }

    /**
     * Delete
     * */
    public void deleteIngredient(Ingredient ingredient) {
        rest.delete("http://localhost:8080/ingredients/{id}",
                ingredient.getId());
    }

    /**
     * RestTemplate 有三种方式发送Post请求
     *
     * 如果想接收最新创建的 ingreident 对象, 可以使用postForObject
     * */
    public Ingredient createIngredient(Ingredient ingredient) {
        return rest.postForObject("http://localhost:8080/ingredients",
                ingredient, Ingredient.class);
    }

    /**
     * 如果 client 想要获取最新创建ingredient 的location
     * */
//    public URI createIngredient(Ingredient ingredient) {
//        return rest.postForLocation("http://localhost:8080/ingredients", ingredient);
//    }

    /**
     * 使用 postForEntity
     * */
//    public Ingredient createIngredient(Ingredient ingredient) {
//        ResponseEntity<Ingredient> responseEntity =
//                rest.postForEntity("http://localhost:8080/ingredients",
//                        ingredient,
//                        Ingredient.class);
//
//        log.info("New Resource created at " +
//                responseEntity.getHeaders().getDate());
//
//        return responseEntity.getBody();
//    }

    /**
     * Traverson with restTemplate
     * */
    public Iterable<Ingredient> getAllIngredientsWithTraverson() {
        ParameterizedTypeReference<Resources<Ingredient>> ingredientType =
                new ParameterizedTypeReference<Resources<Ingredient>>() {
                };

        Resources<Ingredient> ingredientRes =
                traverson
                .follow("ingredients")
                .toObject(ingredientType);

        Collection<Ingredient> ingredients = ingredientRes.getContent();

        return ingredients;
    }

    public Ingredient addIngredient(Ingredient ingredient) {
        String ingredientsUrl  = traverson
                .follow("ingredients")
                .asLink()
                .getHref();

        return rest.postForObject(ingredientsUrl,
                ingredient,
                Ingredient.class);
    }

    public Iterable<Taco> getRecentTacosWithTraverson() {
        ParameterizedTypeReference<Resources<Taco>> tacoTypes =
                new ParameterizedTypeReference<Resources<Taco>>() {
                };

        Resources<Taco>  tacoRes =
                traverson
                .follow("tacos")
                .follow("recents")
                .toObject(tacoTypes);

        return tacoRes.getContent();
    }

}
