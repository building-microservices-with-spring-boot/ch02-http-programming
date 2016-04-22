package com.example.controller;

import com.example.model.Numbers;
import com.example.model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.function.BinaryOperator;

@Controller
public class Calculate {

    @ResponseBody
    @RequestMapping(value = "/compute/function/{type}",
            method = RequestMethod.POST)
    Result compute(@RequestBody Numbers data,
                   @PathVariable String type,
                   @RequestParam(value = "limit") Optional<Integer> limit) {

        if (limit.isPresent()
                && limit.get() < data.getNumbers().size()) {
            data.getNumbers().subList(limit.get(), data.getNumbers().size()).clear();
        }

        BinaryOperator<Integer> f = null;
        if (type.equals("sum")) {
            f = Integer::sum;
        } else if (type.equals("max")) {
            f = Integer::max;
        } else if (type.equals("min")) {
            f = Integer::min;
        }
        Integer result = data.getNumbers().stream().reduce(0, f);
        return new Result(result, type);
    }

}
