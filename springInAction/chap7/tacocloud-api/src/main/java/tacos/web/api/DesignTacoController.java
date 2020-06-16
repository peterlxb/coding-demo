package tacos.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tacos.Order;
import tacos.Taco;
import tacos.data.TacoRepository;

import java.util.List;
import java.util.Optional;

@RestController                     // 使用 RestController 注解
@RequestMapping(path="/design",     // 处理 /design 的请求
                produces="application/json")
@CrossOrigin(origins="*")           // 允许跨域
public class DesignTacoController {

    private TacoRepository tacoRepo;

    @Autowired
    EntityLinks entityLinks;

    public DesignTacoController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

//    @GetMapping("/recent")
//    public Resources<Resource<Taco>> recentTacos() {
//        PageRequest page = PageRequest.of(
//                0, 12, Sort.by("createdAt").descending());

//        List<Taco> tacos = tacoRepo.findAll(page).getContent();
//        Resources<Resource<Taco>> recentResources = Resources.wrap(tacos);

        // HardCode 链接方式不推荐
//        recentResources.add(
//                new Link("http://localhost:8080/design/recent","recents")
//        );

        // 使用 ControllerLinkBuilder
//        recentResources.add(
//                ControllerLinkBuilder.linkTo(DesignTacoController.class)
//                .slash("recent")
//                .withRel("recents")
//        );

//        return recentResources;
//    }

    /**
     * 获取数据并返回最近的taco designs
     * */
    @GetMapping("/recent")
    public Iterable<Taco> recentTacos() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());

        return tacoRepo.findAll(page).getContent();
    }

    // 旧的方法, 无法返回适当的状态码
//    @GetMapping("/{id}")
//    public Taco tacoById(@PathVariable("id") Long id) {
//        Optional<Taco> optTaco = tacoRepo.findById(id);
//
//        if (optTaco.isPresent()) {
//            return optTaco.get();
//        }
//
//        return null;
//    }

    // 根据ID 返回 Taco
    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoRepo.findById(id);

        if (optTaco.isPresent()) {
            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // 处理前端发起的请求
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }


}
