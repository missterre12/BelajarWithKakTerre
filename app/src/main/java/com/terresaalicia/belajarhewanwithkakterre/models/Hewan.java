package com.terresaalicia.belajarhewanwithkakterre.models;

public class Hewan {
    private String NamaHewan;
    private String SuaraHewan;
    private int SuaraWavId;
    private int GambarHewan;
    public Hewan(String Nama, String Suara, Integer SuaraWav, Integer Gambar) {
        this.NamaHewan = Nama;
        this.SuaraHewan = Suara;
        this.SuaraWavId = SuaraWav;
        this.GambarHewan = Gambar;
    }

    public String GetNama() {
        return NamaHewan;
    }

    public String GetSuara() {
        return SuaraHewan;
    }

    public int GetSuaraWavId() {
        return SuaraWavId;
    }

    public int GetGambarHewan() { // Tambahkan ini
        return GambarHewan;
    }
}