package me.blacbrd123.untitled.waveKits;

import java.util.Set;

public class KitManager {

    private Set<Kit> kitSet;
    private final KnightKit knightKit = new KnightKit();
    private final ArcherKit archerKit = new ArcherKit();
    private  final LumberjackKit lumberjackKit = new LumberjackKit();

    public KitManager(){

        this.kitSet.add(knightKit);
        this.kitSet.add(archerKit);
        this.kitSet.add(lumberjackKit);

    }
    public Set<Kit> getKitSet(){
        return kitSet;
    }

    public KnightKit getKnightKit(){
        return knightKit;
    }

    public ArcherKit getArcherKit(){
        return archerKit;
    }

    public LumberjackKit getLumberjackKit(){
        return lumberjackKit;
    }
    

    
}


