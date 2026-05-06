package wayvlyte.space.octane;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.gateway.intent.Intent;
import discord4j.gateway.intent.IntentSet;
import reactor.core.publisher.Mono;

public class OctaneClient {
    public static GatewayDiscordClient Gateway;

    static void main(String[] args) {
        OctaneConfig.Load();

        DiscordClient Client = DiscordClient.create(OctaneConfig.Get("client.token"));
        Mono<?> Login = Client.gateway()
                .setEnabledIntents(IntentSet.of(
                        Intent.MESSAGE_CONTENT,
                        Intent.GUILD_MEMBERS
                ))
                .withGateway(Gateway -> {
                    OctaneClient.Gateway = Gateway;
                    OctaneEventRegistry.RegisterDiscordEvents(Gateway);
                    return Gateway.onDisconnect();
                });

        Login.block();
    }
}
