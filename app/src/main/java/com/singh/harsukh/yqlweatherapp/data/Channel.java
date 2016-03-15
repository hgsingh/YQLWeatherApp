
package com.singh.harsukh.yqlweatherapp.data;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Channel {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("atmosphere")
    @Expose
    private Atmosphere atmosphere;
    @SerializedName("astronomy")
    @Expose
    private Astronomy astronomy;
    @SerializedName("item")
    @Expose
    private Item item;

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The wind
     */
    public Wind getWind() {
        return wind;
    }

    /**
     * 
     * @param wind
     *     The wind
     */
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    /**
     * 
     * @return
     *     The atmosphere
     */
    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    /**
     * 
     * @param atmosphere
     *     The atmosphere
     */
    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    /**
     * 
     * @return
     *     The astronomy
     */
    public Astronomy getAstronomy() {
        return astronomy;
    }

    /**
     * 
     * @param astronomy
     *     The astronomy
     */
    public void setAstronomy(Astronomy astronomy) {
        this.astronomy = astronomy;
    }

    /**
     * 
     * @return
     *     The item
     */
    public Item getItem() {
        return item;
    }

    /**
     * 
     * @param item
     *     The item
     */
    public void setItem(Item item) {
        this.item = item;
    }

}
