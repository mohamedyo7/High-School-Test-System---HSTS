package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "metrics", schema = "sys", catalog = "")
public class MetricsEntity {
    @Basic
    @Column(name = "Variable_name")
    private String variableName;
    @Basic
    @Column(name = "Variable_value")
    private String variableValue;
    @Basic
    @Column(name = "Type")
    private String type;
    @Basic
    @Column(name = "Enabled")
    private String enabled;

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableValue() {
        return variableValue;
    }

    public void setVariableValue(String variableValue) {
        this.variableValue = variableValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetricsEntity that = (MetricsEntity) o;

        if (variableName != null ? !variableName.equals(that.variableName) : that.variableName != null) return false;
        if (variableValue != null ? !variableValue.equals(that.variableValue) : that.variableValue != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (enabled != null ? !enabled.equals(that.enabled) : that.enabled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = variableName != null ? variableName.hashCode() : 0;
        result = 31 * result + (variableValue != null ? variableValue.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }
}
