package io.sokovets.lllm_test.service;

import io.sokovets.lllm_test.model.Chat;
import io.sokovets.lllm_test.repository.CharRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class ChartService {

  @Autowired
  private CharRepository charRepository;

  public List<Chat> getAllCharts() {
    return charRepository.findAll(Sort.by(Direction.DESC, "createdAt"));
  }

  public Chat getChat(Long chatId) {
    return charRepository.findById(chatId).orElseThrow();
  }

  public Chat createNewChat(String title) {
    Chat chat = Chat.builder().title(title).build();
    return charRepository.save(chat);
  }

  public void deleteChat(Long chatId) {
    charRepository.deleteById(chatId);
  }
}
