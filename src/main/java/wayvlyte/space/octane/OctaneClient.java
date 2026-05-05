package wayvlyte.space.octane;

import discord4j.core.DiscordClient;
import reactor.core.publisher.Mono;

public class OctaneClient {
    public static void Main(String[] args) {
        DiscordClient.create("")
                .withGateway(Gateway -> Mono.empty());
    }
}
