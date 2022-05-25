package com.grootan.parkingmanagement.controller;

import com.grootan.parkingmanagement.model.entity.CustomerDetails;
import com.grootan.parkingmanagement.model.entity.ParkingLot;
import com.grootan.parkingmanagement.model.entity.ParkingSlotReservation;
import com.grootan.parkingmanagement.service.CustomerDetailsService;
import com.grootan.parkingmanagement.service.ParkingLotService;
import com.grootan.parkingmanagement.service.ParkingSlotReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ui")
public class UIController {
    @Autowired
    ParkingSlotReservationService parkingSlotReservationService;

    @Autowired
    ParkingLotService parkingLotService;

    @Autowired
    CustomerDetailsService customerDetailsService;


    @GetMapping("/welcome")
    public String welcome()
    {
        return "welcome";
    }


    @GetMapping("/login")
    public String login(Model model) {
        ParkingLot parkingLot = new ParkingLot();
        model.addAttribute("parkingLot", parkingLot);
        return "login_page";
    }

    @GetMapping("/parkinglot")
    public String displayParkingLot(Model model) {
        ParkingLot parkingLot = new ParkingLot();
        model.addAttribute("parkingLot", parkingLot);
        return "parking_Lot";
    }

    @PostMapping("/parkinglot")
    public String lotCreated(@ModelAttribute("parkingLot") ParkingLot parkingLot) {
        parkingLotService.createParkingLot(parkingLot);
        return "Lot_created";
    }

    @GetMapping("/getParkingAvailable")
    public String getEmptyParkingLots(Model model) {
        List<ParkingLot> result = new ArrayList<>();
        parkingLotService.getParkingLots().forEach(result::add);
        result = result.stream().filter(parking -> parking.isEmpty()).collect(Collectors.toList());
        model.addAttribute("result", result);
        return "get_slot";
    }

    @GetMapping("/getpark")
    public String lotCreated(Model model) {
        CustomerDetails customerDetails1 = new CustomerDetails();
        model.addAttribute("customerDetails", customerDetails1);
        return "get_park";
    }

    @GetMapping("/getLotDetails")
    public String LotDetails() {
        return "get_Parking";
    }

    @GetMapping("/customer/details")
    public String getCustomerDetails(Model model) {
        CustomerDetails customerDetails = new CustomerDetails();
        model.addAttribute("customerDetails", customerDetails);
        return "customer_details";
    }

    @PostMapping("/customer/details")
    public String lotCreated(@ModelAttribute("customerDetails") CustomerDetails customerDetails, Model model) {
        ParkingSlotReservation parkingSlotReservation = parkingSlotReservationService.createParking(customerDetails);
        model.addAttribute("parkingSlotReservation", parkingSlotReservation);
        return "getTicket";
    }

}
