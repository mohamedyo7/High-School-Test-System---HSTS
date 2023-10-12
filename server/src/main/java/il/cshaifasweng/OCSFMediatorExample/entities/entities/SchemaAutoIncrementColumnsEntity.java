package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "schema_auto_increment_columns", schema = "sys", catalog = "")
public class SchemaAutoIncrementColumnsEntity {
    @Basic
    @Column(name = "table_schema")
    private String tableSchema;
    @Basic
    @Column(name = "table_name")
    private String tableName;
    @Basic
    @Column(name = "column_name")
    private String columnName;
    @Basic
    @Column(name = "data_type")
    private String dataType;
    @Basic
    @Column(name = "column_type")
    private String columnType;
    @Basic
    @Column(name = "is_signed")
    private int isSigned;
    @Basic
    @Column(name = "is_unsigned")
    private int isUnsigned;
    @Basic
    @Column(name = "max_value")
    private Object maxValue;
    @Basic
    @Column(name = "auto_increment")
    private Object autoIncrement;
    @Basic
    @Column(name = "auto_increment_ratio")
    private BigDecimal autoIncrementRatio;

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public int getIsSigned() {
        return isSigned;
    }

    public void setIsSigned(int isSigned) {
        this.isSigned = isSigned;
    }

    public int getIsUnsigned() {
        return isUnsigned;
    }

    public void setIsUnsigned(int isUnsigned) {
        this.isUnsigned = isUnsigned;
    }

    public Object getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Object maxValue) {
        this.maxValue = maxValue;
    }

    public Object getAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(Object autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public BigDecimal getAutoIncrementRatio() {
        return autoIncrementRatio;
    }

    public void setAutoIncrementRatio(BigDecimal autoIncrementRatio) {
        this.autoIncrementRatio = autoIncrementRatio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchemaAutoIncrementColumnsEntity that = (SchemaAutoIncrementColumnsEntity) o;

        if (isSigned != that.isSigned) return false;
        if (isUnsigned != that.isUnsigned) return false;
        if (tableSchema != null ? !tableSchema.equals(that.tableSchema) : that.tableSchema != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (columnName != null ? !columnName.equals(that.columnName) : that.columnName != null) return false;
        if (dataType != null ? !dataType.equals(that.dataType) : that.dataType != null) return false;
        if (columnType != null ? !columnType.equals(that.columnType) : that.columnType != null) return false;
        if (maxValue != null ? !maxValue.equals(that.maxValue) : that.maxValue != null) return false;
        if (autoIncrement != null ? !autoIncrement.equals(that.autoIncrement) : that.autoIncrement != null)
            return false;
        if (autoIncrementRatio != null ? !autoIncrementRatio.equals(that.autoIncrementRatio) : that.autoIncrementRatio != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tableSchema != null ? tableSchema.hashCode() : 0;
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (columnName != null ? columnName.hashCode() : 0);
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        result = 31 * result + (columnType != null ? columnType.hashCode() : 0);
        result = 31 * result + isSigned;
        result = 31 * result + isUnsigned;
        result = 31 * result + (maxValue != null ? maxValue.hashCode() : 0);
        result = 31 * result + (autoIncrement != null ? autoIncrement.hashCode() : 0);
        result = 31 * result + (autoIncrementRatio != null ? autoIncrementRatio.hashCode() : 0);
        return result;
    }
}
