package io.sokovets.lllm_test.repository;

import io.sokovets.lllm_test.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharRepository extends JpaRepository<Chat, Long> {

}
