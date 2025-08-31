package io.sokovets.lllm_test.controller;

import io.sokovets.lllm_test.model.Chat;
import io.sokovets.lllm_test.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {

  @Autowired
  private ChartService chatService;

  @GetMapping("/")
  public String mainPage(ModelMap modelMap) {
    modelMap.addAttribute("chats", chatService.getAllCharts());
    return "chat";
  }

  @GetMapping("/chat/{chatId}")
  public String showChat(@PathVariable Long chatId, ModelMap modelMap) {
    modelMap.addAttribute("chats", chatService.getAllCharts());
    modelMap.addAttribute("chat", chatService.getChat(chatId));
    return "chat";
  }

  @PostMapping("/chat/new")
  public String newChat(@RequestParam String title) {
    Chat chat = chatService.createNewChat(title);
    return "redirect:/chat" + chat.getId();
  }

  @PostMapping("chat/{chatId}/delete")
  public String deleteChat(@PathVariable Long chatId) {
    chatService.deleteChat(chatId);
    return "/";
  }

}
