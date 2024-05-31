package ru.practicalwork.task1;

import java.util.HashMap;
import java.util.Map;

public class SaveAccVersion {
    private Map<String, SaveAccountBuild> saveAccountBuild = new HashMap<>();

    public SaveAccountBuild getSaveAccountBuild(String nameSave) {
        return this.saveAccountBuild.get(nameSave);
    }

    public void setSaveAccountBuild(String nameSave, SaveAccountBuild saveAccountBuild) {
        if (this.saveAccountBuild.containsKey(nameSave))
            throw new RuntimeException("Указанное имя сейфа занято");
        this.saveAccountBuild.put(nameSave, saveAccountBuild);
    }
}
