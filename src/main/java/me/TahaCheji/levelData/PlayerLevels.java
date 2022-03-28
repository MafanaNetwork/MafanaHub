package me.TahaCheji.levelData;

import me.TahaCheji.Main;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PlayerLevels {

    public final Player player;

    private Main plugin;

    public PlayerLevels(Player player) {
        this.player = player;
        this.plugin = Main.getInstance();
    }

    public void addXP(UUID uuid, int xp) {
        try {
            PreparedStatement ps = plugin.mySQL.getConnection().prepareStatement("UPDATE playerlevel SET XP=? WHERE UUID=?");
            ps.setInt(1, (getXp(uuid) + xp));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setXp(UUID uuid, int xp) {
        try {
            PreparedStatement ps = plugin.mySQL.getConnection().prepareStatement("UPDATE playerlevel SET XP=? WHERE UUID=?");
            ps.setInt(1, xp);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getXp(UUID uuid) {
        try {
            PreparedStatement ps = plugin.mySQL.getConnection().prepareStatement("SELECT XP FROM playerlevel WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            int xp = 0;
            if(rs.next()) {
                xp = rs.getInt("XP");
                return xp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addLevel(UUID uuid, int lvl) {
        try {
            PreparedStatement ps = plugin.mySQL.getConnection().prepareStatement("UPDATE playerlevel SET LEVEL=? WHERE UUID=?");
            ps.setInt(1, (getXp(uuid) + lvl));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setLevel(UUID uuid, int lvl) {
        try {
            PreparedStatement ps = plugin.mySQL.getConnection().prepareStatement("UPDATE playerlevel SET LEVEL=? WHERE UUID=?");
            ps.setInt(1, lvl);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getLevel(UUID uuid) {
        try {
            PreparedStatement ps = plugin.mySQL.getConnection().prepareStatement("SELECT LEVEL FROM playerlevel WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            int xp = 0;
            if(rs.next()) {
                xp = rs.getInt("LEVEL");
                return xp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Player getPlayer() {
        return player;
    }
}
