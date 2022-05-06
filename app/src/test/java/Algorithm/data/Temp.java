package Algorithm.data;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "day",
    "min",
    "max",
    "night",
    "eve",
    "morn"
})
@Generated("jsonschema2pojo")
public class Temp {

    @JsonProperty("day")
    private Double day;
    @JsonProperty("min")
    private Double min;
    @JsonProperty("max")
    private Double max;
    @JsonProperty("night")
    private Double night;
    @JsonProperty("eve")
    private Double eve;
    @JsonProperty("morn")
    private Double morn;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("day")
    public Double getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(Double day) {
        this.day = day;
    }

    @JsonProperty("min")
    public Double getMin() {
        return min;
    }

    @JsonProperty("min")
    public void setMin(Double min) {
        this.min = min;
    }

    @JsonProperty("max")
    public Double getMax() {
        return max;
    }

    @JsonProperty("max")
    public void setMax(Double max) {
        this.max = max;
    }

    @JsonProperty("night")
    public Double getNight() {
        return night;
    }

    @JsonProperty("night")
    public void setNight(Double night) {
        this.night = night;
    }

    @JsonProperty("eve")
    public Double getEve() {
        return eve;
    }

    @JsonProperty("eve")
    public void setEve(Double eve) {
        this.eve = eve;
    }

    @JsonProperty("morn")
    public Double getMorn() {
        return morn;
    }

    @JsonProperty("morn")
    public void setMorn(Double morn) {
        this.morn = morn;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Temp.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("day");
        sb.append('=');
        sb.append(((this.day == null)?"<null>":this.day));
        sb.append(',');
        sb.append("min");
        sb.append('=');
        sb.append(((this.min == null)?"<null>":this.min));
        sb.append(',');
        sb.append("max");
        sb.append('=');
        sb.append(((this.max == null)?"<null>":this.max));
        sb.append(',');
        sb.append("night");
        sb.append('=');
        sb.append(((this.night == null)?"<null>":this.night));
        sb.append(',');
        sb.append("eve");
        sb.append('=');
        sb.append(((this.eve == null)?"<null>":this.eve));
        sb.append(',');
        sb.append("morn");
        sb.append('=');
        sb.append(((this.morn == null)?"<null>":this.morn));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
