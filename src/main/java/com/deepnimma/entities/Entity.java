package com.deepnimma.entities;

public class Entity {
    // Basic Info
    public String name;
    public String publisher;

    // Serialization Information
    // ---> Essentially checking if this entity is part of a series
    public boolean series = false;
    public String seriesName = null;
    public int seriesPosition = -1;

    // Foreign Entity
    public String ogLang = "English";
    public String[] translators = null;
    public String translatorCountry = "United States";

    // Release Information
    public int rYear;
    public int rMonth; // 0 index based
    public int rDay;

    // Price Information
    public int priceListed;
    public int pricePaid;
} // Entity
