package com.aj.dropwizardmongodb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DropwizardMongoDBConfiguration extends Configuration {

    @NotEmpty
    private String mongoHost;

    @NotNull
    private int mongoPort;

    @NotEmpty
    private String mongoDB;

    @NotEmpty
    private String collectionName;

    @JsonProperty
    public String getMongoHost() {
        return mongoHost;
    }

    @JsonProperty
    public void setMongoHost(String mongoHost) {
        this.mongoHost = mongoHost;
    }

    @JsonProperty
    public int getMongoPort() {
        return mongoPort;
    }

    @JsonProperty
    public void setMongoPort(int mongoPort) {
        this.mongoPort = mongoPort;
    }

    @JsonProperty
    public String getMongoDB() {
        return mongoDB;
    }

    @JsonProperty
    public void setMongoDB(String mongoDB) {
        this.mongoDB = mongoDB;
    }

    @JsonProperty
    public String getCollectionName() {
        return collectionName;
    }

    @JsonProperty
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

}
