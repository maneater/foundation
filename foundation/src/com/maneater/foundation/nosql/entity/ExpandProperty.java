package com.maneater.foundation.nosql.entity;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created by liang on 15/12/5.
 */

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ExpandProperty extends BaseEntity {

    /**
     * title=value;title=value;....
     */
    private String defaultOptions;


    public String getDefaultOptions() {
        return defaultOptions;
    }

    public void setDefaultOptions(String defaultOptions) {
        this.defaultOptions = defaultOptions;
    }
}
