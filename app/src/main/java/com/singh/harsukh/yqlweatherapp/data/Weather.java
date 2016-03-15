
package com.singh.harsukh.yqlweatherapp.data;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Weather {

    @SerializedName("query")
    @Expose
    private QueryResult query;

    /**
     * 
     * @return
     *     The query
     */
    public QueryResult getQuery() {
        return query;
    }

    /**
     * 
     * @param query
     *     The query
     */
    public void setQuery(QueryResult query) {
        this.query = query;
    }

}
