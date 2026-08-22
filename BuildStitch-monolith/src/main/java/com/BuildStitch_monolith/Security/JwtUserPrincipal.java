package com.BuildStitch_monolith.Security;

public record JwtUserPrincipal(
        Long userId,
        String username
) {
}
