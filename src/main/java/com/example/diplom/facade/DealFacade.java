package com.example.diplom.facade;


import com.example.diplom.model.Ownership;
import com.example.diplom.model.Root;
import com.example.diplom.model.User;
import com.example.diplom.service.DealService;
import com.example.diplom.service.OwnershipService;
import com.example.diplom.service.RootService;
import com.example.diplom.service.UserService;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DealFacade {

    private final UserService userService;
    private final OwnershipService ownershipService;
    private final RootService rootService;
    private final DealService dealService;

    @Cacheable(value = "user", unless = "#result == null")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @Cacheable("ownerShips")
    public List<Ownership> getOwnerShips(List<String> names) {
        return ownershipService.getOwnerShipsByName(names);
    }

    @Cacheable("root")
    public Root getRoot(String numberCadastr) {
        return rootService.getRoot(numberCadastr);
    }

    @Cacheable("deal")
    public C getDeals(Integer buyerId, List<Integer> sellersIds) {
        return new C("string", 2, LocalDate.of(2222, 2, 2), List.of("sss", "sss"), Map.of("q", "s"));
//        return dealService.getDeals(buyerId, sellersIds);
    }

    @Data
    public static class C {
        String a;
        Integer i;
        LocalDate l;
        List<String> ss;
        Map<String, String> map;

        @JsonCreator
        public C(@JsonProperty("a") String a, @JsonProperty("i") Integer i, @JsonProperty("l") LocalDate l, @JsonProperty("ss") List<String> ss, @JsonProperty("map") Map<String, String> map) {
            this.a = a;
            this.i = i;
            this.l = l;
            this.ss = ss;
            this.map = map;
        }
    }

    public Ownership saveOrUpdateOwnreship(Ownership ownership) {
        return ownershipService.saveOrUpdate(ownership);
    }

    public Root saveOrUpdateRoot(Root root) {
        return rootService.saveOrUpdate(root);
    }
}
