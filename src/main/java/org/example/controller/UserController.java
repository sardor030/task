package org.example.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.example.dto.UserCreateDto;
import org.example.dto.UserUpdateDto;
import org.example.service.UserService;
@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage() {
        return "user/list";
    }
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute UserCreateDto dto) {
        service.create(dto);
        return "redirect:list";
    }
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public String detail(Model model, @PathVariable Long id) {
        model.addAttribute("user", service.get(id));
        return "redirect:list";
    }
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("users", service.getAll());
        return "user/list";
    }
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable Long id) {
        model.addAttribute("userUpdate", service.get(id));
        return "user/update";
    }
    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute UserUpdateDto user) {
        service.update(user);
        return "redirect:/user/list";
    }
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("userId", service.get(id));
        return "user/delete";
    }
    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/user/list";
    }


}
