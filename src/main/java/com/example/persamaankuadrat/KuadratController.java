package com.example.persamaankuadrat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KuadratController {

    @GetMapping(value = "/kuadrat", produces = "text/plain")
    public String hitungKuadrat(
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam double c) {

        if (a == 0) {
            return "Nilai a tidak boleh 0 karena bukan persamaan kuadrat.";
        }

        double diskriminan = (b * b) - (4 * a * c);

        if (diskriminan < 0) {
            return "Persamaan kuadrat tidak mempunyai akar real.";
        }

        if (diskriminan == 0) {
            double x = -b / (2 * a);
            return "Persamaan kuadrat memiliki satu akar:\n"
                    + "x = " + x;
        }

        double x1 = (-b + Math.sqrt(diskriminan)) / (2 * a);
        double x2 = (-b - Math.sqrt(diskriminan)) / (2 * a);

        return "Persamaan kuadrat memiliki dua akar:\n"
                + "x1 = " + x1 + "\n"
                + "x2 = " + x2;
    }
}
