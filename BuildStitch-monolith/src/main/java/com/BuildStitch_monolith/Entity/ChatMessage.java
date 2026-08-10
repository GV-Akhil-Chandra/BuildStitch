package com.BuildStitch_monolith.Entity;

import com.BuildStitch_monolith.Entity.Enum.MessageRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Getter
@Setter
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Project project;
    private User user;
    private MessageRole role;

    private String content;
    private String toolCalls;
    private Integer tokensUsed;

    @CreationTimestamp
    private Instant createdAt;
}
