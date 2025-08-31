package io.sokovets.lllm_test.model;

import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {
  USER("user"), ASSISTANT("assistant"), SYSTEM("system");
  private final String role;

  public static Role getRole(String roleName) {
    return Arrays.stream(Role.values()).filter(role -> role.role.equals(roleName)).findFirst()
        .orElseThrow();
  }

}
