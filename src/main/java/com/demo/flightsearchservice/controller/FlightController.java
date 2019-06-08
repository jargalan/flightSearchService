package com.demo.flightsearchservice.controller;

import com.demo.flightsearchservice.model.Flight;
import com.demo.flightsearchservice.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.demo.flightsearchservice.util.DateFormat.YYYY_MM_DD;
import static com.demo.flightsearchservice.util.DateUtil.parseToDate;


@RestController
@CrossOrigin(origins = "*")
public class FlightController {

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flights/{flightNumber}/{departure}")
    public List<Flight> getFlights(@PathVariable String flightNumber, @PathVariable String departure) {
        return flightService.find(flightNumber, parseToDate(YYYY_MM_DD, departure));
    }

    @GetMapping("/flights/{origin}/{destination}/{departure}")
    public List<Flight> getFlights(@PathVariable String origin, @PathVariable String destination, @PathVariable String departure) {
        return flightService.find(origin, destination, parseToDate(YYYY_MM_DD, departure));
    }

}