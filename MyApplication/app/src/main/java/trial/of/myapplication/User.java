package trial.of.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by User on 6/26/2017.
 */

public class User {

    private String username;
    private String email;
    private int bpx;
    private int ucx;
    private int newn;
    private int spins;
    private int spinsads;

    public User(){

    }

    public User(String username, String email, int bpx, int ucx, int newn, int spins, int spinsads) {
        this.username = username;
        this.email = email;
        this.bpx = bpx;
        this.ucx = ucx;
        this.newn = newn;
        this.spins = spins;
        this.spinsads = spinsads;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBpx() {
        return bpx;
    }

    public void setBpx(int bpx) {
        this.bpx = bpx;
    }

    public int getUcx() {
        return ucx;
    }

    public void setUcx(int ucx) {
        this.ucx = ucx;
    }

    public int getNewn() {
        return newn;
    }

    public void setNewn(int newn) {
        this.newn = newn;
    }

    public int getSpins() {
        return spins;
    }

    public void setSpins(int spins) {
        this.spins = spins;
    }

    public int getSpinsads() {
        return spinsads;
    }

    public void setSpinsads(int spinsads) {
        this.spinsads = spinsads;
    }
}