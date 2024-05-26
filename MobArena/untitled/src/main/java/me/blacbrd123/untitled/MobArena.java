package me.blacbrd123.untitled;

import me.blacbrd123.untitled.commands.StartMobWaveCommand;
import me.blacbrd123.untitled.listeners.*;
import me.blacbrd123.untitled.waveHolder.WaveInitialiser;
import me.blacbrd123.untitled.waveKits.KitManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public final class MobArena extends JavaPlugin {

    // Used to check if players have the kit inventory open
    private final HashMap<UUID, Boolean> playerHasKitInventoryOpen = new HashMap<>();

    // Stores which player has which kit equipped
    private final HashMap<UUID, String> playerKitChosen = new HashMap<>();

    private FileConfiguration waves = null;
    private final ArrayList<EntityType> mobsAlive = new ArrayList<>();

    private int currentWave = 1;

    private WaveInitialiser waveInitialiser;
    private KitManager kitManager;

    public FileConfiguration getWaves(){
        return waves;
    }

    public HashMap<UUID, Boolean> getPlayerHasKitInventoryOpen() {
        return playerHasKitInventoryOpen;
    }

    public HashMap<UUID, String> getPlayerKitChosen() {
        return playerKitChosen;
    }

    public ArrayList<EntityType> getMobsAlive(){
        return mobsAlive;
    }

    public WaveInitialiser getWaveInitialiser(){
        return waveInitialiser;
    }

    public KitManager getKitManager() {
        return kitManager;
    }

    public int getCurrentWave(){
        return currentWave;
    }

    public void setCurrentWave(int currentWave){
        this.currentWave = currentWave;
    }

    @Override
    public void onEnable() {

        this.waveInitialiser = new WaveInitialiser(this);
        this.kitManager = new KitManager();

        listenerLoader();
        commandLoader();

        File file = new File(this.getDataFolder(), "waves.yml");

        this.waves = YamlConfiguration.loadConfiguration(file);

    }


    public void listenerLoader(){
        getServer().getPluginManager().registerEvents(new KitInventoryClickListener(this, waveInitialiser, kitManager), this);
        getServer().getPluginManager().registerEvents(new OnKitInventoryCloseListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathDuringWavesListener(this), this);
        getServer().getPluginManager().registerEvents(new MobDeathListener(this, waveInitialiser), this);
        getServer().getPluginManager().registerEvents(new EntitySpawnListener(this), this);
    }

    public void commandLoader(){

        Objects.requireNonNull(getCommand("startWave")).setExecutor(new StartMobWaveCommand(this));

    }


    @Override
    public void onDisable() {
        this.playerHasKitInventoryOpen.clear();
        this.playerKitChosen.clear();
    }
}
