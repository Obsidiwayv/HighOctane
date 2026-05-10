package wayvlyte.space.octane;

import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.gateway.intent.Intent;
import discord4j.gateway.intent.IntentSet;
import reactor.core.publisher.Mono;
import wayvlyte.space.octane.Core.OctaneGuild;

import java.util.HashMap;

public class OctaneClient {
    public static GatewayDiscordClient Gateway;

    public static HashMap<String, OctaneGuild> Guilds = new HashMap<>();

    static void main(String[] args) {
        OctaneConfig.Load();

        DiscordClient Client = DiscordClient.create(OctaneConfig.Get("client.token"));
        Mono<?> Login = Client.gateway()
                .setEnabledIntents(IntentSet.of(
                        Intent.MESSAGE_CONTENT,
                        Intent.GUILD_MEMBERS,
                        Intent.GUILDS,
                        Intent.GUILD_MESSAGES
                ))
                .withGateway(Gateway -> {
                    OctaneClient.Gateway = Gateway;
                    OctaneEventRegistry.RegisterDiscordEvents(Gateway);
                    return Gateway.onDisconnect();
                });

        Login.block();
    }

    public static OctaneGuild GetGuild(String ID) {
        // Check if the guild exists, because it won't on when the bot restarts
        // if it doesn't then we go ahead and create a new one
        // Doing this saves memory instead of caching every server on first boot
        if (!Guilds.containsKey(ID)) {
            return Guilds.put(ID, new OctaneGuild(Snowflake.of(ID)));
        }

        return Guilds.get(ID);
    }

    public static void DeleteGuild(String ID) {
        Guilds.remove(ID);
    }
}
