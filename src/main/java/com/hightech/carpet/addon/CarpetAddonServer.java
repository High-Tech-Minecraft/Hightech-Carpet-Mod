package com.hightech.carpet.addon;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;

public class CarpetAddonServer implements CarpetExtension {
    @Override
    public String version()
    {
        return "modid";
    }

    public static void noop() {}

    static
    {
        CarpetServer.manageExtension(new CarpetAddonServer());
        // temporary until CM proper runs tiny bit later
        //CarpetServer.settingsManager.parseSettingsClass(CarpetAddonSettings.class);
    }

    @Override
    public void onGameStarted()
    {
        // let's /carpet handle our few simple settings
        CarpetServer.settingsManager.parseSettingsClass(CarpetAddonSettings.class);

        // set-up a snooper to observe how rules are changing in carpet
        CarpetServer.settingsManager.addRuleObserver( (serverCommandSource, currentRuleState, originalUserTest) ->
        {
            // here we will be snooping for command changes
        });
    }

    @Override
    public void onServerLoaded(MinecraftServer server)
    {
        // reloading of /carpet settings is handled by carpet
        // reloading of own settings is handled as an extension, since we claim own settings manager
        // in case something else falls into
    }

    @Override
    public void onTick(MinecraftServer server)
    {
        // maybe, maybe
    }

    @Override
    public void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher)
    {
        // here goes extra stuff
    }

    @Override
    public void onPlayerLoggedIn(ServerPlayerEntity player)
    {
        // will need that for client features
    }

    @Override
    public void onPlayerLoggedOut(ServerPlayerEntity player)
    {
        // will need that for client features
    }

    //@Override
    //public Map<String, String> canHasTranslations(String lang)
    //{
    //    return CarpetExtraTranslations.getTranslationFromResourcePath(lang);
    //}
}
