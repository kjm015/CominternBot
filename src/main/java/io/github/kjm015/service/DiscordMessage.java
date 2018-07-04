package io.github.kjm015.service;

import lombok.Data;

@Data
public class DiscordMessage {

    private String channelID;
    private String botToken;

    private String baseURL;
}
