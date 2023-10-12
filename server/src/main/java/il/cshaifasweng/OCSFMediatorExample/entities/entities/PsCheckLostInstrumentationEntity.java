package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ps_check_lost_instrumentation", schema = "sys", catalog = "")
public class PsCheckLostInstrumentationEntity {
    @Basic
    @Column(name = "variable_name")
    private String variableName;
    @Basic
    @Column(name = "variable_value")
    private String variableValue;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PsCheckLostInstrumentationEntity that = (PsCheckLostInstrumentationEntity) o;

        if (variableName != null ? !variableName.equals(that.variableName) : that.variableName != null) return false;
        if (variableValue != null ? !variableValue.equals(that.variableValue) : that.variableValue != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = variableName != null ? variableName.hashCode() : 0;
        result = 31 * result + (variableValue != null ? variableValue.hashCode() : 0);
        return result;
    }
}
