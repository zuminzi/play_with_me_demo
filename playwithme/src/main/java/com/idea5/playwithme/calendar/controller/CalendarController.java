package com.idea5.playwithme.calendar.controller;


import com.idea5.playwithme.event.domain.Event;
import com.idea5.playwithme.event.domain.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CalendarController {
    @Autowired
    private EventRepository eventRepository;
    private List<Event> events = new ArrayList<>();

    @GetMapping("/event/{category}")
    @ResponseBody
    public String showEvent(Model model, @PathVariable("default=0") Long category) {
        model.addAttribute("category", eventRepository.findByCategoryId(category));
        return "calendar";
    }

    @GetMapping("/events") // 테스트용 // calendar페이지로 이동 안됨
    @ResponseBody
    public String showEventdefault() {
        return "calendar";
    }

}




