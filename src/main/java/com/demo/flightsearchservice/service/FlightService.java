package com.demo.flightsearchservice.service;

import com.demo.flightsearchservice.model.Flight;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.demo.flightsearchservice.util.DateFormat.YYYY_MM_DD_HH_MM_SS;
import static com.demo.flightsearchservice.util.DateUtil.parseToDate;
import static com.demo.flightsearchservice.util.DateUtil.setTimeToZero;

@Service
public class FlightService {

    private static List<Flight> flightList = new ArrayList<>();

    static {
        flightList.addAll(Arrays.asList(new Flight(
                        "2005",
                        "UA",
                        "IAH",
                        parseToDate(YYYY_MM_DD_HH_MM_SS, "2018-01-31 05:10:00"),
                        "ORD",
                        "2018-01-31T07:57:00",
                        "Airbus A320",
                        925,
                        "02:47",
                        "Arrived at Gate"
                ),
                new Flight(
                        "0638",
                        "UA",
                        "IAH",
                        parseToDate(YYYY_MM_DD_HH_MM_SS, "2018-01-31 07:45:00"),
                        "ORD",
                        "2018-01-31T10:18:00",
                        "Boeing 737-900",
                        925,
                        "02:33",
                        "Arrived at Gate"
                ),
                new Flight("1160",
                        "UA",
                        "IAH",
                        parseToDate(YYYY_MM_DD_HH_MM_SS, "2018-01-31 12:05:00"),
                        "ORD",
                        "2018-01-31T14:38:00",
                        "Boeing 737-800",
                        925,
                        "02:41",
                        "Arrived at Gate"),
                new Flight("1256",
                        "UA",
                        "IAH",
                        parseToDate(YYYY_MM_DD_HH_MM_SS, "2018-01-31 14:22:00"),
                        "ORD",
                        "2018-01-31T17:01:00",
                        "Boeing 737-800",
                        925,
                        "02:41",
                        "On Time"),
                new Flight("2153",
                        "UA",
                        "IAH",
                        parseToDate(YYYY_MM_DD_HH_MM_SS, "2018-01-31 16:24:00"),
                        "ORD",
                        "2018-01-31T19:27:00",
                        "Boeing 737-800",
                        925,
                        "02:47",
                        "On Time"),
                new Flight("2155",
                        "UA",
                        "IAH",
                        parseToDate(YYYY_MM_DD_HH_MM_SS, "2018-01-31 18:10:00"),
                        "ORD",
                        "2018-01-31T20:49:00",
                        "Boeing 737-900",
                        925,
                        "02:39",
                        "On Time"),
                new Flight("2131",
                        "UA",
                        "IAH",
                        parseToDate(YYYY_MM_DD_HH_MM_SS, "2018-01-31 19:49:00"),
                        "ORD",
                        "2018-01-31T22:00:00",
                        "Boeing 737-900",
                        925,
                        "02:31",
                        "On Time"),
                new Flight("2043",
                        "UA",
                        "ORD",
                        parseToDate(YYYY_MM_DD_HH_MM_SS, "2018-01-31 06:08:00"),
                        "IAH",
                        "2018-01-31T08:42:00",
                        "Boeing 737-800",
                        925,
                        "02:34",
                        "Arrived at Gate"),
                new Flight("0748",
                        "UA",
                        "ORD",
                        parseToDate(YYYY_MM_DD_HH_MM_SS, "2018-01-31 08:10:00"),
                        "IAH",
                        "2018-01-31T10:44:00",
                        "Boeing 737-900",
                        925,
                        "02:34",
                        "Arrived at Gate"),
                new Flight("2166",
                        "UA",
                        "ORD",
                        parseToDate(YYYY_MM_DD_HH_MM_SS, "2018-01-31 10:15:00"),
                        "IAH",
                        "2018-01-31T12:53:00",
                        "Airbus A320",
                        925,
                        "02:34",
                        "Arrived at Gate"),
                new Flight("2171",
                        "UA",
                        "ORD",
                        parseToDate(YYYY_MM_DD_HH_MM_SS, "2018-01-31 12:45:00"),
                        "IAH",
                        "2018-01-31T15:34:00",
                        "Airbus A320",
                        925,
                        "02:39",
                        "On Time"),
                new Flight("1128",
                        "UA",
                        "ORD",
                        parseToDate(YYYY_MM_DD_HH_MM_SS, "2018-01-31 14:05:00"),
                        "IAH",
                        "2018-01-31T16:52:00",
                        "Boeing 737-800",
                        925,
                        "02:41",
                        "On Time")
        ));
    }


    public List<Flight> find(String flightNumber, Date departure) {

        System.out.println("flightNumber: " + flightNumber);
        System.out.println("departure: " + departure);

        return flightList
                .stream()
                .filter(f -> f.getFlightNumber().equals(flightNumber) &&
                             setTimeToZero(f.getDeparture()).equals(setTimeToZero(departure)))
                .collect(Collectors.toList());
    }

    public List<Flight> find(String origin, String destination, Date departure) {
        return flightList
                .stream()
                .filter(f -> f.getOrigin().equals(origin) &&
                             f.getDestination().equals(destination) &&
                             setTimeToZero(f.getDeparture()).equals(setTimeToZero(departure))).collect(Collectors.toList());
    }


}
